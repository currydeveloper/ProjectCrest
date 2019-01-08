package com.webapp.jerseyRest;

import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONObject;

import com.webapp.jerseyRest.ResourceMethods.DatabasePropertiesReader;
import com.webapp.jerseyRest.ResourceMethods.ResourceTypes;
import com.webapp.jerseyRest.ResourceMethods.serviceProviderConfigJson;

@Path("/Resources")
public class Resources {

	@GET
	@Path("/ResourceTypes")
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject getResourceTypes() {
		return ResourceTypes.resourceTypeObject();
	}

	@GET
	@Path("/ServiceProviderConfig")
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject getServiceProviderConfigObject(){
		return serviceProviderConfigJson.getServiceProvConfig();
	}
	@GET
	@Path("/dbinfo")
	@Produces(MediaType.TEXT_PLAIN)
	public String getDbPropInfo() throws IOException {
		DatabasePropertiesReader db = new DatabasePropertiesReader();
		return db.getPropValues();
	}
}
