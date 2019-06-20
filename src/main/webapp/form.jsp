<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="myTags" tagdir="/WEB-INF/tags" %>
<%@page import="java.time.LocalDate"%>

<jsp:useBean id="person" class="entity.Person" />
    <c:set target="${person}" property="name" value="Anonim" />
    <jsp:setProperty name="person" property="birthDate" value="<%=LocalDate.parse(\"1900-04-04\")%>"/>
    <c:set target="${person}" property="email" value="Anonim@mail.com" />
    <c:set target="${person}" property="phone" value="89999999999" />
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
                        <input type="text" class="form-control" name="name" id="name" placeholder="<jsp:getProperty name="person" property="name" />">
                    </div>
                    <div class="form-group">
                        <label for="birth">Birth</label>
                        <input type="text" class="form-control" name="birth" id="birth" placeholder="<jsp:getProperty name="person" property="birthDate" />">
                    </div>
                    <div class="form-group">
                        <label for="email">Email</label>
                        <input type="text" class="form-control" name="email" id="email" placeholder="<jsp:getProperty name="person" property="email" />">
                    </div>
                    <div class="form-group">
                        <label for="phone">Phone</label>
                        <input type="text" class="form-control" name="phone" id="phone" placeholder="<jsp:getProperty name="person" property="phone" />">
                    </div>
                    <button type="submit" class="btn btn-primary">Submit</button>
                </form>
            </div>
        </div>
    </jsp:attribute>
</myTags:template>