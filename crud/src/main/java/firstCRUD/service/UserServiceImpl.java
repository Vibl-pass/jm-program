package firstCRUD.service;

import firstCRUD.dao.UserDao;
import firstCRUD.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    private UserDao userDao;
    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    public void addUser(User user) {
        userDao.addUser(user);
    }

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }


    @Transactional
    public void deleteUser(long id) {
        userDao.deleteUser(id);
    }

    public User findUser(long id) {
        return userDao.findUser(id);
    }

    @Transactional
    public void updateUser(User user) {
        userDao.updateUser(user);
    }
}
