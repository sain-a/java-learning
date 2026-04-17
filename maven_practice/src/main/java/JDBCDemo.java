import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import static com.mysql.cj.conf.PropertyKey.allowPublicKeyRetrieval;

public class JDBCDemo {
    public static void main(String[] args) {
        try{
            //1.数据库连接信息
            String url = "jdbc:mysql://localhost:3306/study_sql?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
            String user = "root";
            String password = "123456"; // ← 改成你自己的密码

            // 2. 建立连接
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("连接成功！");

            // 3. 创建执行SQL对象
            Statement stmt = conn.createStatement();

            //插入数据
            String sql = "INSERT INTO student(name,age) VALUES('王五',23)";
            int result = stmt.executeUpdate(sql);

            System.out.println("插入成功"+result);

            // 4. 执行SQL
            ResultSet rs = stmt.executeQuery("SELECT * FROM student");

            // 5. 处理结果
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");

                System.out.println(id + " " + name + " " + age);
            }

            // 6. 关闭资源
            rs.close();
            stmt.close();
            conn.close();
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
}
