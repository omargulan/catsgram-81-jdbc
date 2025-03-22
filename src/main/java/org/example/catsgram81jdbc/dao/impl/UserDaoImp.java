package org.example.catsgram81jdbc.dao.impl;

import lombok.AllArgsConstructor;
import org.example.catsgram81jdbc.dao.UserDao;
import org.example.catsgram81jdbc.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;

@Component
@AllArgsConstructor
public class UserDaoImp implements UserDao {
    private final JdbcTemplate jdbcTemplate;
    @Override
    public List<User> findAll() {
        String sql = "select * from users";

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
    }

    @Override
    public User findById(int id) {
        String sql = "select * from users where id = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class), id)
                .stream()
                .findFirst()
                .orElseThrow();
    }

    @Override
    public User create(User user) {
        SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("users")
                .usingGeneratedKeyColumns("id");


        Map<String, Object> map = Map.of("name", user.getName());
        int id = insert.executeAndReturnKey(map).intValue();
        user.setId(id);


        return user;
    }

    @Override
    public User update(User user) {
        String sql = "update users set name = ? where id = ?";
        int rowsAffected = jdbcTemplate.update(sql, user.getName(), user.getId());
        if (rowsAffected==0){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND); //404
        }
        return user;
    }

    @Override
    public void delete(int id) {
        String sql = "delete from users where id = ?";
        jdbcTemplate.update(sql, id);
    }


}
