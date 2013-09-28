package com.bc.d3.data;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonAutoDetect.Visibility;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Follower {

	private String slug;
	private int level;
	private CharacterStats stats;
	private Map<String, Item> items;
	private List<Skill> skills;

	public String getSlug() {
		return slug;
	}

	public int getLevel() {
		return level;
	}

	public CharacterStats getStats() {
		return stats;
	}

	public Map<String, Item> getItems() {
		return Collections.unmodifiableMap(items);
	}

	public List<Skill> getSkills() {
		return Collections.unmodifiableList(skills);
	}

}
