package com.university.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

public class LoggingInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {

        String uri = request.getRequestURI();

        if (uri.contains("/login")) {
            System.out.println("🔐 Login attempt: " + request.getParameter("email"));
        } else if (uri.contains("/registerCourse")) {
            System.out.println("📚 Course registration attempt: Course ID = " + request.getParameter("courseId"));
        }

        return true;
    }
}
