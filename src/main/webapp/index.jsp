<%@page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/date.tld" prefix="datetag" %>
<%@taglib prefix="myTags" tagdir="/WEB-INF/tags" %>

<myTags:template>
    <jsp:attribute name="title">Students</jsp:attribute>
    <jsp:attribute name="header">
        <%--<%@include file="header.jsp"%>--%>
        <jsp:include page="header.jsp"></jsp:include>
    </jsp:attribute>
</myTags:template>