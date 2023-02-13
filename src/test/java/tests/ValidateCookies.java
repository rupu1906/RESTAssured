package tests;
import static io.restassured.RestAssured.*;
//import static org.hamcrest.Matchers.*;
//import java.util.Iterator;
import java.util.Map;
import org.testng.annotations.Test;
import io.restassured.response.Response;


public class ValidateCookies {
	@Test(priority=1)
	void createUsersUsignHashMap() {
		Response res =
				given()
				.when()
				.get("https://www.google.com");
		
		Map<String, String> hm=res.getCookies();
		
		System.out.println(hm.keySet());
		for( String c:hm.keySet()) {
			System.out.println(c +" -- "+ hm.get(c));
		}
		
//		   Iterator hmIterator = hm.entrySet().iterator();
	        // Iterating through Hashmap and
//	        while (hmIterator.hasNext()) {
//	 
//	            Map.Entry mapElement
//	                = (Map.Entry)hmIterator.next();
//	            System.out.println(mapElement.getKey() + " : "+mapElement.getValue());
//	        }
//		
		
	}
}
