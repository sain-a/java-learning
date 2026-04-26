package com.example.hellospringboot.controller;

import com.example.hellospringboot.common.Result;
import com.example.hellospringboot.dao.StudentDao;
import com.example.hellospringboot.pojo.Student;
import com.example.hellospringboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public Result<List<Student>> findAll() {
        List<Student> list = studentService.findAll();
        return Result.success(list);

    }

    @GetMapping("/students/{id}")
    public Result<Student> findById(@PathVariable Integer id) {
        return Result.success(studentService.findById(id));
    }

    @PostMapping("/students")
    public Result<String> addStudent(@RequestBody Student student) {
        boolean flag = studentService.addStudent(student);
        if(flag){
            return Result.success("success");
        }else {
            return Result.error("fail");
        }
    }

    @PutMapping("/students/{id}")
    public Result<String> updateStudent(@PathVariable Integer id, @RequestBody Student student) {
        boolean flag = studentService.updateStudent(id,student);
        if(flag){
            return Result.success("success");
        }else {
            return Result.error("fail");
        }
    }

    @DeleteMapping("/students/{id}")
    public Result<String> deleteStudent(@PathVariable Integer id) {
        boolean flag = studentService.deleteStudent(id);
        if(flag){
            return Result.success("success");
        }else  {
            return Result.error("fail");
        }
    }

    @GetMapping("/students/search")
    public Result<List<Student>> search(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Integer age){
        System.out.println(name);
        System.out.println(age);
        return Result.success(null);
    }

}
