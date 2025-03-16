package org.example.catsgram81jdbc.dao;

import org.example.catsgram81jdbc.model.Post;

import java.util.List;

public interface PostDao {
    List<Post> findAll();
    Post findById(int id);
    Post create(Post post);
}
