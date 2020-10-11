package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Peter", "Jackson", (byte) 58);
        System.out.println("User с именем – Peter добавлен в базу данных");
        userService.saveUser("Stellan", "Skarsgard", (byte) 69);
        System.out.println("User с именем – Stellan добавлен в базу данных");
        userService.saveUser("Makoto", "Shinkai", (byte) 47);
        System.out.println("User с именем – Makoto добавлен в базу данных");
        userService.saveUser("Amy", "Adams", (byte) 46);
        System.out.println("User с именем – Amy добавлен в базу данных");
        List<User> users = userService.getAllUsers();
        for(User e: users){
            System.out.println(e.toString());
        }
        userService.cleanUsersTable();
        userService.dropUsersTable();
        Util.shutDown();
    }
}
