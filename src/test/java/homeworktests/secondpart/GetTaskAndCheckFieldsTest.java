package homeworktests.secondpart;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

public class GetTaskAndCheckFieldsTest {

    @Test
    public void testGetTaskAndCheckFields() throws InterruptedException {

        Response response = getResponseToNewTask();

        String token = response.jsonPath().get("token").toString();
        int timeToCreateTask = response.jsonPath().get("seconds");

        Response responseWithUnreadyTask = getResponseToTask(token);

        String actualStatusWithUnreadyTask = responseWithUnreadyTask.jsonPath().get("status");

        Assertions.assertEquals("Job is NOT ready", actualStatusWithUnreadyTask);

        TimeUnit.SECONDS.sleep(timeToCreateTask);

        Response responseWithReadyTask = getResponseToTask(token);

        String actualStatusWithReadyTask = responseWithReadyTask.jsonPath().get("status");
        String actualResultWithReadyTask = responseWithReadyTask.jsonPath().get("result");

        Assertions.assertEquals("Job is ready", actualStatusWithReadyTask);
        Assertions.assertFalse(actualResultWithReadyTask.isEmpty());

    }

    private static Response getResponseToNewTask() {
        return RestAssured
                .get("https://playground.learnqa.ru/ajax/api/longtime_job")
                .andReturn();
    }

    private static Response getResponseToTask(String token) {
        return RestAssured
                .given()
                .queryParam("token", token)
                .get("https://playground.learnqa.ru/ajax/api/longtime_job")
                .andReturn();
    }
}
