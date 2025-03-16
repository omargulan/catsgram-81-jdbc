package org.example.catsgram81jdbc.model;

import lombok.Data;

@Data
public class Post {
    private int id;
    private String description;
    private String photoUrl;
    private User user;
}
