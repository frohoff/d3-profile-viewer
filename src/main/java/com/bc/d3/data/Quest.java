package com.bc.d3.data;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonAutoDetect.Visibility;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Quest {

	private String slug;
	private String name;

	public String getSlug() {
		return slug;
	}

	public String getName() {
		return name;
	}

}
