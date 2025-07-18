package com.example.user_namagment.controller;

import com.example.user_namagment.dto.TaskDTO;
import com.example.user_namagment.entity.Task;
import com.example.user_namagment.entity.User;
import com.example.user_namagment.repositrory.UserRepo;
import com.example.user_namagment.service.TaskService;
import com.example.user_namagment.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/")
@RequiredArgsConstructor
public class TaskController {
    @Autowired
    private TaskService taskService;

    @Autowired
    private UserService userService;


    @Autowired
    private UserRepo userRepo;

    @GetMapping("/gettasts")
    public List<Task> getAllTasks(){
        return taskService.getAllTasks();
    }
    @PostMapping("/addtask/{userId}")
    public String addTask(@PathVariable int userId,@RequestBody Task task) {
        User user = userRepo.findById(userId).orElse(null);
        if (user != null) {
            task.setUser(user);
            taskService.addTask(task);
            return "Task added";
        }
        return "User not found";
    }

    @PostMapping("/tasks/{userId}")
    public List<TaskDTO> getUserTasks(@PathVariable int userId) {

        return taskService.getTasksByUserId(userId);
    }
}
