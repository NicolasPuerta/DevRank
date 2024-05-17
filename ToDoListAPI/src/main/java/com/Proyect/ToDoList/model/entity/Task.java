package com.Proyect.ToDoList.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Table(name = "Tasks")
public class Task implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(nullable = false)
    private String title;

    private String description;

    private Date dueDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TaskState state;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User userId;
}
