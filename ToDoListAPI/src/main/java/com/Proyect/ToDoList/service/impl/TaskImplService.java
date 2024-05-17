package com.Proyect.ToDoList.service.impl;

import com.Proyect.ToDoList.model.dao.TaskDao;
import com.Proyect.ToDoList.model.dao.UserDao;
import com.Proyect.ToDoList.model.dto.TaskDto;
import com.Proyect.ToDoList.model.entity.Task;
import com.Proyect.ToDoList.model.entity.User;
import com.Proyect.ToDoList.service.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TaskImplService implements ITaskService {

    @Autowired
    private TaskDao taskDao;

    @Autowired
    private UserDao userDao;

    @Transactional
    @Override
    public Task save(TaskDto taskDto) {
        Task task = Task.builder()
                .id(taskDto.getId())
                .title(taskDto.getTitle())
                .description(taskDto.getDescription())
                .dueDate(taskDto.getDueDate())
                .state(taskDto.getState())
                .userId(taskDto.getUserId())
                .build();
        return taskDao.save(task);
    }

    @Transactional(readOnly = true)
    @Override
    public Task findById(Long id) {
        return taskDao.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void delete(Task task) {
        taskDao.delete(task);
    }

    @Override
    public boolean existById(Long id) {
        return taskDao.existsById(id);
    }

    @Override
    public List<Task> getTasksByUser(Long userId) {
        Optional<User> user = userDao.findById(userId);
        return taskDao.findByUserId(user);
    }
}
