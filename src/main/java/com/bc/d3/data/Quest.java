package com.bc.d3.data;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonAutoDetect.Visibility;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
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
