package com.example.user_namagment.service;

import com.example.user_namagment.dto.TaskDTO;
import com.example.user_namagment.entity.Task;
import com.example.user_namagment.repositrory.TaskRepo;
import com.example.user_namagment.repositrory.UserRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TaskService {
    @Autowired
    private TaskRepo taskRepo;
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    public List<Task> getAllTasks(){
        List<Task> taskList =taskRepo.findAll();
        return modelMapper.map(taskList,new TypeToken<List<TaskDTO>>(){}.getType());
    }

    public Boolean addTask(Task task){
        taskRepo.save(task);
        return true;
    }

    public List<TaskDTO> getTasksByUserId(int userId) {
        List<Task> taskList= taskRepo.findByUser_id(userId);
        return modelMapper.map(taskList,new TypeToken<List<TaskDTO>>(){}.getType());
    }



}
