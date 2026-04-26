package service.impl;

import Dao.StudentDao;
import Dao.impl.StudentDaoImpl;
import pojo.Student;
import service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    private StudentDao studentDao = new StudentDaoImpl();
    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }

    @Override
    public Student findById(int id) {
        return studentDao.findById(id);
    }

    @Override
    public boolean addStudent(Student student) {
        if(student == null){
            return false;
        }
        if(student.getName() == null||student.getName().trim().isEmpty()){
            return false;
        }
        if(student.getAge() == null||student.getAge()<0){
            return false;
        }
        return studentDao.insert(student)>0;
    }

    @Override
    public boolean updateStudent(Student student) {
        if(student == null || student.getId() == null){
            return false;
        }
        Student oldStudent = studentDao.findById(student.getId());
        if(oldStudent == null){
            return false;
        }
        return studentDao.update(student)>0;
    }

    @Override
    public boolean deleteById(int id) {
        Student student = studentDao.findById(id);
        if(student == null){
            return false;
        }
        return studentDao.deleteById(id)>0;
    }
}
