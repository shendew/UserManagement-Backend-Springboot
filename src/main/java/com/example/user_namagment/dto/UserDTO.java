package com.example.user_namagment.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
    //data transfer object
    private int id;
    private String name;
    private int age;
    private List<TaskDTO> tasks;

}
