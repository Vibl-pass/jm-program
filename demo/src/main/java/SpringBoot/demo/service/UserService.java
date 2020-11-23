package SpringBoot.demo.service;

import SpringBoot.demo.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    void add(User user, String[] roles);
    List<User> listUsers();
    User showUser (Long id);
    void delete(Long id);
    List<User> findUserByUsername(String username);
    User getUserByName(String name);
}
