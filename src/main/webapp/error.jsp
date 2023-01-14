<%--
  Created by IntelliJ IDEA.
  User: Boukhllad
  Date: 1/14/2023
  Time: 1:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error</title>
</head>
<body>
<h1>An error has occurred</h1>
<p>Error message: <span id="error-message"></span></p>
<p>Please try again.</p>
<script>
    let errorMessage = "Error message here";
    document.getElementById("error-message").innerHTML = errorMessage;
</script>
</body>
</html>