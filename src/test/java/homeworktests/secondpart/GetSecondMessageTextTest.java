package homeworktests.secondpart;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class GetSecondMessageTextTest {

    @Test
    public void testGetSecondMessageText(){
        Response response = RestAssured
                .get("https://playground.learnqa.ru/api/get_json_homework")
                .andReturn();

        String secondMessageText = response
                .jsonPath()
                .getList("messages")
                .get(1)
                .toString()
                .replaceAll("[\\{\\}]", "");

        System.out.println(secondMessageText);
    }
}
