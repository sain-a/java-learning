package com.example.userservice.dao;

import com.example.userservice.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<User> FindAll()
    {
        String sql = "select * from user";
        return jdbcTemplate.query(sql,(rs,rowNum)->{
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setAge(rs.getInt("age"));
            user.setEmail(rs.getString("email"));
            return user;
        });
    }

    public User findById(Integer id){
        String sql = "select * from user where id = ?";
        List<User> list = jdbcTemplate.query(sql,(rs,rowNum)->
            new User(
                    rs.getInt("id"),
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getInt("age"),
                    rs.getString("email")
            ),id);
        return list.isEmpty()?null:list.get(0);
    }

    public int insert(User user) {
        String sql = "insert into user(username,password,age,email) values(?,?,?,?)";
        return jdbcTemplate.update(sql,
                user.getUsername(),
                user.getPassword(),
                user.getAge(),
                user.getEmail());
    }
    public int update(Integer id,User user) {
        String sql = "update user set username=?,age=?,email=? where id=?";
        return jdbcTemplate.update(sql,
                user.getUsername(),
                user.getAge(),
                user.getEmail(),
                id);
    }
    public int delete(Integer id) {
        String sql = "delete from user where id=?";
        return jdbcTemplate.update(sql,id);
    }
}
