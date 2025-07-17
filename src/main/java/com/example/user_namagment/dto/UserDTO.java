package com.example.user_namagment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    //data transfer object
    private int id;
    private String name;
    private String age;

}
