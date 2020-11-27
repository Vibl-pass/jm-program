package SpringBoot.demo.dao;

import SpringBoot.demo.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
@Repository
public class UserDaoImpl implements UserDao{
    @PersistenceContext
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
    public List<User> listAllUsers() {
        return entityManager.createQuery("FROM User").getResultList();
    }

    public void add(User user) {
        if(user.getId() == null) {
            entityManager.persist(user);
        } else entityManager.merge(user);
    }

    public void delete(Long id) {
        entityManager.remove(entityManager.find(User.class, (long)id));
    }

    public User showUser(Long id) {
        return entityManager.find(User.class, (long)id);
    }

    @SuppressWarnings("unchecked")
    public User findUserByUsername(String username) {
        Query query = entityManager.createQuery("FROM User WHERE username = :username");
        query.setParameter("username", username);
        return (User) query.getSingleResult();
    }

}
