package homeworktests.thirdpart;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasLength;

public class CheckTheLengthOfVariableTest {

    @ParameterizedTest
    @ValueSource(strings = {"", "Natasha", "test"})
    public void checkLengthOfVariable(String parameter){

        assertThat(parameter, hasLength(parameter.length()));
    }

}
