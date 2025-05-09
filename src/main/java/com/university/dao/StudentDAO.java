package com.university.dao;

import com.university.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class StudentDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public StudentDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Student validateLogin(String email, String password) {
        try {
            String sql = "SELECT * FROM students WHERE email = ? AND password = ?";
            return jdbcTemplate.queryForObject(sql, new Object[]{email, password}, new StudentRowMapper());
        } catch (EmptyResultDataAccessException e) {
            System.out.println("Login failed: No user found");
            return null;
        } catch (Exception e) {
            System.out.println("Login failed: " + e.getMessage());
            return null;
        }
    }



    class StudentRowMapper implements RowMapper<Student> {
        public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
            Student s = new Student();
            s.setStudentId(rs.getInt("student_id"));
            s.setName(rs.getString("name"));
            s.setEmail(rs.getString("email"));
            s.setPassword(rs.getString("password"));
            return s;
        }
    }
}
