package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl extends Util implements UserDao {


    public void createUsersTable() {
        Connection connection = getConnection();
        String sql = "CREATE TABLE IF NOT EXISTS USERS (\n" +
                "  ID bigint NOT NULL AUTO_INCREMENT,\n" +
                "  NAME varchar(255) NOT NULL,\n" +
                "  LASTNAME varchar(255) NOT NULL,\n" +
                "  AGE tinyint NOT NULL,\n" +
                "  PRIMARY KEY (ID))";
        try (Statement statement = connection.createStatement()){
            statement.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void dropUsersTable() {
        Connection connection = getConnection();
        String sql = "DROP TABLE IF EXISTS USERS";
        try (Statement statement = connection.createStatement()){
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        Connection connection = getConnection();
        String sql;
        sql = "INSERT INTO USERS (NAME, LASTNAME, AGE)VALUES(?, ?, ?)";
        try(PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setString(2, lastName);
            ps.setByte(3, age);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void removeUserById(long id) {
        Connection connection = getConnection();
        String sql = "DELETE FROM USERS WHERE ID=?";

       try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
           preparedStatement.setLong(1, id);
           preparedStatement.executeUpdate();
       }
       catch(SQLException e){
           e.printStackTrace();
       }
       finally {
           try {
               connection.close();
           } catch (SQLException e) {
               e.printStackTrace();
           }
       }
       }

    public List<User> getAllUsers() {
        List<User> usersList = new ArrayList<>();
        String sql = "SELECT ID, NAME, LASTNAME, AGE " +
                "FROM USERS";
        try (Connection connection = getConnection()){
            Statement statement = connection.createStatement();
            try (ResultSet resultSet = statement.executeQuery(sql)) {
                while (resultSet.next()) {
                    User user = new User();
                    user.setId(resultSet.getLong("ID"));
                    user.setName(resultSet.getString("NAME"));
                    user.setLastName(resultSet.getString("LASTNAME"));
                    user.setAge(resultSet.getByte("AGE"));
                    usersList.add(user);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usersList;
    }

    public void cleanUsersTable() {
        Connection connection = getConnection();
        String sql = "DELETE FROM USERS";
        try(Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
