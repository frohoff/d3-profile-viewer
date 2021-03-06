package com.bc.d3.web.beans;

import java.io.IOException;
import java.util.Date;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.bc.d3.NotFoundException;
import com.bc.d3.data.Profile;
import com.bc.d3.repo.ProfileRepository;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;

import static com.bc.d3.web.Functions.urlencode;

@Component
@Scope("request")
public class ProfileBean {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProfileBean.class);
	private static final long HOUR_MILLISECONDS = 3600000;
	private static final String PROFILE_API = "http://%s.battle.net/api/d3/profile/%s-%s/index";

	private String region;
	private String battleTagName;
	private int battleTagCode;

	private Profile cachedProfile;

	@Autowired
	private ProfileRepository profileRepo;

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getBattleTagName() {
		return battleTagName;
	}

	public void setBattleTagName(String battleTagName) {
		this.battleTagName = battleTagName;
	}

	public int getBattleTagCode() {
		return battleTagCode;
	}

	public void setBattleTagCode(int battleTagCode) {
		this.battleTagCode = battleTagCode;
	}

	public String getBattleTag() {
		return battleTagName + "#" + battleTagCode;
	}

	public Profile getProfile() {
		if (cachedProfile != null) {
			return cachedProfile;
		}

		cachedProfile = profileRepo.findOne(getBattleTag());
		if ((cachedProfile != null) && isFresh(cachedProfile)) {
			return cachedProfile;
		}

		cachedProfile = fetchProfile();
		if (cachedProfile == null) {
			LOGGER.warn("Cached profile could not be found.");
			throw new NotFoundException();
		}

		profileRepo.save(cachedProfile);
		return cachedProfile;
	}

	private Profile fetchProfile() {
		try {
			Client client = Client.create();
			WebResource resource = client.resource(String.format(PROFILE_API,
					region, urlencode(battleTagName), battleTagCode));
			String json = resource.get(String.class);
			ObjectMapper mapper = new ObjectMapper();
			return mapper.readValue(json, Profile.class);
		} catch (UniformInterfaceException exception) {
			LOGGER.error("Error occurred contacting D3 server", exception);
			throw new NotFoundException();
		} catch (JsonParseException exception) {
			LOGGER.error("Error occurred parsing JSON response", exception);
			throw new NotFoundException();
		} catch (JsonMappingException exception) {
			LOGGER.error("Error occurred parsing JSON response", exception);
			throw new NotFoundException();
		} catch (IOException exception) {
			LOGGER.error("Unknown error occurred", exception);
			throw new NotFoundException();
		}
	}

	private static boolean isFresh(Profile profile) {
		Date now = new Date();
		long diff = now.getTime() - profile.getLastRefreshed().getTime();
		return diff < HOUR_MILLISECONDS;
	}

}
