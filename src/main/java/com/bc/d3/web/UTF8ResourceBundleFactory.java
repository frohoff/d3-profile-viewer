package com.bc.d3.web;

import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.concurrent.ConcurrentHashMap;

import javax.faces.application.ProjectStage;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

public final class UTF8ResourceBundleFactory {

	private final Map<String, Map<Locale, UTF8ResourceBundle>> resourceBundles;

	private Boolean development;

	public UTF8ResourceBundleFactory() {
		resourceBundles = new ConcurrentHashMap<String,
			Map<Locale, UTF8ResourceBundle>>();
	}

	public ResourceBundle getResourceBundle(String name) {
		if (development == null) {
			development = isDevelopment();
		}

		Locale locale = getLocale();
		if (locale == null) {
			return null;
		}

		UTF8ResourceBundle resourceBundle = findCachedResourceBundle(name, locale);
		if (resourceBundle != null) {
			return resourceBundle;
		}

		resourceBundle = new UTF8ResourceBundle(name, locale, development);

		// yes, cache null values too
		cacheResourceBundle(name, locale, resourceBundle);

		return resourceBundle;
	}

	private boolean isDevelopment() {
		FacesContext context = FacesContext.getCurrentInstance();
		if (context == null) {
			throw new RuntimeException("Unable to access FacesContext");
		}

		return ProjectStage.Development.equals(context.getApplication()
			.getProjectStage());
	}

	private Locale getLocale() {
		FacesContext context = FacesContext.getCurrentInstance();
		if (context == null) {
			throw new RuntimeException("Unable to access FacesContext");
		}

		UIViewRoot viewRoot = context.getViewRoot();
		if (viewRoot == null) {
			return context.getApplication().getDefaultLocale();
		}
		return viewRoot.getLocale();
	}

	private UTF8ResourceBundle findCachedResourceBundle(String name,
			Locale locale) {
		if (!resourceBundles.containsKey(name)) {
			return null;
		}

		if (!resourceBundles.get(name).containsKey(locale)) {
			return null;
		}

		return resourceBundles.get(name).get(locale);
	}

	private synchronized void cacheResourceBundle(String name, Locale locale,
			UTF8ResourceBundle bundle) {
		Map<Locale, UTF8ResourceBundle> locales = resourceBundles.get(name);
		if (locales == null) {
			locales = new ConcurrentHashMap<Locale, UTF8ResourceBundle>();
			resourceBundles.put(name, locales);
		}
		locales.put(locale, bundle);
	}

}
