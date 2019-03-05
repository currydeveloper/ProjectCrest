package com.webapp.jerseyRest.ResourceMethods;

import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.json.simple.JSONObject;

import com.webapp.jerseyRest.BadRequest;

public class postRequest {

	public static JSONObject createUsers(JSONObject users) throws IOException {
		DatabaseBaseMethods dbm = new DatabaseBaseMethods();
		Connection con = dbm.getDbConnection();
		JSONObject userReturnObject = new JSONObject();
		Map<String, String> errorMap = new HashMap<String, String>();
		if (null == users || users.isEmpty()) {
			errorMap.put("Reason to Fail", "No Values");
			throw new BadRequest(errorMap);
		}
		System.out.println("Starting the input value iteration");
		Set keys = users.keySet();
		if (!keys.isEmpty()) {
			Iterator<?> it = keys.iterator();
			while (it.hasNext()) {
				String objKey = (String) it.next();
				boolean colCheck = checkDBColumns(objKey);
				if (!colCheck) {
					errorMap.put(objKey, "is Absent");
				}
			}
		}
		if (!errorMap.isEmpty()) {
			System.out.println("Errors are present");
			throw new BadRequest(errorMap);
		}
		return userReturnObject;
	}

	private static boolean checkDBColumns(String objKey) {
		// TODO Auto-generated method stub
		return false;
	}

}
