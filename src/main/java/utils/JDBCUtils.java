package utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
    //操作数据库的工具类
    public static Connection getConnection() throws IOException, ClassNotFoundException, SQLException {
        //获取数据库的连接
        InputStream resourceAsStream = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
        Properties properties = new Properties();
        properties.load(resourceAsStream);
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");
        //加载驱动
        Class.forName(driver);
        //获取连接
        Connection connection = DriverManager.getConnection(url, user, password);
        return connection;
    }

    //关闭资源操作
    public static void closerResource(Connection conn, PreparedStatement ps) {
        try {
            if (ps != null) {
                ps.close();

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closerResource(Connection conn, PreparedStatement ps, ResultSet rs){
        try {
            if (ps != null) {
                ps.close();

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
