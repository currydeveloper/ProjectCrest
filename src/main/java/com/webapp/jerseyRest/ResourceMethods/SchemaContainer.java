package com.webapp.jerseyRest.ResourceMethods;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class SchemaContainer {
	@SuppressWarnings("unchecked")
	public static JSONObject schemaResource() {
		/*
		 * The Schema resource is build according to the standards of SCIM which is a
		 * huge JSON Object containing multiple JSON Objects and JSON Arrays. The main
		 * JSON Object is Schema Object which contains regular String values + JSON
		 * array for some.
		 */
		JSONObject schemaObject = new JSONObject();
		/*
		 * Starting of the attributes array in JSOn -------------> Below JSON Object are
		 * part of the Attributes JSON array. For adding new Attributes to the schema
		 * add a new JSON Object and its attributes to the attribute array.
		 */
		JSONArray attributes = new JSONArray();
		JSONObject Username = new JSONObject();
		Username.put("name", "Username");
		Username.put("type", "string");
		Username.put("multiValued", false);
		Username.put("description", "Process generated Id for the User request");
		Username.put("required", true);
		Username.put("caseExact", false);
		Username.put("returned", "default");
		Username.put("mutability", "readOnly");
		Username.put("uniqueness", "server");
		attributes.add(Username);
		JSONObject EmployeeId = new JSONObject();
		EmployeeId.put("name", "EmployeeId");
		EmployeeId.put("type", "string");
		EmployeeId.put("multiValued", false);
		EmployeeId.put("description", "Process generated Id for the User request");
		EmployeeId.put("required", true);
		EmployeeId.put("caseExact", false);
		EmployeeId.put("returned", "default");
		EmployeeId.put("mutability", "readOnly");
		EmployeeId.put("uniqueness", "server");
		attributes.add(EmployeeId);
		JSONObject EmployeeStatus = new JSONObject();
		EmployeeStatus.put("name", "EmployeeStatus");
		EmployeeStatus.put("type", "string");
		EmployeeStatus.put("multiValued", false);
		EmployeeStatus.put("description", "Process generated Id for the User request");
		EmployeeStatus.put("required", true);
		EmployeeStatus.put("caseExact", false);
		EmployeeStatus.put("returned", "default");
		EmployeeStatus.put("mutability", "readOnly");
		EmployeeStatus.put("uniqueness", "server");
		attributes.add(EmployeeStatus);
		JSONObject EmployeeDisplayName = new JSONObject();
		EmployeeDisplayName.put("name", "EmployeeDisplayName");
		EmployeeDisplayName.put("type", "string");
		EmployeeDisplayName.put("multiValued", false);
		EmployeeDisplayName.put("description", "Process generated Id for the User request");
		EmployeeDisplayName.put("required", true);
		EmployeeDisplayName.put("caseExact", false);
		EmployeeDisplayName.put("returned", "default");
		EmployeeDisplayName.put("mutability", "readOnly");
		EmployeeDisplayName.put("uniqueness", "server");
		attributes.add(EmployeeDisplayName);
		JSONObject EmployeeFirstName = new JSONObject();
		EmployeeFirstName.put("name", "EmployeeFirstName");
		EmployeeFirstName.put("type", "string");
		EmployeeFirstName.put("multiValued", false);
		EmployeeFirstName.put("description", "Process generated Id for the User request");
		EmployeeFirstName.put("required", true);
		EmployeeFirstName.put("caseExact", false);
		EmployeeFirstName.put("returned", "default");
		EmployeeFirstName.put("mutability", "readOnly");
		EmployeeFirstName.put("uniqueness", "server");
		attributes.add(EmployeeFirstName);
		JSONObject EmployeeLastName = new JSONObject();
		EmployeeLastName.put("name", "EmployeeLastName");
		EmployeeLastName.put("type", "string");
		EmployeeLastName.put("multiValued", false);
		EmployeeLastName.put("description", "Process generated Id for the User request");
		EmployeeLastName.put("required", true);
		EmployeeLastName.put("caseExact", false);
		EmployeeLastName.put("returned", "default");
		EmployeeLastName.put("mutability", "readOnly");
		EmployeeLastName.put("uniqueness", "server");
		attributes.add(EmployeeLastName);
		JSONObject EmployeeEmail = new JSONObject();
		EmployeeEmail.put("name", "EmployeeEmail");
		EmployeeEmail.put("type", "string");
		EmployeeEmail.put("multiValued", false);
		EmployeeEmail.put("description", "Process generated Id for the User request");
		EmployeeEmail.put("required", true);
		EmployeeEmail.put("caseExact", false);
		EmployeeEmail.put("returned", "default");
		EmployeeEmail.put("mutability", "readOnly");
		EmployeeEmail.put("uniqueness", "server");
		attributes.add(EmployeeEmail);
		JSONObject EmployeePhoneNumber = new JSONObject();
		EmployeePhoneNumber.put("name", "EmployeePhoneNumber");
		EmployeePhoneNumber.put("type", "string");
		EmployeePhoneNumber.put("multiValued", false);
		EmployeePhoneNumber.put("description", "Process generated Id for the User request");
		EmployeePhoneNumber.put("required", true);
		EmployeePhoneNumber.put("caseExact", false);
		EmployeePhoneNumber.put("returned", "default");
		EmployeePhoneNumber.put("mutability", "readOnly");
		EmployeePhoneNumber.put("uniqueness", "server");
		attributes.add(EmployeePhoneNumber);
		JSONObject EmployeeAddress = new JSONObject();
		EmployeeAddress.put("name", "EmployeeAddress");
		EmployeeAddress.put("type", "string");
		EmployeeAddress.put("multiValued", false);
		EmployeeAddress.put("description", "Process generated Id for the User request");
		EmployeeAddress.put("required", true);
		EmployeeAddress.put("caseExact", false);
		EmployeeAddress.put("returned", "default");
		EmployeeAddress.put("mutability", "readOnly");
		EmployeeAddress.put("uniqueness", "server");
		attributes.add(EmployeeAddress);
		JSONObject EmployeeCountry = new JSONObject();
		EmployeeCountry.put("name", "EmployeeCountry");
		EmployeeCountry.put("type", "string");
		EmployeeCountry.put("multiValued", false);
		EmployeeCountry.put("description", "Process generated Id for the User request");
		EmployeeCountry.put("required", true);
		EmployeeCountry.put("caseExact", false);
		EmployeeCountry.put("returned", "default");
		EmployeeCountry.put("mutability", "readOnly");
		EmployeeCountry.put("uniqueness", "server");
		attributes.add(EmployeeCountry);
		JSONObject EmployeeState = new JSONObject();
		EmployeeState.put("name", "EmployeeState");
		EmployeeState.put("type", "string");
		EmployeeState.put("multiValued", false);
		EmployeeState.put("description", "Process generated Id for the User request");
		EmployeeState.put("required", true);
		EmployeeState.put("caseExact", false);
		EmployeeState.put("returned", "default");
		EmployeeState.put("mutability", "readOnly");
		EmployeeState.put("uniqueness", "server");
		attributes.add(EmployeeState);
		JSONObject EmployeeCity = new JSONObject();
		EmployeeCity.put("name", "EmployeeCity");
		EmployeeCity.put("type", "string");
		EmployeeCity.put("multiValued", false);
		EmployeeCity.put("description", "Process generated Id for the User request");
		EmployeeCity.put("required", true);
		EmployeeCity.put("caseExact", false);
		EmployeeCity.put("returned", "default");
		EmployeeCity.put("mutability", "readOnly");
		EmployeeCity.put("uniqueness", "server");
		attributes.add(EmployeeCity);
		JSONObject EmployeeZipCode = new JSONObject();
		EmployeeZipCode.put("name", "EmployeeZipCode");
		EmployeeZipCode.put("type", "string");
		EmployeeZipCode.put("multiValued", false);
		EmployeeZipCode.put("description", "Process generated Id for the User request");
		EmployeeZipCode.put("required", true);
		EmployeeZipCode.put("caseExact", false);
		EmployeeZipCode.put("returned", "default");
		EmployeeZipCode.put("mutability", "readOnly");
		EmployeeZipCode.put("uniqueness", "server");
		attributes.add(EmployeeZipCode);
		// -----------> Attribute JSON Array values End<---------------//
		schemaObject.put("totalResults", 1);
		JSONArray schemaArray = new JSONArray();
		schemaArray.add("urn:ietf:params:scim:api:messages:2.0:ListResponse");
		schemaObject.put("schemas", schemaArray);
		JSONObject resourceObject = new JSONObject();
		JSONObject resourceMeta = new JSONObject();
		resourceMeta.put("resourceType", "Schema");
		resourceMeta.put("location", "https://scim-test.passplay.us.nike-cloud.com/scim/v1/schemas");
		resourceObject.put("id", "urn:ietf:params:scim:schemas:core:2.0:User");
		resourceObject.put("name", "User");
		resourceObject.put("description", "User Account");
		resourceObject.put("meta", resourceMeta);
		resourceObject.put("attributes", attributes);
		JSONArray resourceArray = new JSONArray();
		resourceArray.add(resourceObject);
		schemaObject.put("Resources", resourceArray);
		return schemaObject;
	}
}
