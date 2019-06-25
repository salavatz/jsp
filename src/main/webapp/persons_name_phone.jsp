<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="myTags" tagdir="/WEB-INF/tags" %>

<myTags:template>
    <jsp:attribute name="title">Студенты</jsp:attribute>
    <jsp:attribute name="header">
        <div class="container">
            <h1 align="center">Таблица студентов</h1>
            <br />
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Name</th>
                    <th scope="col">Birthdate</th>
                    <th scope="col">Email</th>
                    <th scope="col">Phone</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="person" items="${persons}">
                    <tr>
                        <td>${person.id}</td>
                        <td>${person.name}</td>
                        <td>${person.birthDate}</td>
                        <td>${person.email}</td>
                        <td>${person.phone}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <a href="/" class="btn btn-primary">Main page</a>
            <a href="/person/list" class="btn btn-primary">Name and phone</a>
        </div>
    </jsp:attribute>
</myTags:template>