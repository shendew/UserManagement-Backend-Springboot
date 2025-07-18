package com.example.user_namagment.service;

import com.example.user_namagment.dto.UserDTO;
import com.example.user_namagment.entity.User;
import com.example.user_namagment.repositrory.UserRepo;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    public List<User> getAllUsers() {
        List<User> userList=userRepo.findAll();
        return modelMapper.map(userList,new TypeToken<List<UserDTO>>(){}.getType());
    }

    public Optional<User> findUserById(Integer userId) {
        return userRepo.findById(userId);
    }



    public Boolean addUser(User user){
        userRepo.save(user);
        return true;
    }

    public Boolean updateUser(UserDTO userDTO){
        userRepo.save(modelMapper.map(userDTO, User.class));
        return true;
    }

    public Boolean deleteUser(Integer userID){
        userRepo.deleteById(userID);
        return true;
    }


}
