package crud.controller;

import crud.model.User;
import crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/users")
    public String getAllUsers(ModelMap model) {
        List<User> userList = userService.getAllUsers();
        model.addAttribute("users", userList);
        return "users";
    }

    @PostMapping(value = "/users/newUser")
    public String createUser (User user) {
        userService.createUser(user);
        return "redirect:/users";
    }

    @PostMapping(value = "/users/delete/{id}")
    public String deleteUser (@PathVariable int id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }

    @GetMapping(value = "/users/edit/{id}")
    public String editUser (@PathVariable int id, Model model) {
    model.addAttribute("user", userService.getUser(id));
        return "/edit";
    }

    @PostMapping(value = "/users/updateUser")
    public String updateUser(@ModelAttribute User user) {
        userService.updateUser(user);
        return "redirect:/users";
    }
}
