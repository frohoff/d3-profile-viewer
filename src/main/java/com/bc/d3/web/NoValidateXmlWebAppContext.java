package com.bc.d3.web;

import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.web.context.support.XmlWebApplicationContext;

public class NoValidateXmlWebAppContext extends XmlWebApplicationContext {

	@Override
	protected void initBeanDefinitionReader(XmlBeanDefinitionReader reader) {
		reader.setValidating(false);
		super.initBeanDefinitionReader(reader);
	}

}
