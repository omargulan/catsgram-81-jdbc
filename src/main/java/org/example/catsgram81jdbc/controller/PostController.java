package org.example.catsgram81jdbc.controller;

import lombok.RequiredArgsConstructor;
import org.example.catsgram81jdbc.dao.PostDao;
import org.example.catsgram81jdbc.model.Post;
import org.example.catsgram81jdbc.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {
    private final PostDao postDao;
    @GetMapping
    public List<Post> findAll() {
        return postDao.findAll();
    }

    @GetMapping("/{id}")
    public Post findById(@PathVariable int id) {
        return postDao.findById(id);
    }

    @PostMapping
    public Post create(@RequestBody Post post) {
        return postDao.create(post);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        postDao.deleteById(id);

    }

    public Post mapRow(ResultSet rs, int rowNum) throws SQLException {
        int id = rs.getInt("id");
        String description = rs.getString("description");
        int authorId = rs.getInt("author_id");
        String photoUrl = rs.getString("photo_url");
        LocalDateTime createdAt = rs.getTimestamp("created_at").toLocalDateTime();
        User user = new User(authorId, description, photoUrl, createdAt);
        return new Post(id, description, authorId, authorId, photoUrl, createdAt, user);
    }
}

