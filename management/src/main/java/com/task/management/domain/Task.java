package com.task.management.domain;

import com.task.management.enums.Status;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Task {

    @Id
    private String title;
    private String description;
    @Column(name = "\"from\"")
    private LocalDateTime from;
    @Column(name = "\"to\"")
    private LocalDateTime to;

    @Enumerated(EnumType.STRING)
    private Status status;
}

