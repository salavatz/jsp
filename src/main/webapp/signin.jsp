<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Войти</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="main.css">
</head>
<body>
<div class="container">
    <h1 align="center">Войти</h1>
    <div class="center">
        <form method="post" action="${pageContext.request.contextPath}/signin">
            <div class="form-group">
                <label for="login">Login</label>
                <% if (request.getAttribute("error") != null && (boolean) request.getAttribute("error")) { %>
                    <input type="text" class="form-control is-invalid" name="login" id="login" placeholder="Login">
                <% } else {%>
                <input type="text" class="form-control" name="login" id="login" placeholder="Login">
                <% } %>
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <% if (request.getAttribute("error") != null && (boolean) request.getAttribute("error")) { %>
                    <input type="password" class="form-control is-invalid" name="password" id="password" placeholder="Password">
                <% } else {%>
                <input type="password" class="form-control" name="password" id="password" placeholder="Password">
                <% } %>
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
        <% if (request.getAttribute("error") != null && (boolean) request.getAttribute("error")) { %>
            <br />
            <p style="color:#ff6b5b">Неверные данные входа. Пожалуйста, попробуйте еще раз.</p>
            <br />
            <p>Новый пользователь?
            <a href="${pageContext.request.contextPath}/signup" class="nav-link" style="display: inline"> Зарегистрируйтесь</a> </p>
        <% } %>
    </div>
</div>
</body>
</html>