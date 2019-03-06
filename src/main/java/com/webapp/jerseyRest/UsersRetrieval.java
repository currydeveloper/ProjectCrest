package com.webapp.jerseyRest;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONObject;

import com.webapp.jerseyRest.ResourceMethods.UsersDataWithId;

@Path("/Resources/Users")
public class UsersRetrieval {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject getUsers() throws IOException, SQLException {
		return UsersDataWithId.getUserInfoWithId("20");
	}

	@GET
	@Path("/{id}")
	@Produces()
	public JSONObject getUsersWithId(@DefaultValue("1") @PathParam("id") String id) throws IOException, SQLException {
		return UsersDataWithId.getUserInfoWithId(id);
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public JSONObject postUsersRequest(JSONObject userRequestObj) {
		System.out.println("came into the post body");
		Map<String, String> errorMap = new HashMap<String, String>();
		if (null == userRequestObj || userRequestObj.isEmpty()) {
			System.out.println("came into the post body");
			errorMap.put("Reason", "object passed is Empty");
			throw new BadRequest(errorMap);
		}
		Map<?, ?> testMap = new HashMap<Object, Object>();
		return userRequestObj;
	}
}
