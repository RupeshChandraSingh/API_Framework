package com.go.tests;

import org.codehaus.groovy.util.StringUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonpCharacterEscapes;
import com.go.base.BaseTest;
import com.go.pojo.CreateUser;
import com.go.utils.StringUtils;
import com.go.validator.JsonValidator;

import io.restassured.response.Response;

public class CreateUserTest extends BaseTest {

	@Test
	public void createUserTest() {

		CreateUser CreateUserResource = CreateUser.builder().name("Kangna").gender("Female")
				.email(StringUtils.getRandomEmail()).status("active").build();
		
		Response response = restClient.post(goRestServiceUrl, CreateUserResource, "json", true);
		response.prettyPrint();
		
		int statuscode = response.then().extract().statusCode();
		
		JsonValidator jp = new JsonValidator();
		
		int userID = jp.read(response, "$.id");
		System.out.println("===============>"+userID);
		
		Assert.assertEquals(statuscode, 201);
		Assert.assertNotNull(userID);
		
		
	}
}
