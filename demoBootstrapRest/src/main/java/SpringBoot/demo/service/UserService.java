package SpringBoot.demo.service;

import SpringBoot.demo.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User add(User user);
    List<User> listUsers();
    User showUser (Long id);
    void delete(Long id);
    User findUserByUsername(String username);
}
