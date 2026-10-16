<%--
  Created by IntelliJ IDEA.
  User: anon
  Date: 10/16/2026
  Time: 12:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<nav><a href="${pageContext.request.contextPath}/book">Books</a></nav>

<button onclick="logout()">Logout</button>

</body>
<script>
    function logout() {
        fetch("http://localhost:8080/logout", {
            method: "POST"
        }).then(() => {
            window.location.href = '/login'
        })
    }
</script>
</html>
