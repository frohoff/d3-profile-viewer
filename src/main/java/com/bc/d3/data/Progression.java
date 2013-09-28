package com.bc.d3.data;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonAutoDetect.Visibility;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Progression {

	private Act act1;
	private Act act2;
	private Act act3;
	private Act act4;

	public Act getAct1() {
		return act1;
	}

	public Act getAct2() {
		return act2;
	}

	public Act getAct3() {
		return act3;
	}

	public Act getAct4() {
		return act4;
	}

}
