package com.university.controller;

import com.university.dao.RegistrationDAO;
import com.university.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;

@Controller
public class RegistrationController {

    @Autowired
    private RegistrationDAO registrationDAO;

    @PostMapping("/registerCourse")
    public String registerCourse(@RequestParam("courseId") int courseId,
                                 HttpSession session,
                                 HttpServletRequest request) {

        Student student = (Student) session.getAttribute("student");
        int studentId = student.getStudentId();

        if (registrationDAO.isAlreadyRegistered(studentId, courseId)) {
            System.out.println("Student ID " + studentId + " already registered for course ID " + courseId);
            request.setAttribute("error", "You have already registered for this course.");
        } else {
            registrationDAO.registerCourse(studentId, courseId);
            System.out.println("Student ID " + studentId + " succesfully registered for course ID " + courseId);
            request.setAttribute("message", "Course registered succesfully!");
        }


        request.setAttribute("courses", registrationDAO.getAllCourses());
        return "courses";
    }

}

