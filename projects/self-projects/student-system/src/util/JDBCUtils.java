package util;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class JDBCUtils {
    private static HikariDataSource hikariDataSource;

    static{
        try{
            Properties properties = new Properties();
            InputStream inputStream = JDBCUtils.class.getClassLoader().getResourceAsStream("hikari.properties");

            properties.load(inputStream);

            HikariConfig hikariConfig = new HikariConfig(properties);
            hikariDataSource = new HikariDataSource(hikariConfig);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws Exception{
        return hikariDataSource.getConnection();
    }
}
