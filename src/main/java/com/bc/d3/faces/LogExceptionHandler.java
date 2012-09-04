package com.bc.d3.faces;

import javax.faces.FacesException;
import javax.faces.application.ProjectStage;
import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerWrapper;
import javax.faces.context.FacesContext;
import javax.faces.event.ExceptionQueuedEvent;
import javax.faces.event.ExceptionQueuedEventContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Output exceptions to logger. Extremely useful for debugging Ajax calls.
 *
 * @author Brad Chen <brad.chen@70ms.com>
 */
public class LogExceptionHandler extends ExceptionHandlerWrapper {

	private static final Logger logger
		= LoggerFactory.getLogger(LogExceptionHandler.class);

	private ExceptionHandler wrapped;

	public LogExceptionHandler(ExceptionHandler wrapped) {
		this.wrapped = wrapped;
	}

	@Override
	public ExceptionHandler getWrapped() {
		return this.wrapped;
	}

	/**
	 * Only work in Dev stage.
	 */
	@Override
	public void handle() throws FacesException {
		if (!ProjectStage.Development.equals(FacesContext.getCurrentInstance()
				.getApplication().getProjectStage())) {
			getWrapped().handle();
			return;
		}

		for (ExceptionQueuedEvent event : getUnhandledExceptionQueuedEvents()) {
			ExceptionQueuedEventContext context = (ExceptionQueuedEventContext)
				event.getSource();
			logger.error("Error occured.", context.getException());
		}

		// let exceptions be processed normally
		getWrapped().handle();
	}

}
