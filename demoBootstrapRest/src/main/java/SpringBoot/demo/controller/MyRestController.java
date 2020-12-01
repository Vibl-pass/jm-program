package SpringBoot.demo.controller;

import SpringBoot.demo.model.User;
import SpringBoot.demo.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyRestController {

    private final UserService userService;

    public MyRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/users")
    public ResponseEntity<List<User>> allUsers() {
        List<User> users = userService.listUsers();
        if(users != null){
            return new ResponseEntity<>(users, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/users/{id}")
    public ResponseEntity<User> userById(@PathVariable Long id) {
        User user = userService.showUser(id);
        if(user != null){
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/users")
    public User newUser(@RequestBody User user) {
        return userService.add(user);
    }

    @PutMapping(value = "/users")
    public User editUser(@RequestBody User user) {
        return userService.add(user);
    }

    @DeleteMapping(value = "/users")
    public  void deleteUser(@RequestBody Long id) {
        userService.delete(id);
    }
}
