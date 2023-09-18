import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class HelloFromNameTest {

    @Test
    public void testOutputsHelloFromName(){

        String response = RestAssured
                .given()
                .queryParam("name", "Наташа")
                .get("https://playground.learnqa.ru/api/hello")
                .jsonPath()
                .getJsonObject("answer")
                .toString()
                .replace(",", " from");

        System.out.println(response);
    }

    @Test
    public void testOutputsGetRequestResponse(){

        Response response = RestAssured
                .given()
                .get("https://playground.learnqa.ru/api/hello?name=Наташа")
                .andReturn();

        response.prettyPrint();
    }
}
