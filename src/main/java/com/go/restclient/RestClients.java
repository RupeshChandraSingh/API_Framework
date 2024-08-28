package com.go.restclient;

import java.util.Map;
import java.util.Properties;

import com.go.utils.FrameworkException;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestClients {

	private RequestSpecBuilder specBuilder;
	private Properties prop;
	private String baseURI;
	private boolean isAuthAdded = false;

	public RestClients(Properties prop, String baseURI) {
		specBuilder = new RequestSpecBuilder();
		this.baseURI = baseURI;
		this.prop = prop;
	}

	public void addAuthorization() {
		if (!isAuthAdded) {
			specBuilder.addHeader("Authorization", "Bearer " + prop.getProperty("tokenID"));
			isAuthAdded = true;
		}
	}

	private void setContentType(String contentType) {

		switch (contentType.toLowerCase().trim()) {
		case "json":
			specBuilder.setContentType(ContentType.JSON);
			break;
		case "xml":
			specBuilder.setContentType(ContentType.XML);
			break;
		case "text":
			specBuilder.setContentType(ContentType.TEXT);
			break;

		default:
			System.out.println("Please provide valid content type");

			throw new FrameworkException("InvalidContentTypeException");
		}

	}

	private RequestSpecification createSpec() {
		specBuilder.setBaseUri(baseURI);
		addAuthorization();
		return specBuilder.build();
	}
	
	private RequestSpecification createSpec(Map<String, String> headers) {
		specBuilder.setBaseUri(baseURI);
		addAuthorization();
		specBuilder.addHeaders(headers);
		return specBuilder.build();
	}
	
	private RequestSpecification createSpec(Map<String, String> headers, Map<String, Object> queryParam) {
		specBuilder.setBaseUri(baseURI);
		addAuthorization();
		specBuilder.addHeaders(headers);
		specBuilder.addQueryParams(queryParam);
		return specBuilder.build();
	}
	private RequestSpecification createSpec(Object requestBody, String contentType) {
		specBuilder.setBaseUri(baseURI);
		addAuthorization();
		setContentType(contentType);
		if(requestBody != null) {
			specBuilder.setBody(requestBody);
		}
		return specBuilder.build();
	}
	
	private RequestSpecification createSpec(Object requestBody, String contentType, Map<String, String> headers ) {
		specBuilder.setBaseUri(baseURI);
		addAuthorization();
		specBuilder.addHeaders(headers);
		setContentType(contentType);
		if(requestBody != null) {
			specBuilder.setBody(requestBody);
		}
		return specBuilder.build();
	}
	
	
	public Response get(String serviceUrl, boolean log) {
		if(log) {
		return	RestAssured
				.given(createSpec()).log().all()
					.when().log().all()
						.get(serviceUrl);
		}
		
		return RestAssured
		.given(createSpec()).log().all()
			.when().log().all()
				.get(serviceUrl);
		
	}
	
	public Response get(String serviceUrl,Map<String, String> headers, Map<String, Object> queryParam, boolean log) {
		if(log) {
		return	RestAssured
				.given(createSpec(headers,queryParam)).log().all()
					.when().log().all()
						.get(serviceUrl);
		}
		
		return RestAssured
		.given(createSpec(headers, queryParam)).log().all()
			.when().log().all()
				.get(serviceUrl);
		
	}
	
	public Response get(String serviceUrl, Map<String, String> headers, boolean log) {
		if(log) {
		return	RestAssured
				.given(createSpec(headers)).log().all()
					.when().log().all()
						.get(serviceUrl);
		}
		
		return RestAssured
		.given(createSpec(headers)).log().all()
			.when().log().all()
				.get(serviceUrl);
		
	}
	
	
	public Response post(String serviceUrl,Object requestBody, String contentType , boolean log) {
		if(log) {
		return	RestAssured
				.given(createSpec(requestBody, contentType)).log().all()
					.when().log().all()
						.post(serviceUrl);
		}
		
		return RestAssured
		.given(createSpec(requestBody, contentType)).log().all()
			.when().log().all()
				.post(serviceUrl);
		
	}
	
	
	public Response post(String serviceUrl,Object requestBody, String contentType, Map<String, String> headers, boolean log) {
		if(log) {
		return	RestAssured
				.given(createSpec(requestBody, contentType, headers)).log().all()
					.when().log().all()
						.post(serviceUrl);
		}
		
		return RestAssured
		.given(createSpec(requestBody, contentType, headers)).log().all()
			.when().log().all()
				.post(serviceUrl);
	}
	
	public Response put(String serviceUrl,Object requestBody, String contentType , boolean log) {
		if(log) {
		return	RestAssured
				.given(createSpec(requestBody, contentType)).log().all()
					.when().log().all()
						.put(serviceUrl);
		}
		
		return RestAssured
		.given(createSpec(requestBody, contentType)).log().all()
			.when().log().all()
				.put(serviceUrl);
		
	}
	
	
	public Response put(String serviceUrl,Object requestBody, String contentType, Map<String, String> headers, boolean log) {
		if(log) {
		return	RestAssured
				.given(createSpec(requestBody, contentType, headers)).log().all()
					.when().log().all()
						.put(serviceUrl);
		}
		
		return RestAssured
		.given(createSpec(requestBody, contentType, headers)).log().all()
			.when().log().all()
				.put(serviceUrl);
	}
	
	
	public Response delete(String serviceUrl, boolean log) {
		if(log) {
		return	RestAssured
				.given(createSpec()).log().all()
					.when().log().all()
						.delete(serviceUrl);
		}
		
		return RestAssured
		.given(createSpec()).log().all()
			.when().log().all()
				.delete(serviceUrl);
		
	}

}
