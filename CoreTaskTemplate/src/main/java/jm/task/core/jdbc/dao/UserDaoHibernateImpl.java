package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserDaoHibernateImpl extends Util implements UserDao {
    public UserDaoHibernateImpl() {

        }

    @Override
    public void createUsersTable() {
        String sql = "CREATE TABLE IF NOT EXISTS USERS (\n" +
                "  ID bigint NOT NULL AUTO_INCREMENT,\n" +
                "  NAME varchar(255) NOT NULL,\n" +
                "  LASTNAME varchar(255) NOT NULL,\n" +
                "  AGE tinyint NOT NULL,\n" +
                "  PRIMARY KEY (ID))";
        try (Session session = getSessionFactory()) {
            try {
                session.beginTransaction();
                session.createSQLQuery(sql).executeUpdate();
                session.getTransaction().commit();
            } catch (Exception e) {
                session.getTransaction().rollback();
                e.printStackTrace();
            }
        }
    }

    @Override
    public void dropUsersTable() {
        String sql = "DROP TABLE IF EXISTS USERS";
        try (Session session = getSessionFactory()) {
            try {
                session.beginTransaction();
                session.createSQLQuery(sql).executeUpdate();
                session.getTransaction().commit();
            } catch (Exception e) {
                session.getTransaction().rollback();
                e.printStackTrace();
            }
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        try (Session session = getSessionFactory()) {
            try {
                session.beginTransaction();
                User user = new User();
                user.setName(name);
                user.setLastName(lastName);
                user.setAge(age);
                session.save(user);
                session.getTransaction().commit();
            } catch (Exception e) {
                session.getTransaction().rollback();
                e.printStackTrace();
            }
        }
    }

    @Override
    public void removeUserById(long id) {
        String sql ="DELETE FROM USERS WHERE ID="+id;
        try (Session session = getSessionFactory()) {
            try {
                session.beginTransaction();
                session.createSQLQuery(sql).executeUpdate();
                session.getTransaction().commit();
            } catch (Exception e) {
                session.getTransaction().rollback();
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<User> getAllUsers() {
        String sql = "SELECT * FROM USERS";
        List<User> list = null;
        try (Session session = getSessionFactory()) {
            try {
                session.beginTransaction();
                list = session.createNativeQuery(sql).addEntity(User.class).list();
                session.createSQLQuery(sql).executeUpdate();
                session.getTransaction().commit();
            } catch (Exception e) {
                session.getTransaction().rollback();
                e.printStackTrace();
            }
        }
        return list;
    }

    @Override
    public void cleanUsersTable() {
        String sql = "DELETE FROM USERS";
        try (Session session = getSessionFactory()) {
            try {
                session.beginTransaction();
                session.createSQLQuery(sql).executeUpdate();
                session.getTransaction().commit();
            } catch (Exception e) {
                session.getTransaction().rollback();
                e.printStackTrace();
            }
        }
    }
}
