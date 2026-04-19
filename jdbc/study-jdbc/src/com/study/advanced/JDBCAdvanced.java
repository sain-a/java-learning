package com.study.advanced;

import com.study.advanced.pojo.Student;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCAdvanced {

    @Test
    public void testORM() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql:///study_sql", "root", "123456");

        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM student where id = ?");

        preparedStatement.setInt(1,1);

        ResultSet resultSet = preparedStatement.executeQuery();

        Student student = null;

        if(resultSet.next()){
            student = new Student();
            //为对象属性赋值
            student.setStudentId(resultSet.getInt("id"));
            student.setStudentName(resultSet.getString("name"));
            student.setStudentAge(resultSet.getInt("age"));
        }
        System.out.println(student);

        resultSet.close();
        preparedStatement.close();
        connection.close();
    }

    @Test
    public void testORMList() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql:///study_sql", "root", "123456");

        PreparedStatement preparedStatement = connection.prepareStatement("select * from student");

        ResultSet resultSet = preparedStatement.executeQuery();

        Student student = null;

        List<Student> studentList = new ArrayList<>();

        while(resultSet.next()){
            student = new Student();
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");

            student.setStudentId(id);
            student.setStudentName(name);
            student.setStudentAge(age);
            //将每次循环封装的一行的对象存储在集合里
            studentList.add(student);
        }

        studentList.forEach(student1 -> System.out.println(student1));

        resultSet.close();
        preparedStatement.close();
        connection.close();
    }

    @Test
    public  void testReturnPK() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql:///study_sql", "root", "123456");

        //预编译SQL语句,告知prepareStatement，返回新增数据的主键列值
        String sql = "INSERT INTO student(name,age) VALUES(?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        //创建对象，将对象的属性值，天冲在?占位符上（ORM）
        Student student = new Student(null,"孙策",28);
        preparedStatement.setString(1,student.getStudentName());
        preparedStatement.setInt(2,student.getStudentAge());

        int result = preparedStatement.executeUpdate();
        ResultSet resultSet = null;
        if(result>0){
            System.out.println("成功");

            //获取当前新增数据的主键列，回显到Java中Student对象的studentId属性上
            //返回的主键值是一个单行单列的结果存储在ResultSet里
            resultSet = preparedStatement.getGeneratedKeys();
            if(resultSet.next()){
                int studentId = resultSet.getInt(1);
                student.setStudentId(studentId);
            }

            System.out.println(student);
        }else{
            System.out.println("失败");
        }

        if(resultSet!=null){
            resultSet.close();
        }
        preparedStatement.close();
        connection.close();
    }

    @Test
    public void testMoreInsert() throws Exception {
        //1.注册驱动
//        Class.forName("com.mysql.cj.jdbc.Driver");

        //2.获取连接
        Connection connection = DriverManager.getConnection("jdbc:mysql:///study_sql", "root", "123456");

        //3.编写SQL语句
        String sql = "INSERT INTO student(name,age) VALUES(?,?)";

        //4.创建预编译prepareStatement，传入SQL语句
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        //获取当前代码执行的时间。毫秒值
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            //5.为占位符赋值
            preparedStatement.setString(1, "张飞"+i);
            preparedStatement.setInt(2,24+i);

            preparedStatement.executeUpdate();
        }
        long end = System.currentTimeMillis();
        System.out.println("消耗时间："+(end-start));

        preparedStatement.close();
        connection.close();
    }

    @Test
    public void testBatch() throws SQLException {
         //1.注册驱动
//     Class.forName("com.mysql.cj.jdbc.Driver");
         //2.获取连接
         Connection connection = DriverManager.getConnection("jdbc:mysql:///study_sql?rewriteBatchedStatements=true", "root", "123456");

         //3.编写SQL语句
        /*
        TODO 注意：1.必须在连接数据库的URL后面追加?rewriteBatchedStatements=true
                  2.新增SQL必须用VALUES，且语句最后不要追加;结束
                  3.调用addBatch方法，将SQL语句进行批量添加的操作
                  4.统一执行批量操作，调用executeBatch()
         */
         String sql = "INSERT INTO student(name,age) VALUES(?,?)";

         //4.创建预编译prepareStatement，传入SQL语句
         PreparedStatement preparedStatement = connection.prepareStatement(sql);

         //获取当前代码执行的时间毫秒值
         long start = System.currentTimeMillis();

         for (int i = 0; i < 10000; i++) {
             //5.为占位符赋值
             preparedStatement.setString(1, "张飞"+i);
             preparedStatement.setInt(2,24+i);
             preparedStatement.addBatch();
         }
         //执行批量操作
        preparedStatement.executeBatch();

         long end = System.currentTimeMillis();
         System.out.println("消耗时间："+(end-start));

         preparedStatement.close();
         connection.close();
     }
}
