<%@ page import="com.softserve.itacademy.model.Priority" %>
<%@ page import="com.softserve.itacademy.model.Task" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Create new Task</title>

    <style>
        <%@include file="../styles/main.css"%>
    </style>

</head>
<body>
    <%@include file="header.html"%>

    <h1>Create New Task</h1>

    <%
        String error = (String) request.getAttribute("error");
        if(!(boolean) request.getAttribute("check") && error == null) {
    %>
    <p>Task with a given name already exists!</p>

    <%
        } else {
    %>

    <p><%=error != null ? error : ""%></p>

    <%
        }
    %>

    <form action="/create-task" method="post">
        <label for="name">Name: </label>
        <input type="text" id="name" value="Task #2" name="title">
        <br />

        <label for="priority">Priority: </label>
        <select name="priority" id="priority">
            <option value="LOW">Low</option>
            <option value="MEDIUM" selected>Medium</option>
            <option value="HIGH">High</option>
        </select>
        <br />
        <input type = "submit" value = "Create" />
        <input type = "reset" value = "Clear" />
    </form>

</body>
</html>
