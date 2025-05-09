package com.university.controller;

import com.university.dao.StudentDAO;
import com.university.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private StudentDAO studentDAO;


    @GetMapping("/")
    public String redirectToLogin() {
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String handleLogin(@RequestParam("email") String email,
                              @RequestParam("password") String password,
                              HttpSession session,
                              Model model) {

        Student student = studentDAO.validateLogin(email, password);

        if (student != null) {
            session.setAttribute("student", student);
            System.out.println("Login SUCESS for: " + email);
            return "redirect:/courses";
        } else {
            model.addAttribute("error", "Invlid email or pasword.");
            System.out.println("Login FAILED for: " + email);
            return "login";
        }
    }

}
