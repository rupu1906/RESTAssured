package tests;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;
import org.testng.annotations.Test;

public class TestRestAssured {
	int id;
	@Test(priority=1)
	void getUsers() {
		given()
		.when()
		.get("https://reqres.in/api/users?page=2")
		.then()
		.statusCode(200)
		.body("page",equalTo(2))
		.log().all();
		
	}
	@Test(priority=2)
	void createUsers() {
		
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("name", "Sam");
		data.put("job","leader");
		
		id =given()
		.contentType("application/json")
		.body(data)
		.when()
		.post("https://reqres.in/api/users")
		.jsonPath().getInt("id");

	}
	
	@Test(priority=3, dependsOnMethods="createUsers")
	void getSingleUser() {
		
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("name", "Rupali");
		data.put("job","leader");
		
		given()
		.contentType("application/json")
		.body(data)
		.when()
		.put("https://reqres.in/api/users/2")
		.then()
		.statusCode(200)
		.body("name", equalTo("Rupali"))
		.log().all();

		
	}
	
}
