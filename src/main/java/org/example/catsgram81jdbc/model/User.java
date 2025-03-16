package org.example.catsgram81jdbc.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class User {
    private int id;
    private String name;
    private String login;
    private LocalDateTime created_at;
}
