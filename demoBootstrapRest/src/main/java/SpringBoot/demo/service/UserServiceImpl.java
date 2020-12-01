package SpringBoot.demo.service;

import SpringBoot.demo.dao.RoleRepository;
import SpringBoot.demo.dao.UserDao;
import SpringBoot.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{

    private final UserDao userDao;
    private final RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(UserDao userDao, RoleRepository roleRepository){
        this.roleRepository = roleRepository;
        this.userDao = userDao;
    }

    @Transactional
    @Override
    public List<User> listUsers() {
        return userDao.listAllUsers();
    }
    @Transactional
    @Override
    public User add(User user) {
        user.setRoles(
                user.getRoles()
                        .stream()
                        .map(role -> roleRepository.findByRole(role.getRole()))
                        .collect(Collectors.toList())
        );
       return userDao.add(user);
    }
    @Transactional
    @Override
    public void delete(Long id) {
        userDao.delete(id);
    }
    @Transactional
    @Override
    public User findUserByUsername(String username) {
        return userDao.findUserByUsername(username);
    }
    @Transactional
    @Override
    public User showUser(Long id) {
        return userDao.showUser(id);
    }

    @Transactional
    public User getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        return findUserByUsername(username);
    }

}
