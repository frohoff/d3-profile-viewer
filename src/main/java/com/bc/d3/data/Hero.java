package com.bc.d3.data;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonAutoDetect.Visibility;
import org.codehaus.jackson.annotate.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "heroes")
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class Hero {

	private static final long MILLISECOND_MULTIPLIER = 1000;

	@Id
	private Long id;

	@JsonIgnore
	private String battleTag;
	private String name;
	private int level;
	private int paragonLevel;
	private boolean hardcore;
	private Gender gender;
	private boolean dead;
	private CharacterStats stats;

	@JsonProperty("class")
	private HeroClass heroClass;

	@JsonProperty("last-updated")
	private long lastUpdatedTimestamp;

	@JsonIgnore
	private long lastRefreshedTimestamp;

	private Map<String, List<Skill>> skills;
	private Map<String, Item> items;
	private Map<String, Follower> followers;
	private Map<String, Long> kills;

	@JsonProperty("progress")
	private Map<String, Progression> progression;

	public Hero() {
		lastRefreshedTimestamp = new Date().getTime() / MILLISECOND_MULTIPLIER;
	}

	public Long getId() {
		return id;
	}

	public String getBattleTag() {
		return battleTag;
	}

	public void setBattleTag(String battleTag) {
		this.battleTag = battleTag;
	}

	public String getName() {
		return name;
	}

	public int getLevel() {
		return level;
	}

	public int getParagonLevel() {
		return paragonLevel;
	}

	public boolean getHardcore() {
		return hardcore;
	}

	public Gender getGender() {
		return gender;
	}

	public boolean getDead() {
		return dead;
	}

	public HeroClass getHeroClass() {
		return heroClass;
	}

	public CharacterStats getStats() {
		return stats;
	}

	public Date getLastUpdated() {
		return new Date(lastUpdatedTimestamp * MILLISECOND_MULTIPLIER);
	}

	public Date getLastRefreshed() {
		return new Date(lastRefreshedTimestamp * MILLISECOND_MULTIPLIER);
	}

	public Map<String, List<Skill>> getSkills() {
		return Collections.unmodifiableMap(skills);
	}

	public Map<String, Item> getItems() {
		return Collections.unmodifiableMap(items);
	}

	public Map<String, Follower> getFollowers() {
		return Collections.unmodifiableMap(followers);
	}

	public Map<String, Long> getKills() {
		return Collections.unmodifiableMap(kills);
	}

	public Map<String, Progression> getProgression() {
		return Collections.unmodifiableMap(progression);
	}

}
