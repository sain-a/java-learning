package com.example.hellospringboot.dao;


import com.example.hellospringboot.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Student> findAll() {
        String sql = "select * from student";
        return jdbcTemplate.query(sql,(rs, rowNum) -> {
            return new Student(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("age")
            );
        });
    }

    public Student findById(int id){
        String sql = "select * from student where id = ?";
        List<Student> list = jdbcTemplate.query(sql,(rs,rowNum) ->
            new  Student(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("age")
            )
        ,id);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);
    }

    public int insert(Student student){
        String sql = " insert into student(name,age) values(?,?)";
        return jdbcTemplate.update(sql,student.getName(),student.getAge());
    }

    public int update(Integer id,Student student){
        String sql = "update student set name = ?,age = ? where id = ?";
        return jdbcTemplate.update(sql,student.getName(),student.getAge(),id);
    }

    public int delete(Integer id){
        String sql = "delete from student where id = ?";
        return jdbcTemplate.update(sql,id);
    }
}
