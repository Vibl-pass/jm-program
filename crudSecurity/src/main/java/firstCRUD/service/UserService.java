package firstCRUD.service;

import firstCRUD.model.Role;
import firstCRUD.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Set;

public interface UserService {
    void createUser(User user);
    List<User> getAllUsers();
    void updateUser(User user);
    void deleteUser(Long id);
    User getUserByName(String name);
    User getUserById(Long id);
    void createRole(Set<Role> roles);
    Set<Role> getAllRoles();
}