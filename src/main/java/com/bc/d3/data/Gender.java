package com.bc.d3.data;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonValue;

public enum Gender {

	MALE(0),
	FEMALE(1);

	private final int value;

	private Gender(int value) {
		this.value = value;
	}

	@JsonValue
	public int intValue() {
		return value;
	}

	@Override
	public String toString() {
		if (value == 0) {
			return "Male";
		}
		return "Female";
	}

	@JsonCreator
	public static Gender forValue(int value) {
		for (Gender gender : Gender.class.getEnumConstants()) {
			if (gender.intValue() == value) {
				return gender;
			}
		}
		return null;
	}

}
