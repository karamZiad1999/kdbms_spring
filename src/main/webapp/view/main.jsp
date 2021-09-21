<%@ page import="com.atypon.kdbms_spring.domain.Payload" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.atypon.kdbms_spring.domain.Record" %>
<%@ page import="java.util.LinkedHashMap" %>
<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>KDBMS</title>
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
          crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-md bg-dark navbar-dark">

    <a class="navbar-brand" href="#">KDBMS</a>


    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
        <span class="navbar-toggler-icon"></span>
    </button>


    <div class="collapse navbar-collapse" id="collapsibleNavbar">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" th:href="@{/users}">Schemas</a>
            </li>
        </ul>
    </div>
</nav>
<div class ="container">
    <div class = "row">
        <h1> List Teachers </h1>
    </div>

    <div class = "row">
        <div class = "col-lg-3">
            <a th:href = "@{/teachers/new}" class = "btn btn-primary btn-sm mb-3"> Add Teacher</a>
        </div>
    </div>
    <table class = "table table-striped table-bordered">
        <thead class = "table-dark">
        <tr>
            <%
                Payload payload = (Payload) request.getAttribute("payload");
                ArrayList<String> fieldNames = payload.getFieldNames();
                for(String fieldName : fieldNames){
            %>
            <th><%= fieldName %></th>
            <% } %>
            <th> actions </th>
        </tr>
        </thead>

        <tbody>

        <%ArrayList<Record> records = payload.getRecords();
            for(Record record : records){%>
        <tr>
            <% LinkedHashMap<String, String> fields = record.getFields();
                for(Map.Entry<String,String> field : fields.entrySet()){%>

            <td><%= field.getValue() %></td>

            <%}%>
            <td>
                <a href = "@{/teachers/edit/{id}(id=${teacher.id})}"
                   class = "btn btn-primary">Update</a>

                <a href = "@{/teachers/{id}(id=${teacher.id})}"
                   class = "btn btn-danger">Delete</a>

            </td>
        </tr>
        <%}%>
        </tbody>

    </table>

</div>
</body>
</html>