package com.Proyect.ToDoList.model.dao;

import com.Proyect.ToDoList.model.entity.Task;
import com.Proyect.ToDoList.model.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface TaskDao extends CrudRepository<Task, Long> {
    List<Task> findByUserId(Optional<User> user);
}
