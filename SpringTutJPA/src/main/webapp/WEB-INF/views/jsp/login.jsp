<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="UTF-8" />
<title>Login Page</title>
</head>
<body>
    <div class="main-content">
<%--
        <p th:if="${param.error}" class="error">Invalid email or password</p>
        <p th:if="${param.logout}" class="success">You have been logged out</p>
 --%>
 	<p th:if="${param.message}" class="success">${param.message}</p>

         <h2>${message}</h2>
         
        <h3>Login to continue!!! Cpage</h3>
        <form action="<c:url value='./loginprocess' />" method='POST'>
            <input type="text" name="email" placeholder="Your email" /><br />
            <input type="password" name="pass" placeholder="Your password" /><br />
            Remember Me: <input type="checkbox" name="remember-me" />
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            <button type="submit">Login</button> <br />
        </form>
    </div>
</body>
</html>