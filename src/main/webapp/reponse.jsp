<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="Dao.Daoreponse,Dao.*,java.util.*,javax.servlet.http.HttpServletRequest"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Score</title>
</head>
<body>


<% 
  int result=0;
   {
    String reponse = request.getParameterValues("repquest")[0];
    if(Daoreponse.isCorrecte(Integer.parseInt(reponse))) 
    	 result=result++;
   }
%>
 <fieldset>
 <legend><h3> Votre score</h3></legend>
  <h4> <%=result%> </h4> 
 </fieldset>
</body>
</html>