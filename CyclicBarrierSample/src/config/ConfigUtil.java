package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigUtil {

	private static String configFile = "C:\\test\\config\\config.properties";

	public static Properties getConfigFile(){

		Properties properties = new Properties();

		try(InputStream inputStream = new FileInputStream(configFile)){

			properties.load(inputStream);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}
}
