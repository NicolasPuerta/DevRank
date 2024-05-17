package com.Proyect.ToDoList.model.dto;

import com.Proyect.ToDoList.model.entity.TaskState;
import com.Proyect.ToDoList.model.entity.User;
import lombok.*;
import java.util.Date;

@Data
@ToString
@Builder
public class TaskDto {

    private Long id;

    private String title;

    private String description;

    private Date dueDate;

    private TaskState state;

    private User userId;
}
