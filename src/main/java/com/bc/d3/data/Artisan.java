package com.bc.d3.data;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonAutoDetect.Visibility;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Artisan {

	private String slug;
	private int level;
	private int stepCurrent;
	private int stepMax;

	public String getSlug() {
		return slug;
	}

	public int getLevel() {
		return level;
	}

	public int getStepCurrent() {
		return stepCurrent;
	}

	public int getStepMax() {
		return stepMax;
	}

}
