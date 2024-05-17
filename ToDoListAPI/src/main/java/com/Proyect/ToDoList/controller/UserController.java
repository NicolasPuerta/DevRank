package com.Proyect.ToDoList.controller;

import com.Proyect.ToDoList.model.dto.UserDto;
import com.Proyect.ToDoList.model.entity.User;
import com.Proyect.ToDoList.model.payload.ResponseMessage;
import com.Proyect.ToDoList.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("user")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> create(@RequestBody UserDto userDto){
        User userSave = null;
        try {
           userSave = userService.save(userDto);

            return new ResponseEntity<>(ResponseMessage.builder()
                    .message("El usuario se ha creado correctamente!!")
                    .object(UserDto.builder()
                            .id(userSave.getId())
                            .username(userSave.getUsername())
                            .password(userSave.getPassword())
                            .build())
                    .build()
                    , HttpStatus.CREATED);
        }catch (DataAccessException exDt){
            return new ResponseEntity<>(
                    ResponseMessage.builder()
                            .message(exDt.getMessage())
                            .object(null)
                            .build()
                    , HttpStatus.METHOD_NOT_ALLOWED);
        }
    }

    @PutMapping("user/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> update(@RequestBody UserDto userDto, @PathVariable Long id){
        User userUpdate = null;

        try {
            if (userService.existsById(id)){
                userDto.setId(id);
                userUpdate = userService.save(userDto);
                return new ResponseEntity<>(ResponseMessage.builder()
                        .message("El usuario se ha actualizado correctamente!!")
                        .object(UserDto.builder()
                                .id(userUpdate.getId())
                                .username(userUpdate.getUsername())
                                .password(userUpdate.getPassword())
                                .build())
                        .build()
                        , HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(
                        ResponseMessage.builder()
                                .message("El usuario que intenta actualizar no se encuentra en la base de datos")
                                .object(null)
                                .build()
                        , HttpStatus.NOT_FOUND);
            }
        }catch (DataAccessException exDt){
            return new ResponseEntity<>(
                    ResponseMessage.builder()
                            .message(exDt.getMessage())
                            .object(null)
                            .build()
                    , HttpStatus.METHOD_NOT_ALLOWED);
        }
    }

    @DeleteMapping("user/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> delete(@PathVariable Long id){
        try {
            User findUser = userService.findById(id);
            userService.delete(findUser);
            return new ResponseEntity<>(findUser, HttpStatus.NO_CONTENT);
        }catch (DataAccessException exDt){
            return new ResponseEntity<>(
                    ResponseMessage.builder()
                        .message(exDt.getMessage())
                        .object(null)
                        .build()
                    , HttpStatus.METHOD_NOT_ALLOWED);
        }
    }

    @GetMapping("user/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        User user = userService.findById(id);

        if (user == null){
            return new ResponseEntity<>(
                    ResponseMessage.builder()
                            .message("El usuario que intenta buscar no se encentra en la base  de datos")
                            .object(null)
                            .build()
                    , HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                ResponseMessage.builder()
                        .message("La busqueda se ha realizado correctamente")
                        .object(UserDto.builder()
                                .id(user.getId())
                                .username(user.getUsername())
                                .password(user.getPassword())
                                .build())
                        .build()
                , HttpStatus.OK);
    }

}