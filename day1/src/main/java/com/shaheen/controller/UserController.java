package com.shaheen.controller;

import com.shaheen.exception.BadRequestExpection;
import com.shaheen.exception.NotFoundException;
import com.shaheen.model.User;
import com.shaheen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping({"/",""})
    public String getAll(Model model) {
        List<User> users = userService.findAll();
        if (!users.isEmpty()) {
            model.addAttribute("users",users);
        } else {
            model.addAttribute("users",new ArrayList<User>(0));
        }
    return "users";
    }

    @GetMapping("/{id}")
    public String getById(@Valid @PathVariable("id") Long id,Model model ) {
        User user = userService.findById(id);
        if (user != null) {
            model.addAttribute("user",user);
        } else {
            model.addAttribute("user",new User());
        }
        return "user";
    }

//    @PostMapping
//    public String createUser(@Valid @RequestBody User user) {
//        user = userService.save(user);
//        if (user.getId() > 0) {
//            return new ResponseEntity<>(user, HttpStatus.CREATED);
//        } else {
//            throw new BadRequestExpection("user Already exists");
//        }
//    }
//
//    @PutMapping
//    public ResponseEntity<User> updateUser(@Valid @RequestBody User user) {
//        if (user.getId() != null && user.getId() > 0) {
//            user = userService.update(user);
//            return new ResponseEntity<>(user, HttpStatus.OK);
//        } else {
//            throw new BadRequestExpection(String.format("can't find user with id (%s) on our db", user.getId()));
//        }
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity updateUser(@Valid @PathVariable("id") Long id) {
//        User user = userService.findById(id);
//        if (user != null) {
//            userService.delete(user);
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } else {
//            throw new NotFoundException("user not founded");
//        }
//    }

}
