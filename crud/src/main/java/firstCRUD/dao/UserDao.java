package firstCRUD.dao;

import firstCRUD.model.User;

import java.util.List;

public interface UserDao {
    void addUser(User user);
    List<User> getAllUsers();
    void deleteUser(long id);
    User findUser(long id);
    void updateUser(User user);
}