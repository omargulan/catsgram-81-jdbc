package org.example.catsgram81jdbc.dao;

import org.example.catsgram81jdbc.model.User;

import java.util.List;

public interface UserDao {
    List<User> findall();
    User findById(int id);
    User create(User user);
}
