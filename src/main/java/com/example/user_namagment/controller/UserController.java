package com.example.user_namagment.controller;

import com.example.user_namagment.dto.UserDTO;
import com.example.user_namagment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/getuser")
    public List<UserDTO> getUser(){
        return userService.getAllUsers();
    }
}
