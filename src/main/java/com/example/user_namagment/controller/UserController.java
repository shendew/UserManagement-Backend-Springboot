package com.example.user_namagment.controller;

import com.example.user_namagment.dto.UserDTO;
import com.example.user_namagment.entity.User;
import com.example.user_namagment.repositrory.UserRepo;
import com.example.user_namagment.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/")
@RequiredArgsConstructor

public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/getuser")
    public List<User> getAllUsers() {
        return (userService.getAllUsers());
    }

    @PostMapping("/adduser")
    public String addUser(@RequestBody User user){
        return userService.addUser(user)?"User added":"User adding failed";
    }

}
