package com.csm.dao_.dao;

import com.csm.dao_.utils.JDBCUtilsByDruid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author 快乐小柴
 * @Date 2022/9/23 10:37
 * @Version 1.0
 */
public class BasicDAO<T>{//泛型指定具体类型
    private QueryRunner qr = new QueryRunner();
    //开发通用的dml（增删改）方法，针对任意的表
    public int update(String sql, Object... parameters){
        Connection connection =null;
        try {
            connection = JDBCUtilsByDruid.getConnection();
            int update = qr.update(connection, sql, parameters);
            return update;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtilsByDruid.close(null,null,connection);
        }
    }

    /**
     *
     * @param sql
     * @param clazz 传入一个类的class对象，（因为要通过javabean来创建对象）eg: Actor.class
     * @param parameters 多个sql ？？？的值
     * @return
     */
    //返回多个对象（即查询的结果是多行的），针对任意的表
    public List<T> queryMulti(String sql,Class<T> clazz,Object... parameters){
        Connection connection =null;
        try {
            connection = JDBCUtilsByDruid.getConnection();

           return qr.query(connection,sql,new BeanListHandler<T>(clazz),parameters);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtilsByDruid.close(null,null,connection);
        }
    }
    //查询单行结果的通用方法
    public T querySingle(String sql,Class<T> clazz,Object... parameters){
        Connection connection =null;
        try {
            connection = JDBCUtilsByDruid.getConnection();
            return qr.query(connection,sql,new BeanHandler<T>(clazz),parameters);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtilsByDruid.close(null,null,connection);
        }
    }
    
    //查询单行单列的方法，即返回单值的方法
    public Object queryScalar(String sql,Object... parameters){
        Connection connection =null;
        try {
            connection = JDBCUtilsByDruid.getConnection();
            return qr.query(connection,sql,new ScalarHandler<>(),parameters);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtilsByDruid.close(null,null,connection);
        }
    }
}
