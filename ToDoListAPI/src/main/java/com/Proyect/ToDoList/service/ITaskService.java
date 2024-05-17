package com.Proyect.ToDoList.service;

import com.Proyect.ToDoList.model.dto.TaskDto;
import com.Proyect.ToDoList.model.dto.UserDto;
import com.Proyect.ToDoList.model.entity.Task;

import java.util.List;

public interface ITaskService {
    Task save(TaskDto taskDto);
    Task findById(Long id);
    void delete(Task task);
    boolean existById(Long id);
    List<Task> getTasksByUser(Long userId);
}
