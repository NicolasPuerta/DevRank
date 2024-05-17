package com.Proyect.ToDoList.controller;

import com.Proyect.ToDoList.model.dto.TaskDto;
import com.Proyect.ToDoList.model.entity.Task;
import com.Proyect.ToDoList.model.payload.ResponseMessage;
import com.Proyect.ToDoList.service.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1")
public class TaskController {

        @Autowired
        private ITaskService taskService;

        @PostMapping("task")
        @ResponseStatus(HttpStatus.CREATED)
        public ResponseEntity<?> create(@RequestBody TaskDto taskDto) {
                Task taskCreate = null;
                try {
                        taskCreate = taskService.save(taskDto);

                        return new ResponseEntity<>(ResponseMessage.builder()
                                        .message("La tarea se ha creado correctamente")
                                        .object(TaskDto.builder()
                                                        .id(taskCreate.getId())
                                                        .title(taskCreate.getTitle())
                                                        .description(taskCreate.getDescription())
                                                        .dueDate(taskCreate.getDueDate())
                                                        .state(taskCreate.getState())
                                                        .userId(taskCreate.getUserId())
                                                        .build())
                                        .build(), HttpStatus.CREATED);
                } catch (DataAccessException exDt) {
                        return new ResponseEntity<>(
                                        ResponseMessage.builder()
                                                        .message(exDt.getMessage())
                                                        .object(null)
                                                        .build(),
                                        HttpStatus.METHOD_NOT_ALLOWED);
                }
        }

        @PutMapping("task/{id}")
        @ResponseStatus(HttpStatus.CREATED)
        public ResponseEntity<?> update(@RequestBody TaskDto taskDto, @PathVariable Long id) {
                Task taskUpdate = null;
                try {
                        if (taskService.existById(id)) {
                                taskDto.setId(id);
                                taskUpdate = taskService.save(taskDto);
                                return new ResponseEntity<>(ResponseMessage.builder()
                                                .message("La tarea se ha actualizado correctamente")
                                                .object(TaskDto.builder()
                                                                .id(taskUpdate.getId())
                                                                .title(taskUpdate.getTitle())
                                                                .description(taskUpdate.getDescription())
                                                                .dueDate(taskUpdate.getDueDate())
                                                                .state(taskUpdate.getState())
                                                                .userId(taskUpdate.getUserId())
                                                                .build())
                                                .build(), HttpStatus.CREATED);
                        } else {
                                return new ResponseEntity<>(
                                                ResponseMessage.builder()
                                                                .message("La tarea que intenta actualizar no se encuentra en la base de datos")
                                                                .object(null)
                                                                .build(),
                                                HttpStatus.NOT_FOUND);
                        }
                } catch (DataAccessException exDt) {
                        return new ResponseEntity<>(
                                        ResponseMessage.builder()
                                                        .message(exDt.getMessage())
                                                        .object(null)
                                                        .build(),
                                        HttpStatus.METHOD_NOT_ALLOWED);

                }
        }

        @DeleteMapping("task/{id}")
        @ResponseStatus(HttpStatus.NO_CONTENT)
        public ResponseEntity<?> delete(@PathVariable Long id) {
                try {
                        Task findTask = taskService.findById(id);
                        taskService.delete(findTask);
                        return new ResponseEntity<>(findTask, HttpStatus.NO_CONTENT);
                } catch (DataAccessException exDt) {
                        return new ResponseEntity<>(
                                        ResponseMessage.builder()
                                                        .message(exDt.getMessage())
                                                        .object(null)
                                                        .build(),
                                        HttpStatus.METHOD_NOT_ALLOWED);
                }
        }

        @GetMapping("task/{id}")
        public ResponseEntity<?> findById(@PathVariable Long id) {
                Task task = taskService.findById(id);
                if (task == null) {
                        return new ResponseEntity<>(
                                        ResponseMessage.builder()
                                                        .message("La tarea que intenta buscaro no se encuentra en la base de datos")
                                                        .object(null)
                                                        .build(),
                                        HttpStatus.NOT_FOUND);
                }
                return new ResponseEntity<>(
                                ResponseMessage.builder()
                                                .message("La busqueda se ha realizado correctamente!!")
                                                .object(TaskDto.builder()
                                                                .id(task.getId())
                                                                .title(task.getTitle())
                                                                .description(task.getDescription())
                                                                .dueDate(task.getDueDate())
                                                                .state(task.getState())
                                                                .userId(task.getUserId())
                                                                .build())
                                                .build(),
                                HttpStatus.OK);
        }

        @GetMapping("task/user/{userId}")
        public ResponseEntity<?> getTasksByUser(@PathVariable Long userId) {
                List<Task> taskList = taskService.getTasksByUser(userId);

                if (taskList.isEmpty()) {
                        return new ResponseEntity<>(
                                        ResponseMessage.builder()
                                                        .message("No se encontraron tareas")
                                                        .object(null)
                                                        .build(),
                                        HttpStatus.NOT_FOUND);
                }

                return new ResponseEntity<>(
                                ResponseMessage.builder()
                                                .message("Búsqueda realizada correctamente")
                                                .object(taskList)
                                                .build(),
                                HttpStatus.OK);
        }

}
