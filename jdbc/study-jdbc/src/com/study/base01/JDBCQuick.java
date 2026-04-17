package com.study.base01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCQuick {
    public static void main(String[] args) throws Exception {
        //1.注册驱动
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        DriverManager.registerDriver(new Driver());

        //2.获取连接对象
        String url = "jdbc:mysql://localhost:3306/study_sql";
        String username = "root";
        String password = "123456";
        Connection connection = DriverManager.getConnection(url,username,password);

        //3.获取执行sql语句的对象
        Statement statement = connection.createStatement();

        //编写SQL语句，并执行,以及接受返回的结果集
        String sql = "SELECT * FROM student";
        ResultSet resultSet = statement.executeQuery(sql);

        //5.处理结果：遍历resultSet 结果集
        while(resultSet.next()){
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");
            System.out.println(id+"\t"+name+"\t"+age);
        }

        //6.释放资源（先开后关）
        resultSet.close();
        statement.close();
        connection.close();

    }
}
