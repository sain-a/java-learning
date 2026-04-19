package util;

import dao.StudentDao;
import dao.impl.StudentDaoImpl;
import org.junit.Test;
import pojo.Student;

import java.util.List;

public class StudentDaoTest {
    @Test
    public void testFindAll(){
        StudentDao studentDao = new StudentDaoImpl();
        List<Student> students = studentDao.findAll();

        students.forEach(student -> System.out.println(student));
    }

    @Test
    public void testFindById(){
        StudentDao studentDao = new StudentDaoImpl();
        Student student = studentDao.findById(1);
        System.out.println(student);
    }

    @Test
    public void testInsert(){
        Student student = new Student(null,"杨过",27);
        StudentDao studentDao = new StudentDaoImpl();
        System.out.println(studentDao.findById(studentDao.insert(student)));
    }

    @Test
    public void testUpdate(){
        Student student = new Student(6,"郭靖",30);
        StudentDao studentDao = new StudentDaoImpl();
        studentDao.update(student);
        System.out.println(studentDao.findById(student.getId()));
    }

    @Test
    public void testDelete(){
        StudentDao studentDao = new StudentDaoImpl();
        studentDao.deleteById(7);
    }
}
