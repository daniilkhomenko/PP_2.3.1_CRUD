package crud.controller;

import crud.model.User;
import crud.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

//    @GetMapping(value = "/users") //version1
    @RequestMapping(value = "/users", method = RequestMethod.GET) //version2
    public String getAllUsers(ModelMap model) {
        List<User> userList = userService.getAllUsers();
        model.addAttribute("users", userList);
        return "users";
    }

//    @PostMapping(value = "/users/newUser") //version1
    @RequestMapping(value = "/users/newUser", method = RequestMethod.POST) //version2
    public String createUser (User user) {
        userService.createUser(user);
        return "redirect:/users";
    }

//    @PostMapping(value = "/users/delete/{id}") //version1
    @RequestMapping(value = "/users/delete/{id}", method = RequestMethod.POST) //version2
    public String deleteUser (@PathVariable int id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }

//    @GetMapping(value = "/users/edit/{id}") //version1
    @RequestMapping(value = "/users/edit/{id}", method = RequestMethod.GET) //version2
    public String editUser (@PathVariable int id, Model model) {
    model.addAttribute("user", userService.getUser(id));
        return "/edit";
    }

//    @PostMapping(value = "/users/updateUser") //version1
    @RequestMapping(value = "/users/updateUser", method = RequestMethod.POST) //version2
    public String updateUser(@ModelAttribute User user) {
        userService.updateUser(user);
        return "redirect:/users";
    }
}
