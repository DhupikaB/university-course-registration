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
public class CourseDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Course> getAllCourses() {
        String sql = "SELECT * FROM courses";
        return jdbcTemplate.query(sql, new CourseRowMapper());
    }

    private static class CourseRowMapper implements RowMapper<Course> {
        public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
            Course course = new Course();
            course.setCourseId(rs.getInt("course_id"));
            course.setName(rs.getString("name"));
            course.setInstructor(rs.getString("instructor"));
            course.setCredits(rs.getInt("credits"));
            return course;
        }
    }
}
