<%@ page import="java.util.List" %>
<%@ page import="com.university.model.Course" %>
<%@ page import="com.university.model.Student" %>
<%
    List<Course> courses = (List<Course>) request.getAttribute("courses");
    Student student = (Student) session.getAttribute("student");
%>
<html>
<head>
    <title>Course List</title>
</head>
<body>

<h2>Welcome <%= student.getName() %>! Choose a course to register:</h2>

<table border="1" cellpadding="10">
    <tr>
        <th>Course ID</th>
        <th>Name</th>
        <th>Instructor</th>
        <th>Credits</th>
        <th>Action</th>
    </tr>

    <%
        for (Course course : courses) {
    %>
    <tr>
        <td><%= course.getCourseId() %></td>
        <td><%= course.getName() %></td>
        <td><%= course.getInstructor() %></td>
        <td><%= course.getCredits() %></td>
        <td>
            <form action="registerCourse" method="post">
                <input type="hidden" name="courseId" value="<%= course.getCourseId() %>" />
                <input type="submit" value="Register" />
            </form>
        </td>
    </tr>
    <%
        }
    %>
</table>

<p style="color:green;"><%= request.getAttribute("message") != null ? request.getAttribute("message") : "" %></p>
<p style="color:red;"><%= request.getAttribute("error") != null ? request.getAttribute("error") : "" %></p>

</body>
</html>
