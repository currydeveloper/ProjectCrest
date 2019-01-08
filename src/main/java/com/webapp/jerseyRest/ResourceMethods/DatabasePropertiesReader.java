package com.webapp.jerseyRest.ResourceMethods;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

public class DatabasePropertiesReader {
	String result = "";
	InputStream inputstrm;

	public String getPropValues() throws IOException {
		try {
			Properties prop = new Properties();
			String fileName = "db.properties";
			inputstrm = getClass().getClassLoader().getResourceAsStream(fileName);
			if (null != inputstrm) {
				prop.load(inputstrm);
			}
			else {
				throw new FileNotFoundException("property file '" + fileName + "' not found in the classpath");
			}
			Date time = new Date(System.currentTimeMillis());
			String url = prop.getProperty("url");
			result = "url ===" + url;
			System.out.println("result-->" + result);
		}
		catch (Exception e) {
			System.out.println("Error in the properties reading " + e);
		} finally {
			inputstrm.close();
		}
		return result;
	}
}
