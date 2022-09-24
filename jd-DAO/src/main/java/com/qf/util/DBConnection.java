package com.qf.util;


import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
public class DBConnection {



        public static void main(String[] args) {System.out.println("hello, world");}
        private static final Properties PROPERTIES = new Properties();//封装需要连接的信息对象
        private static final ThreadLocal<Connection> THREAD_LOCAL = new ThreadLocal<>();//本地线程共享
        private static DataSource dataSource;
        static {
            try {
                //加载资源文件
                InputStream inputStream = DBConnection.class.getResourceAsStream("/druid.properties");
                //将资源文件数据封装到集合
                PROPERTIES.load(inputStream);
                dataSource = DruidDataSourceFactory.createDataSource(PROPERTIES);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        public static DataSource getDataSource(){
            return dataSource;
        }

        /**
         * 获得连接
         *
         * @return
         * @throws SQLException
         */
        public static Connection getConnection() throws SQLException {
            Connection connection = THREAD_LOCAL.get();// 在线程共享集合对象中获取连接
            // 如果没有获取到则去连接池中获取连接
            if(connection == null){
                connection =dataSource.getConnection();
                THREAD_LOCAL.set(connection);
            }
            return connection;
        }
        /**
         * 关闭连接
         *
         * @throws SQLException
         */
        public static void close() throws SQLException {
            Connection connection = THREAD_LOCAL.get();
            if(connection!=null){
                connection.close();
                THREAD_LOCAL.remove();
            }
        }








    }
