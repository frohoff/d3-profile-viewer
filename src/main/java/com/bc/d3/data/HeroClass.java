package com.bc.d3.data;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonValue;

public enum HeroClass {

	BARBARIAN("barbarian"),
	DEMON_HUNTER("demon-hunter"),
	MONK("monk"),
	WITCH_DOCTOR("witch-doctor"),
	WIZARD("wizard");

	private final String value;

	private HeroClass(String value) {
		this.value = value;
	}

	@JsonValue
	public String stringValue() {
		return value;
	}

	@JsonCreator
	public static HeroClass forValue(String string) {
		for (HeroClass clazz : HeroClass.class.getEnumConstants()) {
			if (clazz.stringValue().equals(string)) {
				return clazz;
			}
		}
		return null;
	}

}
