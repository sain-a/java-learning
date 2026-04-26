package Dao.impl;


import Dao.StudentDao;
import pojo.Student;
import util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
public class StudentDaoImpl implements StudentDao {


    @Override
    public List<Student> findAll() {
        List<Student> studentList = new ArrayList<>();
        String sql = "SELECT * FROM student ORDER BY id";
        try(
            Connection connection = JDBCUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery()
        ){
            while (resultSet.next()){
                Student student = new Student(resultSet.getInt("id"),resultSet.getString("name"),resultSet.getInt("age"));
                studentList.add(student);
            }

        } catch (Exception e) {
            throw new RuntimeException("数据库操作失败");
        }
        return studentList;
    }

    @Override
    public Student findById(int id) {
        String sql = "SELECT * FROM student WHERE id = ?";
        try(
                Connection connection = JDBCUtils.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ){
            preparedStatement.setInt(1,id);
           try(
                ResultSet resultSet = preparedStatement.executeQuery()
           ){
             while (resultSet.next()){
                 Student student = new Student(resultSet.getInt("id"),resultSet.getString("name"),resultSet.getInt("age"));
                 return student;
             }
           }
        }catch (Exception e){
            throw new RuntimeException("数据库操作失败");
        }
        return null;
    }

    @Override
    public int insert(Student student) {
        String sql = "INSERT INTO student(name,age) VALUES(?,?) ";
        try(
             Connection connection = JDBCUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ){
            preparedStatement.setString(1,student.getName());
            preparedStatement.setInt(2,student.getAge());
            int result = preparedStatement.executeUpdate();
            if (result>0){
                return result;
            }
        }catch (Exception e){
            throw new RuntimeException("数据库操作失败");
        }
        return 0;
    }

    @Override
    public int update(Student student){
        String sql = "UPDATE student SET name = ?, age = ? WHERE id = ?";
        try(
                Connection connection = JDBCUtils.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)
                ) {
            preparedStatement.setString(1,student.getName());
            preparedStatement.setInt(2,student.getAge());
            preparedStatement.setInt(3,student.getId());
            int result = preparedStatement.executeUpdate();
            if(result>0){
                return result;
            }
        }catch (Exception e){
            throw new RuntimeException("数据库操作失败");
        }
        return 0;
    }
    @Override
    public int deleteById(int id) {
        String sql = "DELETE FROM student WHERE id = ?";
        try(
                Connection connection = JDBCUtils.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)
                ){
            preparedStatement.setInt(1,id);
            int result = preparedStatement.executeUpdate();
            if(result>0){
                return result;
            }
        }catch (Exception e){
            throw new RuntimeException("数据库操作失败");
        }
        return 0;
    }
}

