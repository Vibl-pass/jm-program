package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import java.util.List;

public class UserDaoHibernateImpl extends Util implements UserDao {
    public UserDaoHibernateImpl() {

        }

    @Override
    public void createUsersTable() {
        Session session = getSessionFactory();
        session.beginTransaction();
        String sql = "CREATE TABLE IF NOT EXISTS USERS (\n" +
                "  ID bigint NOT NULL AUTO_INCREMENT,\n" +
                "  NAME varchar(255) NOT NULL,\n" +
                "  LASTNAME varchar(255) NOT NULL,\n" +
                "  AGE tinyint NOT NULL,\n" +
                "  PRIMARY KEY (ID))";
        session.createSQLQuery(sql).executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void dropUsersTable() {
        Session session = getSessionFactory();
        session.beginTransaction();
        String sql = "DROP TABLE IF EXISTS USERS";
        session.createSQLQuery(sql).executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Session session = getSessionFactory();
        session.beginTransaction();
        User user = new User();
        user.setName(name);
        user.setLastName(lastName);
        user.setAge(age);
        session.save(user);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void removeUserById(long id) {
        Session session = getSessionFactory();
        session.beginTransaction();
        String sql ="DELETE FROM USERS WHERE ID="+id;
        session.createSQLQuery(sql).executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<User> getAllUsers() {
        Session session = getSessionFactory();
        session.beginTransaction();
        String sql = "SELECT * FROM USERS";
        List<User> list = session.createNativeQuery(sql).addEntity(User.class).list();
        session.getTransaction().commit();
        session.close();
        return list;
    }

    @Override
    public void cleanUsersTable() {
        Session session = getSessionFactory();
        session.beginTransaction();
        String sql = "DELETE FROM USERS";
        session.createSQLQuery(sql).executeUpdate();
        session.getTransaction().commit();
        session.close();
    }
}
