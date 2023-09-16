import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class GetTextRequestTest {

    @Test
    public void testOutputsGetTextRequestResponse(){

        Response response = RestAssured
                .get("https://playground.learnqa.ru/api/get_text")
                .andReturn();

        response.print();
    }
}
