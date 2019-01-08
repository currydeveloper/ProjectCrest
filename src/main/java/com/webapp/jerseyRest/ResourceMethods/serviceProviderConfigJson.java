package com.webapp.jerseyRest.ResourceMethods;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class serviceProviderConfigJson {
	@SuppressWarnings("unchecked")
	public static JSONObject getServiceProvConfig() {
		JSONObject jObj = new JSONObject();
		JSONArray list = new JSONArray();
		list.add("urn:ietf:params:scim:schemas:core:2.0:ServiceProviderConfig");
		jObj.put("schemas", list);
		jObj.put("documentationUri", "https://tools.ietf.org/html/rfc7643");
		JSONObject patch = new JSONObject();
		patch.put("supported", false);
		jObj.put("patch", patch);
		JSONObject bulk = new JSONObject();
		bulk.put("supported", false);
		jObj.put("bulk", bulk);
		JSONObject sort = new JSONObject();
		sort.put("supported", false);
		jObj.put("sort", sort);
		JSONObject changePassword = new JSONObject();
		changePassword.put("supported", true);
		jObj.put("changePassword", changePassword);
		JSONObject etag = new JSONObject();
		etag.put("supported", false);
		jObj.put("etag", etag);
		JSONObject filter = new JSONObject();
		filter.put("supported", true);
		filter.put("maxResults", 200);
		jObj.put("filter", filter);
		// ---> IF want change the modification from down below.
		/*
		 * The below JSON array contains two objects namely OAuth2 and the HTTP Basic
		 * Currently the HTTP basic is set to the primary Change/ Add other
		 * authentication methods based on need. add them to the authenticationSchemes
		 * array.
		 */
		JSONArray authenticationSchemes = new JSONArray();
		JSONObject oauth = new JSONObject();
		oauth.put("name", "OAuth Bearer Token");
		oauth.put("description", "Authentication scheme using the OAuth Bearer Token Standard");
		oauth.put("specUri", "http://www.rfc-editor.org/info/rfc6750");
		oauth.put("documentationUri", "http://www.rfc-editor.org/info/rfc6750");
		oauth.put("type", "oauthbearertoken");
		oauth.put("primary", true);
		authenticationSchemes.add(oauth);
		JSONObject basic = new JSONObject();
		basic.put("name", "HTTP Basic");
		basic.put("description", "Authentication scheme using the HTTP Basic Standard");
		basic.put("specUri", "http://www.rfc-editor.org/info/rfc2617");
		basic.put("documentationUri", "http://www.rfc-editor.org/info/rfc2617");
		basic.put("type", "httpbasic");
		authenticationSchemes.add(basic);
		jObj.put("authenticationSchemes", authenticationSchemes);
		JSONObject meta = new JSONObject();
		meta.put("location", "http://localhost:11080/SCIM_REST_API/rest/ServiceProviderConfig");
		meta.put("resourceType", "ServiceProviderConfig");
		meta.put("created", "2010-01-23T04:56:22Z");
		meta.put("version", "1");
		meta.put("lastModified", "2011-05-13T04:42:34Z");
		jObj.put("meta", meta);
		return jObj;
	}
}
