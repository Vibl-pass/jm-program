package jm.task.core.jdbc.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.Properties;

public class Util {
    private static SessionFactory sessionFactory = buildSessionFactory();

    protected static SessionFactory buildSessionFactory() {
        Properties prop = new Properties();
        prop.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&verifyServerCertificate=false");
        prop.setProperty("dialect", "org.hibernate.dialect.MySQL");
        prop.setProperty("hibernate.connection.username", "root");
        prop.setProperty("hibernate.connection.password", "gthdfcjk2013");
        prop.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
        prop.setProperty("hibernate.connection.mapping", "jm.task.core.jdbc.model.User");
        sessionFactory = new Configuration().addProperties(prop).addAnnotatedClass(jm.task.core.jdbc.model.User.class).buildSessionFactory();
        return sessionFactory;
    }

    public static Session getSessionFactory() {
        Session session = sessionFactory.openSession();
        return session;

    }

    public static void shutDown(){
        getSessionFactory().close();
    }
}
