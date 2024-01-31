package st.protok.crudspringboot.PP_3_1_1_CRUD_springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import st.protok.crudspringboot.PP_3_1_1_CRUD_springboot.model.User;
import st.protok.crudspringboot.PP_3_1_1_CRUD_springboot.service.UserService;


import java.util.List;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/showAllUsers")
    public String showAllUsers(Model model) {
        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("allUsers", allUsers);

        return "all-users";
    }

    @GetMapping("/addNewUser")
    public String addNewUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);

        return "user-info";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
            userService.addUser(user);
        return "redirect:/showAllUsers";
    }

    @PostMapping("/updateUser")
    public String updateUser(@ModelAttribute("user") User user) {
            userService.updateUser(user);
        return "redirect:/showAllUsers";
    }

    @GetMapping("/updateInfo/{id}")
    public String updateInfo(@ModelAttribute("id") Long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);

        return "update-user";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@ModelAttribute("id") Long id) {
        userService.removeUser(id);

        return "redirect:/showAllUsers";
    }

    @PostMapping("/generateUsers")
    public String generateUsers() {
        userService.addUser(new User("Simba", "Pecking", "QWE", 1100));
        userService.addUser(new User("Ратмир", "Усманов", "ПАТ", 1200));
        userService.addUser(new User("Кира", "Ван Вогт", "QAZ", 1300));
        userService.addUser(new User("Александр", "Севостьянов", "Kata1", 1400));
        userService.addUser(new User("Джонсон", "Трал", "МЕХ", 1502));
        userService.addUser(new User("Германикус", "Из Стратона", "TP2", 1600));

        return "redirect:/showAllUsers";
    }

}
