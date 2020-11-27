package SpringBoot.demo.controller;

import SpringBoot.demo.model.User;
import SpringBoot.demo.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    private final UserService userService;

    public RestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/users")
    public ResponseEntity<List<User>> allUsers() {
        List<User> users = userService.listUsers();

        return users != null
                ? new ResponseEntity<>(users, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/users/{id}")
    public ResponseEntity<User> userById(@PathVariable Long id) {
        User user = userService.showUser(id);

        return user != null
                ? new ResponseEntity<>(user, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/users")
    public HttpStatus newUser(@RequestBody User user) {
        return userService.add(user)
                ? HttpStatus.OK
                : HttpStatus.NOT_MODIFIED;
    }

    @PutMapping(value = "/users")
    public HttpStatus editUser(@RequestBody User user) {
        return userService.add(user)
                ? HttpStatus.OK
                : HttpStatus.NOT_MODIFIED;
    }

    @DeleteMapping(value = "/users")
    public HttpStatus deleteUser(@RequestBody Long id) {
        return userService.delete(id)
                ? HttpStatus.OK
                : HttpStatus.NOT_MODIFIED;
    }
}
