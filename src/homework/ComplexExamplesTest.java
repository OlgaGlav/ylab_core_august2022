package homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ComplexExamplesTest {

    private final static String FIRST = "qwerty";

    @Test
    void testFuzzySearch_IfNull() {
        String second = null;

        Assertions.assertFalse(ComplexExamples.fuzzySearch(FIRST, second));
    }

    @Test
    void testFuzzySearch_LenghtFirstIsMoreThanSecond() {
        String second = "qwe";
        Assertions.assertFalse(ComplexExamples.fuzzySearch(FIRST, second));
    }

    @Test
    void testFuzzySearch_NotContains() {
        String second = "qweqweqwerry";
        Assertions.assertFalse(ComplexExamples.fuzzySearch(FIRST, second));
    }

    @Test
    void testFuzzySearch_Correct() {
        String second = "qweqwertyrty";
        assertTrue(ComplexExamples.fuzzySearch(FIRST, second));
    }
}