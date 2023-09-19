package homeworktests.thirdpart;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckHeaderTest {

    @Test
    public void checkHeaders(){

        Response response = RestAssured
                .get("https://playground.learnqa.ru/api/homework_header")
                .andReturn();

        Headers headers = response.getHeaders();

        assertTrue(headers.hasHeaderWithName("x-secret-homework-header"),
                "Не существует header 'x-secret-homework-header'");
        assertTrue(headers.getValue("x-secret-homework-header").contains("Some secret value"),
                "Не существует header со значением 'Some secret value'");

    }
}
