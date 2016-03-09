package com.examenTalentum;

import java.io.IOException;
import com.examenTalentum.entidades.Persona;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.xml.namespace.QName;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * Portlet implementation class PortletA Portlet lanza eventos
 */
public class PortletA extends GenericPortlet {

	public void init() {
		viewTemplate = getInitParameter("view-template");
	}

	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		include(viewTemplate, renderRequest, renderResponse);
	}
	
	@ProcessAction(name = "enviarEventoB")
	public void enviarEventoB(ActionRequest request, ActionResponse response) throws PortletException, IOException {
		
		String nombre = request.getParameter("nombre");
		String direccion = request.getParameter("direccion");
		String telefono = request.getParameter("telefono"); // queria mandarlo como int pero el 
		// int telefono = parseInt(request.getParameter("telefono")); me daba error
		
		Persona persona = new Persona(nombre, direccion, telefono);
		
		QName qname= new QName("http://examen.portletsB.com", "informacion", "x");
		
		response.setEvent(qname, persona);
		
	}
	
	@ProcessAction(name = "enviarEventoC")
	public void enviarEventoC(ActionRequest request, ActionResponse response) throws PortletException, IOException {
		
		String nombre = request.getParameter("nombre");
		String direccion = request.getParameter("direccion");
		String telefono = request.getParameter("telefono"); // queria mandarlo como int pero el 
		// int telefono = parseInt(request.getParameter("telefono")); me daba error
		
		Persona persona = new Persona(nombre, direccion, telefono);
		
		QName qname= new QName("http://examen.portletsC.com", "informacionC", "x");
		
		response.setEvent(qname, persona);
	}

	protected void include(String path, RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		PortletRequestDispatcher portletRequestDispatcher = getPortletContext().getRequestDispatcher(path);

		if (portletRequestDispatcher == null) {
			_log.error(path + " is not a valid include");
		} else {
			portletRequestDispatcher.include(renderRequest, renderResponse);
		}
	}

	protected String viewTemplate;

	private static Log _log = LogFactoryUtil.getLog(PortletA.class);

}
