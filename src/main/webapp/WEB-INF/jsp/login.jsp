<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>景区网站管理员登录</title>
</head>
<body>
<c:if test="${!empty error}">
    <font color="red"><c:out value="${error}"/></font>
</c:if>
<form action="<c:url value="/admin/loginCheck.html"/>" method="post">
    用户名：
    <input type="text" name="userName">
    <font color="red"><span>${nameError}</span></font>
    <br>
    密 码：
    <input type="password" name="password">
    <font color="red"><span>${passwordError}</span></font>
    <br>
    <input type="submit" value="登录"/>
    <input type="reset" value="重置"/>
</form>
</body>
</html>
