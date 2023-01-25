package com.slow;

import org.junit.Test;
import utils.JDBCUtils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PreparedStatement {
    @Test
    public void test() throws SQLException, IOException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("用户名：");
        String name = scanner.nextLine();
        System.out.println("密码:");
        String pwd = scanner.nextLine();

        Connection connection = JDBCUtils.getConnection();
        String sql = "select * from customers where name = ? and email = ? ";
        java.sql.PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, pwd);
        ResultSet resultSet = preparedStatement.executeQuery(sql);
        if (!resultSet.next()){
            System.out.println(1);
        }else {
            System.out.println(2);
        }
        JDBCUtils.closerResource(connection, preparedStatement, resultSet);
    }
}
