package com.bc.d3.web;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Enumeration;
import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 * Resource bundle that supports UTF-8. Code is modified using the code from:
 * http://jdevelopment.nl/java/internationalization-jsf-utf8-encoded-properties-files/
 *
 * @author Brad Chen <brad.chen@70ms.com>
 */
public class UTF8ResourceBundle extends ResourceBundle {

	protected static final String BUNDLE_EXTENSION = "properties";
	protected static final String CHARSET = "UTF-8";

	private UTF8Control utf8Control;
	private String name;
	private Locale locale;
	private boolean development;

	/**
	 * Creates a UTF8ResourceBundle with the name of the resource bundle and
	 * the current locale.
	 *
	 * @param name name of the resouce bundle
	 * @param locale current locale
	 */
	public UTF8ResourceBundle(String name, Locale locale, boolean development) {
		this.name = name;
		this.locale = locale;
		this.development = development;

		// initialize control object
		utf8Control = new UTF8Control();
		if (development) {
			utf8Control.setAlwaysReload(true);
			utf8Control.setTimeToLive(Control.TTL_DONT_CACHE);
		}

		// initialize resource bundle only once when not in development
		if (!development) {
			initializeResourceBundle();
		}
	}

	private void initializeResourceBundle() {
		setParent(ResourceBundle.getBundle(name, locale, utf8Control));
	}

	@Override
	protected Object handleGetObject(String key) {
		if (development) {
			// load the fresh file every time during development
			initializeResourceBundle();
		}

		return parent.getObject(key);
	}

	@Override
	public Enumeration<String> getKeys() {
		return parent.getKeys();
	}

	/**
	 * Control class that supports UTF8.
	 */
	private static class UTF8Control extends Control {

		private boolean alwaysReload;
		private Long timeToLive;

		UTF8Control() {
			alwaysReload = false;
		}

		@Override
		public ResourceBundle newBundle(String baseName, Locale locale,
				String format, ClassLoader loader, boolean reload)
			throws IllegalAccessException, InstantiationException,
				IOException {
			/**
			 * The below code is copied from default Control#newBundle()
			 * implementation. Only the PropertyResourceBundle line is changed
			 * to read the file as UTF-8.
			 */
			String bundleName = toBundleName(baseName, locale);
			String resourceName = toResourceName(bundleName, BUNDLE_EXTENSION);
			ResourceBundle bundle = null;
			InputStream stream = null;

			// Create the stream.
			if (reload || alwaysReload) {
				URL url = loader.getResource(resourceName);
				if (url != null) {
					URLConnection connection = url.openConnection();
					if (connection != null) {
						connection.setUseCaches(false);
						stream = connection.getInputStream();
					}
				}
			} else {
				stream = loader.getResourceAsStream(resourceName);
			}

			// Create the bundle.
			if (stream != null) {
				try {
					Reader reader = new InputStreamReader(stream, CHARSET);
					bundle = new PropertyResourceBundle(reader);
				} finally {
					stream.close();
				}
			}
			return bundle;
		}

		void setTimeToLive(long ttl) {
			timeToLive = ttl;
		}

		public void setAlwaysReload(boolean reload) {
			alwaysReload = reload;
		}

		@Override
		public long getTimeToLive(String baseName, Locale locale) {
			if (timeToLive == null) {
				return super.getTimeToLive(baseName, locale);
			}
			return timeToLive;
		}

	}

}
