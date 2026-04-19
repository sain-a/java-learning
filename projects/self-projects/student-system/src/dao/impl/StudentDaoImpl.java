package dao.impl;

import dao.StudentDao;
import pojo.Student;
import util.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class StudentDaoImpl implements StudentDao {
    @Override
    public List<Student> findAll() {
        List<Student> list = new ArrayList<>();
        String sql = "SELECT * FROM student";
        try(
            Connection connection = JDBCUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
        ){
            while (resultSet.next()){
                Student student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setAge(resultSet.getInt("age"));
                list.add(student);
            }
        } catch (Exception e) {
            throw new RuntimeException("数据库操作失败",e);
        }
        return list;
    }

    @Override
    public Student findById(int id) {
        String sql = "SELECT * FROM student WHERE id = ?";
        try (
                Connection connection = JDBCUtils.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)

        ){
            preparedStatement.setInt(1,id);
            try(
            ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Student student = new Student();
                    student.setId(resultSet.getInt("id"));
                    student.setName(resultSet.getString("name"));
                    student.setAge(resultSet.getInt("age"));
                    return student;
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("数据库操作失败",e);
        }
        return null;
    }

    @Override
    public int insert(Student student) {
        String sql = "INSERT INTO student(name,age) VALUES(?,?)";
        try(
                Connection connection = JDBCUtils.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)
        ) {
            preparedStatement.setString(1, student.getName());
            preparedStatement.setInt(2, student.getAge());
            int result = preparedStatement.executeUpdate();
            try (ResultSet resultSet = preparedStatement.getGeneratedKeys()){
                if (result > 0) {
                    if (resultSet.next()) {
                        student.setId(resultSet.getInt(1));
                        return resultSet.getInt(1);
                    }
                }
            }
        }catch (Exception e){
            throw new RuntimeException("数据库操作失败",e);
        }
        return 0;
    }

    @Override
    public int update(Student student) {
        String sql = "UPDATE student SET name = ?, age = ? WHERE id =?";
        try(
                Connection connection = JDBCUtils.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ){
            preparedStatement.setString(1,student.getName());
            preparedStatement.setInt(2,student.getAge());
            preparedStatement.setInt(3,student.getId());
            int result = preparedStatement.executeUpdate();
            if (result > 0) {
                return result;
            }
        }catch (Exception e){
            throw new RuntimeException("数据库操作失败",e);
        }
        return 0;
    }

    @Override
    public int deleteById(int id) {
        String sql = "DELETE FROM student WHERE id = ?";
        try (
                Connection connection = JDBCUtils.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ){
            preparedStatement.setInt(1,id);
            int result = preparedStatement.executeUpdate();
            if(result>0){
                return result;
            }
        } catch (Exception e) {
            throw new RuntimeException("数据库操作失败",e);
        }
        return 0;
    }
}
