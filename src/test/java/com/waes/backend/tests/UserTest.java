package com.waes.backend.tests;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;

import com.waes.backend.model.User;
import com.waes.backend.model.UserBuilder;
import com.waes.backend.utils.Services;

public class UserTest extends Services{

	String url = "http://localhost:8081/waesheroes/api/v1/users/details?username=dev";
  
	@ParameterizedTest
	@CsvSource({
		"get, name, Zuper Dooper Dev",
		"get, dateOfBirth, 1999-10-10",
		"get, email, zd.dev@wearewaes.com",
		"get, isAdmin, false",
		"get, superpower, Debug a repellent factory storage.",
		})
	void testVerifyYserData(String type, String fieldName, String data) throws Exception {	
		
		String response = httpRequestResponse(type, url);
		String fieldData = getResponseData(response, fieldName);
		assertThat(data.equals(fieldData));
		
	}



}
