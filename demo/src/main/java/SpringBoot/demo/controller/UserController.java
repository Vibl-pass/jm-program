package SpringBoot.demo.controller;

import SpringBoot.demo.model.User;
import SpringBoot.demo.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class UserController {

    private final UserServiceImpl userServiceImpl;
    @Autowired
    public UserController(UserServiceImpl userServiceImpl){
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping(value = "/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping(value = "/user")
    public ModelAndView userPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user/user");
        modelAndView.addObject("currentUser", userServiceImpl.getCurrentUser());
        return modelAndView;
    }

    @GetMapping(value = "/admin")
    public ModelAndView adminPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/admin");
        modelAndView.addObject("users", userServiceImpl.listUsers());
        modelAndView.addObject("currentUser", userServiceImpl.getCurrentUser());
        return modelAndView;
    }

    @GetMapping(value = "/admin/add")
    public ModelAndView addPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/add");
        modelAndView.addObject("currentUser", userServiceImpl.getCurrentUser());
        return modelAndView;
    }

    @PostMapping(value = "/admin/add")
    public ModelAndView addUser(@RequestParam String[] user_roles, @ModelAttribute User user) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/admin");
        userServiceImpl.add(user, user_roles);
        return modelAndView;
    }

    @PostMapping(value = "/admin/edit")
    public ModelAndView editUser(@RequestParam String[] user_roles, @ModelAttribute User user) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/admin");
        userServiceImpl.add(user, user_roles);
        return modelAndView;
    }

    @PostMapping(value = "admin/delete/{id}")
    public ModelAndView deleteUser(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/admin");
        userServiceImpl.delete(id);
        return modelAndView;
    }
}
