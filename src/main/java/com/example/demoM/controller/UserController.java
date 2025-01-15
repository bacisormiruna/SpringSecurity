package com.example.demoM.controller;

import com.example.demoM.dto.UserDto;
import com.example.demoM.model.RegistrationRequest;
import com.example.demoM.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    public String getUsers(Model model){
        List<UserDto> userDtos = userService.getAllUsers();
        model.addAttribute("title", "Users");
        model.addAttribute("users", userDtos);
        return "users";
    }
    @GetMapping("/users/{id}")
    public UserDto getUserById(@PathVariable Integer id){
        return userService.getUserById(id);
    }

    @PostMapping("/users/create")
    public String createUser(RegistrationRequest registrationRequest, Model model) {
        if (userService.checkEmail(registrationRequest.getEmailAddress())) {
            model.addAttribute("error", "Email already in use!");
            return "createUser";
        }

        userService.registerUser(registrationRequest);
        return "redirect:";
    }

    @GetMapping("/users/create")
    public String createUserForm(Model model) {
        model.addAttribute("title", "Create New User");
        return "createUser";
    }
}
