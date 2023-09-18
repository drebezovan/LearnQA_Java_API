import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class GetRedirectUntilCodeOkTest {

    @Test
    public void testGetRedirectUntilCodeOk(){

        String responseHeader = "playground.learnqa.ru";
        int responseStatusCode = 200;

        while (responseStatusCode == 200){

            Response response = RestAssured
                    .get("https://" + responseHeader + "/api/long_redirect")
                    .andReturn();

            responseHeader = response.getHeader("X-Host");
            responseStatusCode = response.getStatusCode();

            System.out.print("Адрес сайта: " + responseHeader + " - ");
            System.out.println("Код ответа: " + responseStatusCode + "\n");
        }
    }
}
