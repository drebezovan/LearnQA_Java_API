import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class GetRedirectAddressTest {

    @Test
    public void findAllHeaders(){

        Response response = RestAssured
                .get("https://playground.learnqa.ru/api/long_redirect")
                .andReturn();

        Headers responseHeaders = response.getHeaders();

        System.out.println(responseHeaders);
    }

    @Test
    public void testGetRedirectAddress(){

        Response response = RestAssured
                .get("https://playground.learnqa.ru/api/long_redirect")
                .andReturn();

        String responseHeader = response.getHeader("X-Host");

        System.out.println(responseHeader);
    }
}
