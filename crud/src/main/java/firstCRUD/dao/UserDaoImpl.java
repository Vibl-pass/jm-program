package firstCRUD.dao;

import firstCRUD.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    EntityManager entityManager;

    public void addUser(User user) {
        entityManager.persist(user);
    }

    @SuppressWarnings("unchecked")
    public List<User> getAllUsers() {
        List<User> users = entityManager.createQuery("from User", User.class)
                .getResultList();
        return users;
    }

    public void deleteUser(long id) {
        User toBeDelete = entityManager.getReference(User.class, id);
        if (toBeDelete != null) {
            entityManager.remove(toBeDelete);
        }
    }
    public User findUser(long id) {
        return entityManager.find(User.class, id);
    }
    public void updateUser(User user) {
        entityManager.merge(user);
    }
}
