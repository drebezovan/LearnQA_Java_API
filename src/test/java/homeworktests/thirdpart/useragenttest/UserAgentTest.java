package homeworktests.thirdpart.useragenttest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import homeworktests.thirdpart.useragenttest.data.ParametersData;
import homeworktests.thirdpart.useragenttest.data.UserAgentAndExpectedValueData;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserAgentTest {

    UserAgentAndExpectedValueData userAgentAndExpectedValueData;
    ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
    File ymlFile = new File("src/test/java/homeworktests/thirdpart/useragenttest/yml/userAgentData.yml");

    @ParameterizedTest
    @ValueSource( ints = {0, 1, 2, 3, 4})
    public void checkLengthOfVariable(int index) throws IOException {

        userAgentAndExpectedValueData = mapper.readValue(ymlFile, UserAgentAndExpectedValueData.class);
        List<ParametersData> expectedValues = mapper.readValue(ymlFile, UserAgentAndExpectedValueData.class).getExpectedValues();

        Response response = RestAssured
                .given()
                .header("User-Agent", userAgentAndExpectedValueData.getUserAgent().get(index))
                .get("https://playground.learnqa.ru/ajax/api/user_agent_check")
                .andReturn();

        assertAll(
                () -> assertEquals(expectedValues.get(index).getUser_agent(), response.jsonPath().get("user_agent")),
                () -> assertEquals(expectedValues.get(index).getPlatform(), response.jsonPath().get("platform")),
                () -> assertEquals(expectedValues.get(index).getBrowser(), response.jsonPath().get("browser")),
                () -> assertEquals(expectedValues.get(index).getDevice(), response.jsonPath().get("device"))
        );
    }
}
