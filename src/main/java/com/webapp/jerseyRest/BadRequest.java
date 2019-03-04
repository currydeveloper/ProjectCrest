package com.webapp.jerseyRest;

import java.util.Map;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

public class BadRequest extends WebApplicationException {
	private static final long serialVersionUID = 1L;
	// public BadRequest(List errors) {
	// super(Response.status(Status.BAD_REQUEST).type(MediaType.APPLICATION_JSON)
	// .entity(new GenericEntity<List>(errors) {
	// }).build());
	// }

	public BadRequest(Map nMap) {
		super(Response.status(Status.BAD_REQUEST).type(MediaType.APPLICATION_JSON).entity(new GenericEntity<Map>(nMap) {
		}).build());
	}
}
