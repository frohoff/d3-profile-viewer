package com.bc.d3.faces;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("request")
public class FacesUtils {

	private final FacesContext facesContext;

	@Autowired
	public FacesUtils(FacesContext facesContext) {
		this.facesContext = facesContext;
	}

	public void invalidateSession() {
		getHttpServletRequest().getSession().invalidate();
	}

	public void responseComplete() {
		facesContext.responseComplete();
	}

	public void showErrorMessage(String messageString) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
			messageString, messageString);
		showMessage(message, false);
	}

	public void showErrorMessageAfterRedirect(String messageString) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
			messageString, messageString);
		showMessage(message, true);
	}

	public void showErrorMessage(UIComponent com, String message) {
		String clientId = com.getClientId(facesContext);
		FacesMessage facesMessage = createErrorMessage(message);
		facesContext.addMessage(clientId, facesMessage);
	}

	public void showMessage(String messageString) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
			messageString, messageString);
		showMessage(message, false);
	}

	public void showMessageAfterRedirect(String messageString) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
			messageString, messageString);
		showMessage(message, true);
	}

	private void showMessage(FacesMessage message,
			boolean afterRedirect) {
		facesContext.addMessage(null, message);
		if (afterRedirect) {
			getExternalContext().getFlash().setKeepMessages(true);
		}
	}

	public HttpServletRequest getHttpServletRequest() {
		return (HttpServletRequest)getExternalContext().getRequest();
	}

	public HttpServletResponse getHttpServletResponse() {
		return (HttpServletResponse)getExternalContext().getResponse();
	}

	private ExternalContext getExternalContext() {
		return facesContext.getExternalContext();
	}

	public void handleNavigation(String fromAction, String outcome) {
		facesContext.getApplication().getNavigationHandler()
			.handleNavigation(facesContext, fromAction, outcome);
	}

	public void setHttp404NotFoundHeader() {
		getHttpServletResponse().setStatus(HttpServletResponse.SC_NOT_FOUND);
	}

	public static FacesMessage createErrorMessage(String message) {
		return new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message);
	}

}
