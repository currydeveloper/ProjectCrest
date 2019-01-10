package com.webapp.jerseyRest.ResourceMethods;

import java.sql.Connection;
import java.sql.DriverManager;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DatabaseBaseMethods {
	public String url;
	public String usn;
	public String pwd;
	public String query;

	public Connection getDbConnection() {
		System.out.println("came into the getDb");
		DatabasePropertiesReader dc = new DatabasePropertiesReader();
		String URL = dc.getUrl();
		String uName = dc.getUsn();
		String pswd = dc.getPwd();
		System.out.println("got the URL" + URL);
		Connection con = null;
		/*
		 * Properties connProp=new Properties(); connProp.put("user", uName);
		 * connProp.put("password", pswd);
		 */
		try {
			con = DriverManager.getConnection(URL, uName, pswd);
			return con;
		} catch (Exception e) {
			System.out.println("This is the error here in the Database get Connection method" + e);
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public JSONObject getDataFromDb() {
		Connection conInGetDb = getDbConnection();
		// DatabasePropertiesReader dc = new DatabasePropertiesReader();
		String Query = query;
		JSONArray resourceArray = new JSONArray();
		JSONObject userObj = new JSONObject();

		JSONObject meta = new JSONObject();
		meta.put("location", "http://localhost:11080/SCIM_REST_API/rest/ServiceProviderConfig");
		meta.put("resourceType", "Users");
		meta.put("created", "2010-01-23T04:56:22Z");
		meta.put("version", "1");
		meta.put("lastModified", "2011-05-13T04:42:34Z");
		userObj.put("meta", meta); /*
		 * try { if (null != conInGetDb) { Statement st = conInGetDb.createStatement();
		 * ResultSet rs = st.executeQuery(query); while (rs.next()) { ResultSetMetaData
		 * metaData = rs.getMetaData(); for (int i = 0; i < metaData.getColumnCount();
		 * i++) { JSONObject tmpJson = new JSONObject();
		 * tmpJson.put(metaData.getColumnLabel(i + 1), rs.getObject(i + 1));
		 * resourceArray.add(tmpJson); } break; } userObj.put("Resources",
		 * resourceArray); } else {
		 * System.out.println("connection from get connection is null"); return userObj;
		 * }
		 *
		 * } catch (Exception e) {
		 * System.out.println("This is the error from the try catch in getDataFromDB" +
		 * e); }
		 */
		return userObj;
	}
}
