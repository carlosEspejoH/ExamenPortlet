<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@page import="com.examenTalentum.entidades.Persona"%>

<portlet:defineObjects />

<h1>Portlet C</h1>
<%
Persona persona = (Persona)request.getAttribute("informacionC");
if (persona!=null){
%>
<form method="post">
	<div><input type="text" name="nombre" placeholder="Nombre" value="<%=persona.getNombre()%>"/></div> 
	<div><input type="text" name="direccion" placeholder="Direccion" value="<%=persona.getDireccion()%>" /></div>
	<div><input type="text" name="telefono" placeholder="Telefono" value="<%=persona.getTelefono()%>"/></div>
</form>
<%} else{%>

<form method="post">
	<div><input type="text" name="nombre" placeholder="Nombre" /></div> 
	<div><input type="text" name="direccion" placeholder="Direccion" /></div>
	<div><input type="text" name="telefono" placeholder="Telefono" /></div>
</form>

<%} %>
