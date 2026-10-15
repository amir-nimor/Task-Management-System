<%--
  Created by IntelliJ IDEA.
  User: anon
  Date: 10/15/2026
  Time: 2:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/login" method="post">
    <label for="username">Username:</label>
    <input id="username" name="username">
    <label for="password">Password</label>
    <input id="password" name="password">
    <button>Submit</button>
</form>

</body>
</html>
