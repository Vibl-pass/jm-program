package firstCRUD.dao;

import firstCRUD.model.Role;

import java.util.Set;

public interface RoleDao {
    void createRole(Set<Role> roles);
    Set<Role> getAllRoles();
}