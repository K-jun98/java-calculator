package calulator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OperationTest {

    @DisplayName("연산자를 찾아서 피연산자를 계산한다.")
    @ParameterizedTest
    @CsvSource({"+, 1, 2, 3", "-, 1, 2, -1", "*, 1, 2, 2", "/, 1, 2, 0"})
    void operatorSuccess(String operator, int operand1, int operand2, int expected) {
        assertThat(Operation.operator(operator.charAt(0), operand1, operand2)).isEqualTo(expected);
    }

    @DisplayName("+,-,*,/를 제외한 연산자는 예외를 던집니다.")
    @Test
    void operatorFail() {
        assertThatThrownBy(() -> Operation.operator('=', 2, 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사용할 수 없는 연산자입니다.");
    }

}