package com.university;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;

public class DBtest {
    public static void main(String[] args) {
        try {
            ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

            DataSource dataSource = (DataSource) context.getBean("dataSource");
            Connection conn = dataSource.getConnection();

            if (conn != null) {
                System.out.println("✅ Database connection successful!");
                conn.close();
            } else {
                System.out.println("❌ Failed to connect.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

