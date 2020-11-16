package firstCRUD.dao;

import firstCRUD.model.Role;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository("roleDao")
public class RoleDaoImpl implements RoleDao {

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    @Override
    public void createRole(Set<Role> roles) {
        roles.forEach(role -> entityManager.persist(role));
    }

    @Transactional
    @Override
    public Set<Role> getAllRoles() {
        Set<Role> setRoles = new HashSet<>();
        List<Role> listRoles= entityManager
                .createQuery("select r from Role r")
                .getResultList();
        setRoles.addAll(listRoles);
        return setRoles;
    }
}
