package com.study.base02;

import org.junit.Test;

import java.sql.*;

public class JDBCOperation {
    @Test
    public void testQuerySingleRowAndCol() throws SQLException {
        //1.注册驱动（可省略）
        //2.获取连接
        Connection connection = DriverManager.getConnection("jdbc:mysql:///study_sql", "root", "123456");

        //3.预编译sql语句，得到PreparedStatement对象
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT COUNT(*) as count FROM student");

        //4.执行sql语句，获取结果
        ResultSet resultSet = preparedStatement.executeQuery();

        //5.处理结果
        while(resultSet.next()){
            int count = resultSet.getInt("count");
            System.out.println(count);
        }
        //6.释放资源
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }

    @Test
    public void testQuerySingleRow() throws SQLException {
        //1.注册驱动

        //2.获取连接
        Connection connection = DriverManager.getConnection("jdbc:mysql:///study_sql", "root", "123456");

        //3.预编译sql语句，获得PreparedStatement的对象
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM student where id = ?");

        //4.为占位符赋值，执行，并接收结果
        preparedStatement.setInt(1,1);
        ResultSet resultSet = preparedStatement.executeQuery();

        //5.处理结果
        while(resultSet.next()){
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");
            System.out.println(id+"\t"+name+"\t"+age);
        }

        //6.资源释放
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }

    @Test
    public void testQueryMoreRow() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql:///study_sql", "root", "123456");
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM student WHERE age > ?");
        //为占位符赋值，执行sql语句，接收结果
        preparedStatement.setInt(1, 5);
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");
            System.out.println(id+"\t"+name+"\t"+age);
        }
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }

    @Test
    public void testInsert() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql:///study_sql", "root", "123456");

        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO student(name,age) VALUES(?,?)");

        preparedStatement.setString(1,"狗蛋");
        preparedStatement.setInt(2,29);

        int result = preparedStatement.executeUpdate();

        //根据受影响行数，做判断，得到成功或失败
        if(result>0){
            System.out.println("成功");
        }else{
            System.out.println("失败");
        }
        preparedStatement.close();
        connection.close();
    }

    @Test
    public void testUpdate() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql:///study_sql", "root", "123456");

        PreparedStatement preparedStatement = connection.prepareStatement("update student set age = ? where id = ?");

        preparedStatement.setInt(1,18);
        preparedStatement.setInt(2,1);

        int result = preparedStatement.executeUpdate();

        if(result>0){
            System.out.println("成功");
        }else{
            System.out.println("失败");
        }
        preparedStatement.close();
        connection.close();
    }

    @Test
    public void testDelete() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql:///study_sql","root","123456");

        PreparedStatement preparedStatement = connection.prepareStatement("delete from student where id =  ?");

        preparedStatement.setInt(1,4);

        int result = preparedStatement.executeUpdate();

        if(result > 0){
            System.out.println("成功");
        }else{
            System.out.println("失败");
        }

        preparedStatement.close();
        connection.close();
    }


}
