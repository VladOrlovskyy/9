<%@ page import="com.softserve.itacademy.model.Task" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Read existing Task</title>

    <style>
        <%@include file="../styles/main.css"%>
    </style>

</head>
<body>
<%
    Task task = (Task) request.getAttribute("task");
%>
    <%@include file="header.html" %>
    <p>Id: <%=task.getId()%></p>
    <p>Title: <%=task.getTitle()%></p>
    <p>Priority: <%=task.getPriority()%> </p>

</body>
</html>
