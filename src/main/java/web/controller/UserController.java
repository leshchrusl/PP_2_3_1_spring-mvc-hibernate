package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import web.models.User;
import web.service.UserService;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String getAllUsers(Model model) {

        model.addAttribute("users",
                userService.getAllUsers());

        return "users";
    }

    @GetMapping("/add")
    public String getAddUserPage(@ModelAttribute("user")
                                  User user) {
        return "add";
    }

    @PostMapping("/")
    public String addUser(@ModelAttribute("user")
                             User user) {

        userService.createUser(user);

        return "redirect:/";
    }

    @GetMapping("/{id}/update")
    public String getUpdateUserPage(@PathVariable("id") int id,
                             Model model) {

        model.addAttribute("user",
                userService.getUserById(id));

        return "update";
    }

    @PostMapping("/{id}")
    public String updateUser(@ModelAttribute("user")
                             User user,
                             @PathVariable int id) {

        userService.updateUser(user, id);

        return "redirect:/";
    }

    @GetMapping("/{id}/delete")
    public String deleteUser(@PathVariable int id) {

        userService.deleteUserById(id);

        return "redirect:/";
    }

}
