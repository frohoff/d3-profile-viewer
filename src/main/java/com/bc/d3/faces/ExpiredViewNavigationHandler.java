package com.bc.d3.faces;

import java.io.IOException;

import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bc.d3.Outcome;
import com.ocpsoft.pretty.faces.application.PrettyNavigationHandler;

public class ExpiredViewNavigationHandler extends PrettyNavigationHandler {

	private static final Logger logger = LoggerFactory
			.getLogger(ExpiredViewNavigationHandler.class);

	private static final String VIEW_EXPIRED_PAGE = "/viewExpired";

	public ExpiredViewNavigationHandler(ConfigurableNavigationHandler parent) {
		super(parent);
	}

	@Override
	public void handleNavigation(FacesContext context, String fromAction,
			String outcome) {
		if (!Outcome.VIEW_EXPIRED.equals(outcome)) {
			super.handleNavigation(context, fromAction, outcome);
			return;
		}

		try {
			ExternalContext externalContext = context.getExternalContext();
			String contextPath =  externalContext.getRequestContextPath();
			HttpServletResponse response = (HttpServletResponse)externalContext
					.getResponse();
			response.sendRedirect(contextPath + VIEW_EXPIRED_PAGE);
			context.responseComplete();
		} catch (IOException exception) {
			logger.warn("Unkown error occurred.", exception);
		}
	}

}
