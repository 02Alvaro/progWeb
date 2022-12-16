<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="es.uco.pw.business.circuit.models.Pista" %>
<%@ page import="es.uco.pw.business.circuit.models.Kart" %>
<%@ page import="java.util.ArrayList" %>

<jsp:useBean  id="User" scope="session" class="es.uco.pw.display.javabean.CustomerBean"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modify Kart State</title>
</head>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilos.css">
<body>

	<!-- ACL -->
	<%String aclAdmin = application.getInitParameter("aclAdmin"); %>
	<jsp:include page="<%=aclAdmin%>"></jsp:include>
	<!-- ACL -->

	<%
	
	String indexViewPath = application.getInitParameter("index");
	ArrayList<Kart> karts = new ArrayList<Kart>();

	if(request.getAttribute("arrayKarts") != null){
		karts = (ArrayList<Kart>)request.getAttribute("arrayKarts");
	}
	
	%>
	    <div class="form-style-6">
			<form id="formulario"  method="get" action= "/p3/modifyKartState">
			 <label>Id</label>
			   <select class="cajaBlanca" id="id" name="id">
				<%for(Kart it : karts){ %>
			    	<option value="<%=it.getId()%>"><%=it%></option>
			    <%} %>
			  </select><br>

			  <label>Estado</label>
			  <select class="cajaBlanca" id="estadoKart" name="estadoKart">
			    <option value="DISPONIBLE">Disponible</option>
			    <option value="RESERVADO">Reservado</option>
			    <option value="MANTENIMIENTO">Mantenimiento</option>
			  </select><br>
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
</html>