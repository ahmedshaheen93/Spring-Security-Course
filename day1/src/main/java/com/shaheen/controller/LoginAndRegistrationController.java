package com.shaheen.controller;

import com.shaheen.model.Role;
import com.shaheen.model.User;
import com.shaheen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class LoginAndRegistrationController {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login(Model model,
                        @RequestParam(value = "error", required = false) String error) {
        model.addAttribute("user", new User());
        if (error != null) {
            model.addAttribute("errorMessage", "check your email or password");
        }
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
        User userByUsername = (User) userService.loadUserByUsername(user.getUsername());

        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult);
            System.out.println(bindingResult);
            return "registration";
        }
        if (userByUsername != null) {
            FieldError fieldError = new FieldError("user", "username", user.getUsername(), true,
                    new String[]{
                            "unique.user.username"
                    }, new Object[]{0}, "username already existed");
            bindingResult.addError(fieldError);
            System.out.println(bindingResult);
            return "registration";
        }
        userService.save(user, new Role("ROLE_USER"));
        return "redirect:/users";
    }
}
