package org.example.catsgram81jdbc.dao.impl;

import lombok.AllArgsConstructor;
import org.example.catsgram81jdbc.dao.PostDao;
import org.example.catsgram81jdbc.model.Post;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@AllArgsConstructor
public class PostDaoImp implements PostDao {
    @Override
    public List<Post> findAll() {
        return List.of();
    }

    @Override
    public Post findById(int id) {
        return null;
    }

    @Override
    public Post create(Post post) {
        return null;
    }
}
