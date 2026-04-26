package com.example.hellospringboot.service;

import com.example.hellospringboot.dao.StudentDao;
import com.example.hellospringboot.exception.BusinessException;
import com.example.hellospringboot.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentDao studentDao;

    public List<Student> findAll(){
        return studentDao.findAll();
    }

    public Student findById(int id){
        Student student = studentDao.findById(id);
        if(student == null){
            throw new BusinessException("学生不存在");
        }
        return student;
    }

    public boolean addStudent(Student student){
        if(student == null){
            return false;
        }
        if (student.getName()==null||student.getName().trim().isEmpty()){
            return false;
        }
        if (student.getAge()==null||student.getAge()==0){
            return false;
        }
        return studentDao.insert(student)>0;
    }

    public boolean updateStudent(Integer id,Student student){
        if (id == null || id <= 0) {
            return false;
        }

        if (student == null) {
            return false;
        }

        if (student.getName() == null || student.getName().trim().isEmpty()) {
            return false;
        }

        if (student.getAge() == null || student.getAge() <= 0) {
            return false;
        }

        if(student == null){
            return false;
        }
        Student oldStudent = studentDao.findById(id);
        if(oldStudent == null){
            return false;
        }
        return studentDao.update(id,student)>0;
    }
    public boolean deleteStudent(Integer id){
        if(id == null || id<=0){
            return false;
        }
        Student student = studentDao.findById(id);
        if(student == null){
            return false;
        }
        return studentDao.delete(id)>0;
    }
}
