package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import web.dao.UserDaoImpl;
import web.models.User;
import web.service.UserService;
import web.service.UserServiceImpl;

import java.util.List;

@Controller
public class UserController {

//    private ApplicationContext applicationContext;
//
//    private UserService userService =
//            applicationContext.getBean(UserService.class);
//
//    @Autowired
//    public UserController(ApplicationContext applicationContext) {
//        this.applicationContext = applicationContext;
//    }

    UserService userService = new UserServiceImpl(new UserDaoImpl());

    @GetMapping(value = "/")
    public String index(Model model) {

        List<User> users = userService.getAllUsers();

        for (User user : users) {
            System.out.println(user);
        }

        model.addAttribute("users", userService.getAllUsers());


        return "users";
    }
}
