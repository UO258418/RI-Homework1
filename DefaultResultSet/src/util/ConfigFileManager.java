package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileManager {
	
	private final static ConfigFileManager instance = new ConfigFileManager();
	private Properties props = new Properties();

	private ConfigFileManager() {
		try {
			FileInputStream fis = new FileInputStream("src/config.properties");
			props.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static ConfigFileManager getInstance() {
		return instance;
	}
	
	public String getProperty(String prop) {
		return props.getProperty(prop);
	}
	
}
