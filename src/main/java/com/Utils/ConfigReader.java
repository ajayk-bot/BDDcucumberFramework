package com.Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private Properties prop;

	public Properties init_properties() {
		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\configuration\\config.properties");
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}

		
		return prop;
	}

}
