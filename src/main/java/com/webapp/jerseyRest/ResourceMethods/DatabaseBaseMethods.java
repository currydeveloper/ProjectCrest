package com.webapp.jerseyRest.ResourceMethods;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DatabaseBaseMethods {
	public String url;
	public String usn;
	public String pwd;
	public String query;
	DatabasePropertiesReader dc = new DatabasePropertiesReader();

	public Connection getDbConnection() throws IOException {
		System.out.println("came into the getDb");

		Map<?, ?> pMap = dc.getPropValues();
		String URL = (String) pMap.get("url");
		String uName = (String) pMap.get("usn");
		String pswd = (String) pMap.get("pwd");
		System.out.println("got the URL" + URL);
		Connection con = null;
		/*
		 * Properties connProp=new Properties(); connProp.put("user", uName);
		 * connProp.put("password", pswd);
		 */
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL, uName, pswd);
			return con;
		} catch (Exception e) {
			System.out.println("This is the error here in the Database get Connection method" + e);
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public JSONObject getDataFromDb() throws IOException {
		Connection conInGetDb = getDbConnection();
		Map<?, ?> pMap = dc.getPropValues();
		String tableName = (String) pMap.get("tableName");
		System.out.println("table name from the map" + tableName);
		String Query = "select * from " + tableName + ";";
		JSONArray resourceArray = new JSONArray();
		JSONObject userObj = new JSONObject();

		JSONObject meta = new JSONObject();
		meta.put("location", "http://localhost:11080/jerseyRest/scim/Resources/Users");
		meta.put("resourceType", "Users");
		meta.put("created", "2010-01-23T04:56:22Z");
		meta.put("version", "1");
		meta.put("lastModified", "2011-05-13T04:42:34Z");
		userObj.put("meta", meta);
		System.out.println("This is the Query " + Query);
		try {
			if (null != conInGetDb) {
				Statement st = conInGetDb.createStatement();
				ResultSet rs = st.executeQuery(Query);
				while (rs.next()) {
					ResultSetMetaData metaData = rs.getMetaData();
					JSONObject tmpJson = new JSONObject();
					for (int i = 0; i < metaData.getColumnCount(); i++) {
						tmpJson.put(metaData.getColumnLabel(i + 1), rs.getObject(i + 1));
					}
					resourceArray.add(tmpJson);
					break;
				}
				userObj.put("Resources", resourceArray);
			} else {
				System.out.println("connection from get connection is null");
				return userObj;
			}

		} catch (Exception e) {
			System.out.println("This is the error from the try catch in getDataFromDB" + e);
		}

		return userObj;
	}
}
