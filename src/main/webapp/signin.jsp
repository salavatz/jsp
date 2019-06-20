<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="myTags" tagdir="/WEB-INF/tags" %>

<head>
    <link rel="stylesheet" href="main.css">
</head>
<myTags:template>
    <jsp:attribute name="title">Войти</jsp:attribute>
    <jsp:attribute name="header">
        <div class="container">
            <h1 align="center">Войти</h1>
            <div class="center">
                <form method="post" action="${pageContext.request.contextPath}/signin">
                    <c:choose>
                        <c:when test="${pageContext.request.getAttribute(\"error\")!=null && pageContext.request.getAttribute(\"error\")}">
                            <div class="form-group">
                                <label for="login">Login</label>
                                <input type="text" class="form-control is-invalid" name="login" id="login_invalid" placeholder="Login">
                            </div>
                            <div class="form-group">
                                <label for="password">Password</label>
                                <input type="password" class="form-control is-invalid" name="password" id="password_invalid" placeholder="Password">
                            </div>
                        </c:when>
                        <c:otherwise>
                            <div class="form-group">
                                <label for="login">Login</label>
                                <input type="text" class="form-control" name="login" id="login" placeholder="Login">
                            </div>
                            <div class="form-group">
                                <label for="password">Password</label>
                                <input type="password" class="form-control" name="password" id="password" placeholder="Password">
                            </div>
                        </c:otherwise>
                    </c:choose>
                    <button type="submit" class="btn btn-primary">Submit</button>
                </form>
                <c:if test="${pageContext.request.getAttribute(\"error\")!=null && pageContext.request.getAttribute(\"error\")}">
                    <br />
                    <p style="color:#ff6b5b">
                        Неверные данные входа. Пожалуйста, попробуйте еще раз.
                    </p>
                    <br />
                    <p>Новый пользователь?
                        <a href="${pageContext.request.contextPath}/signup" class="nav-link" style="display: inline">
                            Зарегистрируйтесь
                        </a>
                    </p>
                </c:if>
            </div>
        </div>
    </jsp:attribute>
</myTags:template>