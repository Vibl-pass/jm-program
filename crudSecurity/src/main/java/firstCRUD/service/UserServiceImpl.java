package firstCRUD.service;

import firstCRUD.dao.RoleDao;
import firstCRUD.dao.UserDao;
import firstCRUD.model.Role;
import firstCRUD.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    public UserServiceImpl() {}

    @Transactional
    @Override
    public void createUser(User user) {
        userDao.createUser(user);
    }


    @Transactional
    @Override
    public User getUserById(Long id) {
        return (User) userDao.getUserById(id);
    }

    @Override
    @Transactional
    @SuppressWarnings("unchecked")
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }


    @Transactional
    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }


    @Transactional
    @Override
    public void deleteUser(Long id) {
        userDao.deleteUser(id);
    }

    @Transactional
    @Override
    public User getUserByName(String name) {
        return userDao.getUserByName(name);
    }

    @org.springframework.transaction.annotation.Transactional
    @Override
    public void createRole(Set<Role> roles) {
        roleDao.createRole(roles);
    }

    @Transactional
    @Override
    public Set<Role> getAllRoles() {
        return roleDao.getAllRoles();
    }
}
