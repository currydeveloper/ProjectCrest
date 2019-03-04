package com.webapp.jerseyRest.ResourceMethods;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;

import com.webapp.jerseyRest.BadRequest;

public class postRequest {

	public static JSONObject createUsers(JSONObject users) {
		JSONObject userReturnObject = new JSONObject();
		if(null==users) {
			Map<String,String> errorMap=new HashMap();
			throw new BadRequest(errorMap);
		}


		return userReturnObject;
	}

}
