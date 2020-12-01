package SpringBoot.demo.dao;

import SpringBoot.demo.model.User;

import java.util.List;

public interface UserDao {
    List<User> listAllUsers();
    User add(User user);
    void delete(Long id);
    User showUser (Long id);
    User findUserByUsername(String username);
}
