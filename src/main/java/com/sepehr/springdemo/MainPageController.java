package com.sepehr.springdemo;

import com.sepehr.springdemo.entity.User;
import com.sepehr.springdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/users")
public class MainPageController {

    private UserService service;

    @Autowired
    public void setService(UserService service) {
        this.service = service;
    }

    @GetMapping("/list") // @PostMapping only for post methods
    public String getMainPage(Model model){
        List<User> users = service.getUsers();

        model.addAttribute("users", users);

        return "main";
    }

    @GetMapping("/addingUserList")
    public String addingCustomerList(Model model){
        User user = new User();

        model.addAttribute("user", user);

        return "add-customer";
    }

    @PostMapping("/addUser")
    public String addCustomer(@Valid @ModelAttribute(name = "user") User user, BindingResult result){

        if (result.hasErrors())
            return "add-customer";

        service.addUser(user);

        return "redirect:/users/list";
    }

    @RequestMapping("/updateUser")
    public String updateUser(@RequestParam("userId")Integer id, Model model){
        User user = service.getUserById(id);

        model.addAttribute("user", user);

        return "add-customer";
    }

    @RequestMapping("/deleteUser")
    public String deleteUser(@RequestParam("userId")Integer id){
        User user = service.getUserById(id);

        service.delete(user);

        return "redirect:/users/list";
    }


}
