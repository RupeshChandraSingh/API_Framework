package com.go.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.go.utils.FrameworkException;

public class ConfigManager {

	private Properties prop;
	private FileInputStream fis;

	public Properties initProperty() {

		prop = new Properties();

		String env = System.getProperty("env");

		try {
			if (env == null) {
				System.out.println("Environment is not specified so running in QA env .. ");
				fis = new FileInputStream("./src/test/resources/configs/qa.properties");
			} else {
				switch (env.toLowerCase().trim()) {
				case "qa":
					fis = new FileInputStream("./src/test/resources/configs/qa.properties");
					break;
				case "dev":
					fis = new FileInputStream("./src/test/resources/configs/qa.properties");
					break;

				default:
					System.out.println("Please provide valid environment");

					throw new FrameworkException("InvalidEnvironmentException");
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop;

	}
}
