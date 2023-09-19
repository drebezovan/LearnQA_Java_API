package homeworktests.thirdpart;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckCookieTest {

    @Test
    public void checkCookie(){

        Response response = RestAssured
                .get("https://playground.learnqa.ru/api/homework_cookie")
                .andReturn();

        Map<String, String> cookie = response.getCookies();

        assertTrue(cookie.containsKey("HomeWork"), "Не существует сookie с ключом 'HomeWork'");
        assertTrue(cookie.containsValue("hw_value"), "Не существует сookie со значением 'hw_value'");

    }
}
