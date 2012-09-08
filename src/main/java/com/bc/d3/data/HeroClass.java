package com.bc.d3.data;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonValue;

public enum HeroClass {

	BARBARIAN("barbarian"),
	DEMON_HUNTER("demon-hunter", "demonHunter"),
	MONK("monk"),
	WITCH_DOCTOR("witch-doctor", "witchDoctor"),
	WIZARD("wizard");

	private final String value;
	private final String valueCamelCase;

	private HeroClass(String value) {
		this.value = value;
		this.valueCamelCase = value;
	}

	private HeroClass(String value, String valueCamelCase) {
		this.value = value;
		this.valueCamelCase = valueCamelCase;
	}

	@Override
	@JsonValue
	public String toString() {
		return value;
	}

	public String toStringCamelCase() {
		return valueCamelCase;
	}

	@JsonCreator
	public static HeroClass forValue(String string) {
		for (HeroClass clazz : HeroClass.class.getEnumConstants()) {
			if (clazz.toString().equals(string)) {
				return clazz;
			}
		}
		return null;
	}

}
