<%@page contentType="text/html;charset=UTF-8" %>

<nav class="navbar navbar-expand-md navbar-dark bg-primary sticky-top">
    <div class="container-fluid">
        <a href="#" class="navbar-brand">Students</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" >
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a href="${pageContext.request.contextPath}/person/list" class="nav-link">Список студентов</a>
                </li>
                <li class="nav-item">
                    <a href="${pageContext.request.contextPath}/person" class="nav-link">Добавить студента</a>
                </li>
            </ul>
        </div>
    </div>
</nav>