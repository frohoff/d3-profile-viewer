package com.bc.d3.data;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonAutoDetect.Visibility;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "profiles")
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Profile {

	private static final long MILLISECOND_MULTIPLIER = 1000;

	@Id
	private String battleTag;

	@JsonProperty("lastHeroPlayed")
	private long lastHeroPlayedTimestamp;

	@JsonProperty("lastUpdated")
	private long lastUpdatedTimestamp;

	@JsonIgnore
	private long lastRefreshedTimestamp;

	private Map<String, Long> kills;
	private Map<String, Float> timePlayed;
	private List<Hero> heroes;
	private List<Hero> fallenHeroes;
	private List<Artisan> artisans;
	private List<Artisan> hardcoreArtisans;
	private Map<String, Progression> progression;
	private Map<String, Progression> hardcoreProgression;

	public Profile() {
		lastRefreshedTimestamp = new Date().getTime() / MILLISECOND_MULTIPLIER;
	}

	public String getBattleTag() {
		return battleTag;
	}

	public Date getLastHeroPlayed() {
		return new Date(lastHeroPlayedTimestamp * MILLISECOND_MULTIPLIER);
	}

	public Date getLastUpdated() {
		return new Date(lastUpdatedTimestamp * MILLISECOND_MULTIPLIER);
	}

	public Date getLastRefreshed() {
		return new Date(lastRefreshedTimestamp * MILLISECOND_MULTIPLIER);
	}

	public Map<String, Long> getKills() {
		return Collections.unmodifiableMap(kills);
	}

	public Map<String, Float> getTimePlayed() {
		return Collections.unmodifiableMap(timePlayed);
	}

	public List<Hero> getHeroes() {
		return Collections.unmodifiableList(heroes);
	}

	public List<Hero> getFallenHeroes() {
		return Collections.unmodifiableList(fallenHeroes);
	}

	public List<Artisan> getArtisans() {
		return Collections.unmodifiableList(artisans);
	}

	public List<Artisan> getHardcoreArtisans() {
		return Collections.unmodifiableList(hardcoreArtisans);
	}

	public Map<String, Progression> getProgression() {
		return Collections.unmodifiableMap(progression);
	}

	public Map<String, Progression> getHardcoreProgression() {
		return Collections.unmodifiableMap(hardcoreProgression);
	}

}
