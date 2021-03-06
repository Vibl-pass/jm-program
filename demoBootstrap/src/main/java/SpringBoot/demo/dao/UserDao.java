package SpringBoot.demo.dao;

import SpringBoot.demo.model.User;

import java.util.List;

public interface UserDao {
    List<User> listAllUsers();
    void add(User user);
    void delete(Long id);
    User showUser (Long id);
    List<User> findUserByUsername(String username);
    User getUserByName(String name);
}
