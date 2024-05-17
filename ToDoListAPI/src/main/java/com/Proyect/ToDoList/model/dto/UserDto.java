package com.Proyect.ToDoList.model.dto;

import lombok.*;

@Data
@ToString
@Builder
public class UserDto {

    private Long id;

    private String username;

    private String password;

}
