package com.study.base02;

import java.sql.*;
import java.util.Scanner;

public class JDBCPrepared {
    public static void main(String[] args) throws Exception {
        //1.注册驱动(可省略)
        //2.获取连接对象
        Connection connection = DriverManager.getConnection("jdbc:mysql:///study_sql", "root", "123456");

        //3.获取执行SQL语句对象
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM student WHERE name = ?");

        System.out.println("请输入学生姓名：");
        Scanner sc = new Scanner(System.in);
        String studentname = sc.nextLine();

        //4.为?占位符赋值，并执行sql语句，接收返回的结果
        preparedStatement.setString(1,studentname);
        ResultSet resultSet = preparedStatement.executeQuery();

        //5.处理结果，处理resultSet
        while(resultSet.next()){
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");
            System.out.println(id+"\t"+name+"\t"+age);
        }
        //6.释放资源
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
}