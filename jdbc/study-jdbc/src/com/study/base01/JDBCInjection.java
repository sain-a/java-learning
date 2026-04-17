package com.study.base01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCInjection {
    public static void main(String[] args) throws  Exception {
        //1.注册驱动(可省略)
        //2.获取连接对象
        Connection connection = DriverManager.getConnection("jdbc:mysql:///study_sql", "root", "123456");

        //3.获取执行SQL语句对象
        Statement statement = connection.createStatement();

        System.out.println("请输入学生姓名：");
        Scanner sc = new Scanner(System.in);
        String sname = sc.nextLine();

        //4.编写SQL语句，并执行，接收返回的结果
        String sql = "SELECT * FROM student WHERE name = '"+sname+"'";
        ResultSet resultSet = statement.executeQuery(sql);

        //5.处理结果，处理resultSet
        while(resultSet.next()){
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");
            System.out.println(id+"\t"+name+"\t"+age);
        }
        //6.释放资源
        resultSet.close();
        statement.close();
        connection.close();
    }
}
