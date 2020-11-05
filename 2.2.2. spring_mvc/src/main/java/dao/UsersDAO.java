package dao;

import model.User;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface UsersDAO {
    List<User> allUsers();
    void add(User user);
    void delete(User user);
    void edit(User user);
    User getById(int id);
}
