<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="Dao.*,java.util.*,javax.servlet.http.HttpServletRequest"%>
    <jsp:useBean  id="form" class="Dao.form"  scope="request" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Questions</title>
</head>
<body>
<fieldset>
<div >   
  
  <p >Repondez a tous les questions !!</p>
</div>
</fieldset>
  
<%!  //  liste des questions
   List<question> listquest = new ArrayList<question>(); 
     //  liste des reponses correspondantes a une question 
   List<reponse> listresp = new ArrayList<reponse>();
   String question; 
   String reponse;
   // un compteur pour calculer le nombre des questions
   
 %><% %>
  <fieldset>
      <legend>Questions : </legend>
   <form action="reponse.jsp" method="get" >
   <%
      int i=0;
      listquest = Daoquestion.getquestions(form.getIdf()); 
     for( question q : listquest){
    	 
   %>
	 <%=++i%>-<b><%= q.getLibq()%></b><br/>
	  
	   <% 
	     listresp =Daoreponse.getReponse(q.getIdq());
	     for(reponse r : listresp){ 
	   %>
		   <input type="radio" name="repquest<%=i%>" value="<%=r.getIdr()%>">
		   <label><%= r.getLibr() %> </label><br/>
		   
	  <% }%><br> 
	     <% } %> 
	  
	   <input type="reset" value="reset" id="reset"/>
	   <input type="submit" value="valider" id="submit"/>
	   
</form>
</fieldset>
</body>
</html>