<%--
  Created by IntelliJ IDEA.
  User: dhupi
  Date: 5/9/2025
  Time: 7:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Login</title></head>
<body>
<h2>Login</h2>
<form method="post" action="login">
  Email: <input type="text" name="email"/><br/>
  Password: <input type="password" name="password"/><br/>
  <input type="submit" value="Login"/>
</form>
<p style="color:red;">
  ${error}
</p>
</body>
</html>

