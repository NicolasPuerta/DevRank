package com.Proyect.ToDoList.service.impl;

import com.Proyect.ToDoList.model.dao.UserDao;
import com.Proyect.ToDoList.model.dto.UserDto;
import com.Proyect.ToDoList.model.entity.User;
import com.Proyect.ToDoList.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserImplService implements IUserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    @Override
    public User save(UserDto userDto) {
        User user = User.builder()
                .id(userDto.getId())
                .username(userDto.getUsername())
                .password(userDto.getPassword())
                .build();
        return userDao.save(user);
    }

    @Transactional(readOnly = true)
    @Override
    public User findById(Long id) {
        return userDao.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void delete(User user) {
        userDao.delete(user);
    }

    @Override
    public boolean existsById(Long id) {
        return userDao.existsById(id);
    }
}
