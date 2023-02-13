package tests;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class CreateRequestBody {
		@Test(priority=1)
		void createUsersUsignHashMap() {
			
			HashMap<String, String> data = new HashMap<String, String>();
			data.put("name", "Minal");
			data.put("job","leader");
			
			given()
			.contentType("application/json")
			.body(data)
			.when()
			.post("https://reqres.in/api/users")
			.then()
			.statusCode(201)
			.body("name", equalTo("Minal"))
			.body("job", equalTo("leader"))
			.header("Content-Type","application/json; charset=utf-8")
			.log().all();

		}
		
		@Test(priority=2)
		void createUsersOrgJson() {
			JSONObject data = new JSONObject();
			data.put("name", "Jason");
			data.put("job","Manager");
			
			given()
			.contentType("application/json")
			.body(data.toString())
			.when()
			.post("https://reqres.in/api/users")
			.then()
			.statusCode(201)
			.body("name",equalTo("Jason"))
			.body("job", equalTo("Manager"))
			.header("Content-Type", "application/json; charset=utf-8")
			.log().all();

		}
		
		@Test(priority=2)
		void createUsersUsingPOJOClass() {
			
			POJOClass data = new POJOClass();
			data.setName("Prajakta");
			data.setJob("Engineer");
			
			given()
			.contentType("application/json")
			.body(data)
			.when()
			.post("https://reqres.in/api/users")
			.then()
			.statusCode(201)
			.body("name",equalTo("Prajakta"))
			.body("job", equalTo("Engineer"))
			.header("Content-Type", "application/json; charset=utf-8")
			.log().all();

		}
		
		
		
		
}
