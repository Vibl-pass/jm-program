package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }


   @Override
   @Transactional
   @SuppressWarnings("unchecked")
      public List<User> findUserByCar(String model, int series) {
         TypedQuery<User> query = sessionFactory.openSession()
                 .createQuery("from User user where user.car.model = :modelName and user.car.series = :seriesInt");
         query.setParameter("modelName", model);
         query.setParameter("seriesInt", series);
         return query.getResultList();
   }
}
