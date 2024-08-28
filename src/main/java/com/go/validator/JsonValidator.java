package com.go.validator;

import java.util.List;
import java.util.Map;

import com.jayway.jsonpath.JsonPath;

import io.restassured.response.Response;

public class JsonValidator {

	public String getJsonResponse(Response response) {
		return response.getBody().asString();
	}

	public <T> T read(Response response, String jsnoPath) {
		String jsonResponse = getJsonResponse(response);
		return JsonPath.read(jsonResponse, jsnoPath);
	}
	
	public <T> List<T> readList(Response response, String jsnoPath) {
		String jsonResponse = getJsonResponse(response);
		return JsonPath.read(jsonResponse, jsnoPath);
	}
	
	
	public <T> List<Map<String, T>> readMap(Response response, String jsnoPath) {
		String jsonResponse = getJsonResponse(response);
		return JsonPath.read(jsonResponse, jsnoPath);
	}

}
