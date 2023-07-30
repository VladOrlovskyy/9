<%@ page import="com.softserve.itacademy.model.Task" %>
<html lang="en">
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Update existing Task</title>

  </head>
  <body>
	<form action="/update-task" method="post">

    <%
       Task task = (Task) request.getAttribute("task");
    %>

    <table>
    <tr>
         <td>
            <label for="id">Id: </label>
         </td>
         <td>
            <input type="text" id="id" name="id" value="<%=task.getId()%>" disabled>
         </td>
    </tr>

    <tr>
        <td>
            <label for="name">Name: </label>
       </td>
       <td>
          <input type="text" id="name" name="name" value="<%=task.getTitle()%>">
      </td>
    </tr>
    <tr>
         <td>
            <label for="priority">Priority: </label>
         </td>
       <td>
          <input type="text" id="priority" name="priority" value="<%=task.getPriority()%>">
       </td>
    </tr>



    <tr>
      <td>
          <input types = "submit" value="Update">
      </td>
            <td>
                <input types = "submit" value="Create">
            </td>
    </tr>
    </table>
    </form>
  </body>
  </html>