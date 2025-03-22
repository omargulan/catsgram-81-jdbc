package org.example.catsgram81jdbc.controller;

import lombok.RequiredArgsConstructor;
import org.example.catsgram81jdbc.dao.UserDao;
import org.example.catsgram81jdbc.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserDao userDao;

    @GetMapping
    public List<User> findAll() {
        return userDao.findAll();
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable int id) {
        return userDao.findById(id);
    }

    @PostMapping
    public User create(@RequestBody User user) {
        return userDao.create(user);
    }

    @PutMapping
    public User update(@RequestBody User user) {
        return userDao.update(user);
    }

    @DeleteMapping("/users/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        userDao.delete(id);
    }

}
