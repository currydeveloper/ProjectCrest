package com.webapp.jerseyRest.ResourceMethods;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DatabasePropertiesReader {

	String result = "";
	InputStream inputstrm;
	private String url;
	private String usn;
	private String pwd;
	private String query;

	public void getPropValues() throws IOException {
		try {
			Properties prop = new Properties();
			String fileName = "db.properties";
			inputstrm = getClass().getClassLoader().getResourceAsStream(fileName);
			if (null != inputstrm) {
				prop.load(inputstrm);
			} else {
				throw new FileNotFoundException("property file '" + fileName + "' not found in the classpath");
			}
			this.url = prop.getProperty("url");
			usn = prop.getProperty("username");
			pwd = prop.getProperty("password");
			query = prop.getProperty("query");
			result = "URL : \"" + url + "\" \nUserName : \"" + usn + "\" \nPassword : \"" + pwd + "\"";
			System.out.println("result-->" + result);
		} catch (Exception e) {
			System.out.println("Error in the properties reading " + e);
		} finally {
			inputstrm.close();
		}
		// return result;
	}

	public String getPwd() {
		return pwd;
	}

	public String getUrl() {

		return url;
	}

	public String getQuery() {
		return query;
	}

	public String getUsn() {
		return this.usn;
	}

}
