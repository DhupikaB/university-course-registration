package com.university.controller;

import com.university.dao.CourseDAO;
import com.university.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CourseController {

    @Autowired
    private CourseDAO courseDAO;

    @GetMapping("/courses")
    public String showCoursesPage(Model model) {
        List<Course> courseList = courseDAO.getAllCourses();
        model.addAttribute("courses", courseList);
        return "courses";
    }
}
