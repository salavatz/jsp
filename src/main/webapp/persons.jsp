<%@ page import="entity.Person" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Студенты</title>
    <meta charset="UTF-8"/>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h1 align="center">Таблица студентов</h1>
    <br />
    <table class="table table-bordered">
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Name</th>
            <th scope="col">Birthdate</th>
        </tr>
        </thead>
        <% List<Person> list = (List<Person>) request.getAttribute("persons");
            for (Person person : list) { %>
        <tbody>
        <tr>
            <td><%=person.getId()%></td>
            <td><%=person.getName()%></td>
            <td><%=person.getBirthDate()%></td>
        </tr>
        </tbody>
        <% } %>
    </table>
    <a href="/" class="btn btn-primary">Main page</a>
</div>
</body>
</html>
