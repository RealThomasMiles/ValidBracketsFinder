package com.dmitrymilya.util;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class ValidBracketsFinderTest {

    private static final Map<String, String> TEST_CASES = Map.of(
            "(()", "2 - ()",
            ")()())", "4 - ()()",
            ")(()())", "6 - (()())",
            ")(", "0",
            "())(()())(()", "10 - ()(()())()"
    );

    @Test
    public void shouldReturnZeroWhenInputIsNull() {
        assertThat(ValidBracketsFinder.findAllValidBrackets(null))
                .isEqualTo("0");
    }

    @Test
    public void shouldReturnZeroWhenInputIsEmpty() {
        assertThat(ValidBracketsFinder.findAllValidBrackets(""))
                .isEqualTo("0");
    }

    @Test
    public void shouldReturnValueForEveryKeyInTestCases() {
        TEST_CASES.forEach((input, output) ->
                assertThat(ValidBracketsFinder.findAllValidBrackets(input))
                        .isEqualTo(output));
    }

}
