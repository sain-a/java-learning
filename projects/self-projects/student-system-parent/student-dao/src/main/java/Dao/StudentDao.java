package Dao;

import pojo.Student;

import java.util.List;

public interface StudentDao {
    List<Student> findAll();
    Student findById(int id);
    int insert(Student student);
    int update(Student student);
    int deleteById(int id);
}
