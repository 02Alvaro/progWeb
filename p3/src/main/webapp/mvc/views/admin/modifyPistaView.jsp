<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>    
<%@ page import="es.uco.pw.business.circuit.models.Pista" %>
 <jsp:useBean  id="User" scope="session" class="es.uco.pw.display.javabean.CustomerBean"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"><title>Modify Pista</title>
</head>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilos.css">
<body>
	<!-- ACL -->
	<%String aclAdmin = application.getInitParameter("aclAdmin"); %>
	<jsp:include page="<%=aclAdmin%>"></jsp:include>
	<!-- ACL -->
		<%
	
	String indexViewPath = application.getInitParameter("index");
	ArrayList<Pista> pistas = new ArrayList<Pista>(); 

	if(request.getAttribute("arrayPistas") != null){
		pistas = (ArrayList<Pista>)request.getAttribute("arrayPistas");
	}

	
	%>
	<div class="form-style-6">
		<form id="formulario" method="get" action="/p3/modifyPista">
		 	<label>Id</label>
		 	 <select class="cajaBlanca" id="id" name="id">
				<%for(Pista it : pistas){ %>
			    	<option value="<%=it.getId()%>"><%=it.getName()%></option>
			    <%} %>
			    <option value="-1">Ninguna</option>
			  </select><br>
			<label>Nombre</label>
			<input type="text" name="name" class="cajaBlanca"><br>
			<label>Disponibilidad</label>
			<div class="cajaBlanca">
				<input type="radio" name="isAvailible" value="true" checked> Disponible
				<input type="radio" name="isAvailible" value="false"> No Disponible
			</div>
			<label>Máximo de karts</label>
			<input type="number" name="maxKarts" class="cajaBlanca"><br>
			<input type="submit" id="submit" value="Submit"><br><br>
			<input type="reset" id="reset">
		</form>
	<%
		if(request.getAttribute("response") != null){
			if(request.getAttribute("response") == "success"){
		%>
				<p class="cajaBlanca"><%=request.getAttribute("response")%></p>
			<%}else{%>
				<p class="cajaRoja"><%=request.getAttribute("response")%></p>
		<% 
			}
		}
		%>
	</div>
		<p><a href="${pageContext.request.contextPath}<%=indexViewPath%>">Inicio</a></p>
</body>
  <script src="${pageContext.request.contextPath}/js/script.js"></script> 
</html>