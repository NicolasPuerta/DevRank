package com.Proyect.ToDoList.model.dao;

import com.Proyect.ToDoList.model.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User, Long> {
}
