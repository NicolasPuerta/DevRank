package com.Proyect.ToDoList.model.payload;

import lombok.*;

import java.io.Serializable;

@Data
@ToString
@Builder
public class ResponseMessage implements Serializable {

    private String message;
    private Object object;
}
