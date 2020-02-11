package springRestExp.rest;


import io.restassured.http.ContentType;
import io.restassured.response.Response;
import lombok.val;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import springRestExp.rest.data.Channel;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.hasItems;

@SpringBootTest
@RunWith(SpringRunner.class)
class RestApplicationTests {

	private String baseuri = "http://localhost:8080";
	@Test
	void contextLoads() {
	}


	@Test
	public void testChannels() {
		get(baseuri + "/channels").then()
				.assertThat()
				.statusCode(HttpStatus.OK.value())
				.body("_embedded.channels.name", hasItems("sms"));


	}

	@Test
	public void testChannelsPost() {
		String json = "{\"name\": \"email\"}";
		given().
						contentType(ContentType.JSON).
						accept(ContentType.JSON).
						body(json).
		when().
						post(baseuri + "/channels").
		then().
						assertThat().
						statusCode(HttpStatus.CREATED.value());


	}
	


}
