package com.webapp.jerseyRest.ResourceMethods;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class DatabasePropertiesReader {

	String result = "";
	InputStream inputstrm;
	public String url;
	public String usn;
	public String pwd;
	public String query;

	public Map<String, String> getPropValues() throws IOException {
		Map<String, String> propMap = new HashMap<String, String>();
		try {
			Properties prop = new Properties();
			String fileName = "db.properties";
			inputstrm = getClass().getClassLoader().getResourceAsStream(fileName);
			if (null != inputstrm) {
				prop.load(inputstrm);
			} else {
				throw new FileNotFoundException("property file '" + fileName + "' not found in the classpath");
			}
			url = prop.getProperty("url");
			propMap.put("url", url);
			usn = prop.getProperty("username");
			propMap.put("usn", usn);
			pwd = prop.getProperty("password");
			propMap.put("pwd", pwd);
			query = prop.getProperty("query");
			System.out.println("This is the query for the" + query);
			propMap.put("query", query);
			result = "URL : \"" + url + "\" \nUserName : \"" + usn + "\" \nPassword : \"" + pwd + "\"";
			System.out.println("result-->" + result);
		} catch (Exception e) {
			System.out.println("Error in the properties reading " + e);
		} finally {
			inputstrm.close();
		}
		return propMap;
	}
}
