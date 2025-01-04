package learning.formation.Services;

import learning.formation.Entities.Admin;

public interface AuthService {
    String authenticate(String username, String password);

    Admin registerAdmin(Admin admin);

}
