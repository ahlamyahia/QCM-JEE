<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="Dao.Daoform,Dao.form,java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>QCM</title>
</head>
<body>
 <%!
   List<form> listform= Daoform.getAll();
 %>
<div>
<h3> Choisir  un QCM </h3>
<fieldset>
<form action="do" method="get">
<% for(form f : listform) { %>
<input type="radio" name="form" value="<%=f.getIdf() %>" /><label> <%=f.getLibf()%> </label><br/>
<% } %>

<input type="submit" value="choisir" id="choisir">
</form>
</fieldset>
</div>
</body>
</html>