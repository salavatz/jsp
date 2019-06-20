<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="myTags" tagdir="/WEB-INF/tags" %>

<head>
    <link rel="stylesheet" href="main.css">
</head>
<myTags:template>
    <jsp:attribute name="title">Регистрация</jsp:attribute>
    <jsp:attribute name="header">
        <div class="container">
            <h1 align="center">Регистрация</h1>
            <div class="center">
                <form method="post" action="${pageContext.request.contextPath}/signup">
                    <div class="form-group">
                        <label for="login">Login</label>
                        <input type="text" class="form-control" name="login" id="login" placeholder="Login">
                    </div>
                    <div class="form-group">
                        <label for="password">Password</label>
                        <input type="password" class="form-control" name="password" id="password" placeholder="Password">
                    </div>
                    <button type="submit" class="btn btn-primary">Submit</button>
                </form>
            </div>
        </div>
    </jsp:attribute>
</myTags:template>