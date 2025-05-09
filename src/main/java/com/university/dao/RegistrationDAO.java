package com.university.dao;

import com.university.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class RegistrationDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public boolean isAlreadyRegistered(int studentId, int courseId) {
        String sql = "SELECT COUNT(*) FROM registrations WHERE student_id = ? AND course_id = ?";
        Object[] params = new Object[]{studentId, courseId};
        int count = jdbcTemplate.queryForObject(sql, params, Integer.class);

        if (count > 0) {
            return true;
        } else {
            return false;
        }

    }

    public void registerCourse(int studentId, int courseId) {
        String sql = "INSERT INTO registrations (student_id, course_id) VALUES (?, ?)";
        jdbcTemplate.update(sql, studentId, courseId);
    }

    public List<Course> getAllCourses() {
        String sql = "SELECT * FROM courses";
        return jdbcTemplate.query(sql, new RowMapper<Course>() {
            public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
                Course course = new Course();
                course.setCourseId(rs.getInt("course_id"));
                course.setName(rs.getString("name"));
                course.setInstructor(rs.getString("instructor"));
                course.setCredits(rs.getInt("credits"));
                return course;
            }
        });
    }
}
