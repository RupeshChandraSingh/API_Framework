package com.go.base;

import java.util.Properties;

import org.testng.annotations.BeforeTest;

import com.go.config.ConfigManager;
import com.go.restclient.RestClients;

public class BaseTest {

	public ConfigManager config;
	public Properties prop;

	public RestClients restClient;
	
	public String goRestServiceUrl = "/public/v2/users";

	@BeforeTest
	public void setUp() {
		config = new ConfigManager();
		prop = config.initProperty();
		String baseURI = prop.getProperty("baseURI");
		restClient = new RestClients(prop, prop.getProperty("baseURI"));
	}
}
