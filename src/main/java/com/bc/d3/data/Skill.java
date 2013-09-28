package com.bc.d3.data;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonAutoDetect.Visibility;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Skill {

	@JsonProperty("skill")
	private Base base;

	private Rune rune;

	public Base getBase() {
		return base;
	}

	public Rune getRune() {
		return rune;
	}

	@JsonAutoDetect(fieldVisibility = Visibility.ANY)
	public static class Base {

		private String slug;
		private String name;
		private String icon;
		private int level;
		private String categorySlug;
		private String tooltipUrl;
		private String description;
		private String simpleDescription;
		private String flavor;
		private String skillCalcId;

		public String getSlug() {
			return slug;
		}

		public String getName() {
			return name;
		}

		public String getIcon() {
			return icon;
		}

		public int getLevel() {
			return level;
		}

		public String getCategorySlug() {
			return categorySlug;
		}

		public String getTooltipUrl() {
			return tooltipUrl;
		}

		public String getDescription() {
			return description;
		}

		public String getSimpleDescription() {
			return simpleDescription;
		}

		public String getFlavor() {
			return flavor;
		}

		public String getSkillCalcId() {
			return skillCalcId;
		}

	}

	@JsonAutoDetect(fieldVisibility = Visibility.ANY)
	public static class Rune {

		private String slug;
		private String type;
		private String name;
		private int level;
		private String description;
		private String simpleDescription;
		private String tooltipParams;
		private String skillCalcId;
		private int order;

		public String getSlug() {
			return slug;
		}

		public String getType() {
			return type;
		}

		public String getName() {
			return name;
		}

		public int getLevel() {
			return level;
		}

		public String getDescription() {
			return description;
		}

		public String getSimpleDescription() {
			return simpleDescription;
		}

		public String getTooltipParams() {
			return tooltipParams;
		}

		public String getSkillCalcId() {
			return skillCalcId;
		}

		public int getOrder() {
			return order;
		}

	}

}
