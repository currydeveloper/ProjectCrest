package com.webapp.jerseyRest.ResourceMethods;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class UsersDataWithId {
	static DatabasePropertiesReader dc = new DatabasePropertiesReader();

	@SuppressWarnings("unchecked")
	public static JSONObject getUserInfoWithId(String id) throws IOException, SQLException {
		DatabaseBaseMethods dbm = new DatabaseBaseMethods();
		Connection con = dbm.getDbConnection();
		JSONObject jUserIdObj = new JSONObject();
		JSONObject meta = new JSONObject();
		JSONArray resArray = new JSONArray();
		meta.put("location", "http://localhost:11080/jerseyRest/scim/Resources/Users");
		meta.put("resourceType", "Users");
		meta.put("created", "2010-01-23T04:56:22Z");
		meta.put("version", "1");
		meta.put("lastModified", "2011-05-13T04:42:34Z");
		jUserIdObj.put("totalResults", 1);
		jUserIdObj.put("itemsPerPage", 1);
		jUserIdObj.put("schemas", new JSONArray().add("urn:ietf:params:scim:api:messages:2.0:ListResponse"));
		try {
			Map<?, ?> pMap = dc.getPropValues();
			String tableName = (String) pMap.get("tableName");
			System.out.println("table name from the map for the id" + tableName);
			String Query = "select * from " + tableName + " where id=" + id;
			if (null != con) {
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(Query);
				while (rs.next()) {
					ResultSetMetaData metaData = rs.getMetaData();
					JSONObject tmpJson = new JSONObject();
					for (int i = 0; i < metaData.getColumnCount(); i++) {
						tmpJson.put(metaData.getColumnLabel(i + 1), rs.getObject(i + 1));
					}
					tmpJson.put("meta", meta);
					resArray.add(tmpJson);
				}
			}
		} catch (Exception e) {
			System.out.println("Error occured in getting UserDataWithId : " + e);
		} finally {
			con.close();
		}
		jUserIdObj.put("Resources", resArray);
		return jUserIdObj;
	}

}
