<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="es.uco.pw.business.reserve.models.factory.*" %>
<%@ page import="java.util.ArrayList" %>

<jsp:useBean  id="User" scope="session" class="es.uco.pw.display.javabean.CustomerBean"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View reserve</title>
</head>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilos.css">
<body>
	<!-- ACL -->
	<%String aclUser = application.getInitParameter("aclUser"); %>
	<jsp:include page="<%=aclUser%>"></jsp:include>
	<!-- ACL -->
	<%  
	
	String indexViewPath = application.getInitParameter("index");
	if(request.getAttribute("arrayReserves") == null){	%>
		    <div class="form-style-6">
				<form id="formulario"  method="get" action= "/p3/viewReserve">
					<label>Fecha de inicio</label>
				 	<input type="date" name="fechaInicio" id="fechaInicio">
				 	<input type="date" name="fechaFin" id="fechaFin">
				 	<input type="hidden" name="email" value="<jsp:getProperty property="email" name="User"/>" />
				 	 <input type="submit" id="submit" value="Submit"><br><br>
				  	<input type="reset" id="reset">
				</form>
			</div>
	<% }else{
		
		ArrayList<ReservaAbstracta> reservas = (ArrayList<ReservaAbstracta>)request.getAttribute("arrayReserves");

		if(request.getAttribute("response") != "success"){
			%>	<p class="cajaRoja"><%=request.getAttribute("response")%></p>  <%
		}else{
		%>
		<div class="cajaBlanca">
			<table>
			  <thead>
			    <tr>
			      <th>Pista</th>
			      <th>Fecha</th>
			      <th>Duracion</th>
			      <th>tipo</th>
			      <th>Numero de niños</th>
			      <th>Numero de adultos</th>
			      <th>Precio</th>
			      <th>Descuento</th>
			    </tr>
			  </thead>
			  <tbody>
				<% for(ReservaAbstracta it : reservas){ %>
				          <tr>
				            <td><%=it.getIdPista()%></td>
				            <td><%=it.getDate()%></td>
				            <td><%=it.getTime()%></td>
				            <td><%=it.getType()%></td>
				            <td><%=it.getNumChilds()%></td>
				            <td><%=it.getNumAdults()%></td>
				            <td><%=it.getPrice()%></td>
				            <td><%=it.getDiscount()%></td>
				          </tr>
				<%  }  %>
			  </tbody>
			</table>
		</div>
	<%
		}
	}
	%>

		<p><a href="${pageContext.request.contextPath}<%=indexViewPath%>">Inicio</a></p>
</body>
</html>