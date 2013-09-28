package com.bc.d3;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bc.d3.data.Hero;
import com.bc.d3.data.Profile;
import com.bc.d3.repo.HeroRepository;
import com.bc.d3.repo.ProfileRepository;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class D3Client {

	private static final String XML_PATH = "META-INF/spring/*.xml";

	private AbstractApplicationContext appContext;
	private ProfileRepository profileRepo;
	private HeroRepository heroRepo;

	public D3Client() {
		appContext = new ClassPathXmlApplicationContext(XML_PATH);
		profileRepo = appContext.getBean(ProfileRepository.class);
		heroRepo = appContext.getBean(HeroRepository.class);
	}

	public void run() throws JsonParseException, JsonMappingException,
			IOException {
		String host = "http://us.battle.net";
		String api = "/api/d3/profile/";
		String battleTag = "wasabi-1664";
		String file = "/Users/bradchen/d3.json";

		//Client client = Client.create();
		//WebResource resource = client.resource(host + api + battleTag + "/hero/11058154");
		//String json = resource.get(String.class);
		//FileUtils.write(new File(file), json);

		String json = FileUtils.readFileToString(new File(file));
		ObjectMapper mapper = new ObjectMapper();
		Hero hero = mapper.readValue(json, Hero.class);
		System.out.println(hero.getLevel());

		/*
		Profile profile = mapper.readValue(json, Profile.class);
		//System.out.println(profile);
		profileRepo.save(profile);
		heroRepo.save(profile.getHeroes());
		heroRepo.save(profile.getFallenHeroes());

		List<Profile> profiles = profileRepo.findAll();
		for (Profile p : profiles) {
			System.out.println("Profile found: " + p.getHeroes());
			//profileRepo.delete(p);
		}*/
	}

	public void close() {
		appContext.close();
	}

	public static void main(String[] args) throws JsonParseException,
			JsonMappingException, IOException {
		D3Client client = null;
		try {
			client = new D3Client();
			client.run();
		} finally {
			if (client != null) {
				client.close();
			}
		}
	}

}
