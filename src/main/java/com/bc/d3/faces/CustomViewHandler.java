package com.bc.d3.faces;

import javax.faces.application.ViewHandler;
import javax.faces.application.ViewHandlerWrapper;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

public class CustomViewHandler extends ViewHandlerWrapper {

	private ViewHandler wrapped;

	public CustomViewHandler(ViewHandler viewHandler) {
		wrapped = viewHandler;
	}

	@Override
	public ViewHandler getWrapped() {
		return wrapped;
	}

	@Override
	public String getActionURL(FacesContext context, String viewId) {
		String originActionUrl = super.getActionURL(context, viewId);
		return includeViewParams(context, originActionUrl);
	}

	private String includeViewParams(FacesContext context, String actionUrl) {
		HttpServletRequest request = (HttpServletRequest)context
				.getExternalContext().getRequest();
		String queryString = request.getQueryString();
		if (queryString == null) {
			return actionUrl;
		}
		return actionUrl + "?" + queryString;
	}

}
