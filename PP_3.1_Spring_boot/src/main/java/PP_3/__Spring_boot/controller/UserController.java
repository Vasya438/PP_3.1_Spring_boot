package PP_3.__Spring_boot.controller;


import PP_3.__Spring_boot.model.User;
import PP_3.__Spring_boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getAllUsers(Model model) {
        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @GetMapping("/addUser")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "addUser";
    }

    @PostMapping("/addUser")
    public String addUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/users";
    }

    @GetMapping("/update")
    public String update(@RequestParam("id") Integer id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/users";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("id") int id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }
}