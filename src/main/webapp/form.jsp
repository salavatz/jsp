<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="myTags" tagdir="/WEB-INF/tags" %>

<head>
    <link rel="stylesheet" href="main.css">
</head>
<myTags:template>
    <jsp:attribute name="header">
        <div class="container">
            <h1 align="center">Добавить студента</h1>
            <div class="center">
                <form method="post" action="${pageContext.request.contextPath}/person">
                    <div class="form-group">
                        <label for="name">Name</label>
                        <input type="text" class="form-control" name="name" id="name" placeholder="Anonim">
                    </div>
                    <div class="form-group">
                        <label for="birth">Birth</label>
                        <input type="text" class="form-control" name="birth" id="birth" placeholder="1900-04-04">
                    </div>
                    <div class="form-group">
                        <label for="email">Email</label>
                        <input type="text" class="form-control" name="email" id="email" placeholder="Anonim@mail.com">
                    </div>
                    <div class="form-group">
                        <label for="phone">Phone</label>
                        <input type="text" class="form-control" name="phone" id="phone" placeholder="89999999999">
                    </div>
                    <button type="submit" class="btn btn-primary">Submit</button>
                </form>
            </div>
        </div>
    </jsp:attribute>
</myTags:template>