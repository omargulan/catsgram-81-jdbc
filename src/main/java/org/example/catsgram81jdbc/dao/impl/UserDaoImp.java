package org.example.catsgram81jdbc.dao.impl;

import lombok.AllArgsConstructor;
import org.example.catsgram81jdbc.dao.UserDao;
import org.example.catsgram81jdbc.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class UserDaoImp implements UserDao {
    @Override
    public List<User> findall() {
        return List.of();
    }

    @Override
    public User findById(int id) {
        return null;
    }

    @Override
    public User create(User user) {
        return null;
    }
}
