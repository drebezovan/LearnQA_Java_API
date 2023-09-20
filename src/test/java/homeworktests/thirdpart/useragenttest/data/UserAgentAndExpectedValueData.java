package homeworktests.thirdpart.useragenttest.data;

import lombok.Data;

import java.util.List;
@Data
public class UserAgentAndExpectedValueData {

    private List<String> userAgent;

    private List<ParametersData> expectedValues;
}
