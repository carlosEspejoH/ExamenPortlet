<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<portlet:defineObjects />

<h1>Portlet A</h1>

<portlet:actionURL var="urlPortletB" name="enviarEventoB"></portlet:actionURL>
<portlet:actionURL var="urlPortletC" name="enviarEventoC"></portlet:actionURL>



<form method="post">
	<input type="submit" value="PortletB" formaction="<%=urlPortletB%>" />
	<input type="submit" value="PortletC" formaction="<%=urlPortletC%>" />
	<div><input type="text" name="nombre" placeholder="Nombre" /></div> 
	<div><input type="text" name="direccion" placeholder="Direccion" /></div>
	<div><input type="text" name="telefono" placeholder="Telefono" /></div>
</form>
