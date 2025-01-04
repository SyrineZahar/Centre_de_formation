package learning.formation.ServicesImpl;

import learning.formation.Entities.Admin;
import learning.formation.Repository.AdminRepository;
import learning.formation.Repository.FormationRepository;
import learning.formation.Services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminRepository adminRepository;

    @Override
    public Admin getAdminByUsername(String username) {
        return adminRepository.findByUsername(username);
    }

}
