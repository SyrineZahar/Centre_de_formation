package learning.formation.ServicesImpl;

import learning.formation.Entities.Admin;
import learning.formation.Repository.AdminRepository;
import learning.formation.Services.AuthService;
import learning.formation.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String authenticate(String username, String password) {
        Admin admin = adminRepository.findByUsername(username); // Ensure this method is implemented in your repository

        if (admin != null && passwordEncoder.matches(password, admin.getPassword())) {
            return jwtUtil.generateToken(admin.getUsername(), admin.getRole());
        } else {
            return null;
        }
    }
}
