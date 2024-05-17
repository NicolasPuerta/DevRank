package com.Proyect.ToDoList.service;

import com.Proyect.ToDoList.model.dto.UserDto;
import com.Proyect.ToDoList.model.entity.User;

public interface IUserService {

    User save(UserDto userDto);

    User findById(Long id);

    void delete(User user);

    boolean existsById(Long id);
}
