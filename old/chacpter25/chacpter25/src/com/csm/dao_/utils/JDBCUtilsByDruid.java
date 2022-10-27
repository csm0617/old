package com.csm.dao_.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @Author 快乐小柴
 * @Date 2022/9/22 16:43
 * @Version 1.0
 * 基于druid数据库连接池工具类
 */
public class JDBCUtilsByDruid {
    //在静态代码款中完成 ds的初始化
     private static DataSource ds;
     static {
         Properties properties = new Properties();
         try {
             properties.load(new FileInputStream("src\\druid.properties"));
             ds= DruidDataSourceFactory.createDataSource(properties);
         } catch (Exception e) {
             throw new RuntimeException(e);
         }
     }
     //编写getConnection方法
    public static Connection getConnection() throws SQLException {
         return ds.getConnection();
    }

    //关闭连接，！！！在数据库连接池中，close不是真的断掉连接
    //而是把使用的Connection对象放回到连接池中。
    public static void close(ResultSet resultSet, Statement statement, Connection connection){
         if (resultSet!=null){
             try {
                 resultSet.close();
                 if (statement!=null){
                     statement.close();
                 }
                 if (connection!=null){
                     connection.close();
                 }
             } catch (SQLException e) {
                 throw new RuntimeException(e);
             }
         }

    }

}
