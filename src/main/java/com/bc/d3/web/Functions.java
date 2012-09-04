package com.bc.d3.web;

import com.bc.d3.data.HeroClass;

public final class Functions {

	public static String getHeroClassName(HeroClass clazz) {
		switch (clazz) {
			case BARBARIAN:
				return "Barbarian";

			case DEMON_HUNTER:
				return "Demon Hunter";

			case MONK:
				return "Monk";

			case WITCH_DOCTOR:
				return "Witch Doctor";

			case WIZARD:
				return "Wizard";

			default:
				return null;
		}
	}

	private Functions() {
	}

}
