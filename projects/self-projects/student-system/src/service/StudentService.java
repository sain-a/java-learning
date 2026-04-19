package service;

import pojo.Student;

import java.util.List;
import java.util.Scanner;

public interface StudentService {
    List<Student> findAll();
    Student findById(int id);
    boolean addStudent(Student student);
    boolean updateStudent(Student student);
    boolean deleteById(int id);
}
