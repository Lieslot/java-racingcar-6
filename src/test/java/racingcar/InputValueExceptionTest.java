package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.ForwardTryCount;
import racingcar.vo.CarName;

public class InputValueExceptionTest {

    @DisplayName("자동차 이름이 규정된 길이를 초과할 시 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "456789"})
    void carNameLengthExceedExceptionTest(String input) {

        Assertions.assertThatThrownBy(() -> new CarName(input))
                  .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("전진횟수의 입력이 자연수가 아닌 경우 예외처리")
    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "-2"})
    void nonPositiveNumbersTest(String input) {
        Assertions.assertThatThrownBy(() -> new ForwardTryCount(input))
                  .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("전진횟수의 입력이 숫자가 아닌 경우 예외처리")
    @ParameterizedTest
    @ValueSource(strings = {"wk2", "le2", "eeee"})
    void nonNumbersTest(String input) {
        Assertions.assertThatThrownBy(() -> new ForwardTryCount(input))
                  .isInstanceOf(IllegalArgumentException.class);
    }
}
