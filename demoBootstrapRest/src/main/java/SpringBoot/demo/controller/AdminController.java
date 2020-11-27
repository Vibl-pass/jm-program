package SpringBoot.demo.controller;

import SpringBoot.demo.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {

    private final UserServiceImpl userServiceImpl;
    @Autowired
    public AdminController(UserServiceImpl userServiceImpl){
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping(value = "/admin")
    public ModelAndView adminPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin");
        modelAndView.addObject("users", userServiceImpl.listUsers());
        modelAndView.addObject("currentUser", userServiceImpl.getCurrentUser());
        return modelAndView;
    }
}
