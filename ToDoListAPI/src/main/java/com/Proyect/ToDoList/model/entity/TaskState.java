package com.Proyect.ToDoList.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum TaskState {
    WITHOUT_STARTING("Without starting"),
    CURRENT("Current"),
    COMPLETE("Complete");

    @Getter
    private final String displayName;

}
