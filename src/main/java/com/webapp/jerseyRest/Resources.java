package com.webapp.jerseyRest;

import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONObject;

import com.webapp.jerseyRest.ResourceMethods.DatabaseBaseMethods;
import com.webapp.jerseyRest.ResourceMethods.ResourceTypes;
import com.webapp.jerseyRest.ResourceMethods.SchemaContainer;
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
	public JSONObject getServiceProviderConfigObject() {
		return serviceProviderConfigJson.getServiceProvConfig();
	}

	@GET
	@Path("/Schemas")
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject getSchemas() {
		return SchemaContainer.schemaResource();
	}

	@GET
	@Path("/Users")
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject getUserReadObj() throws IOException {
		DatabaseBaseMethods dm = new DatabaseBaseMethods();
		return dm.getDataFromDb();
	}

	//	// Testing new functionality
	//	@GET
	//	@Path("/Users/{id}")
	//	@Produces({ "application/json" })
	//	public JSONObject getTestResources(@PathParam("id") String id) throws IOException, SQLException {
	//		System.out.println("This is the id" + id);
	//		return UsersDataWithId.getUserInfoWithId(id);
	//	}
	//
	//	@GET
	//	@Path("/test")
	//	@Produces({ "application/json" })
	//	public JSONObject getTestResourceWithCount(@QueryParam("count") int count,
	//			@QueryParam("attributes") int attributes) {
	//		System.out.println("This is the count" + count);
	//		System.out.println("This is the attributes" + attributes);
	//		return serviceProviderConfigJson.getServiceProvConfig();
	//	}

}
