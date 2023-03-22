package ru.job4j.function;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class FunctionCalculatorTest {

    @Test
    public void whenLinearFunctionThenLinearResults() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result).containsAll(expected);
    }

    @Test
    public void whenLinearFunctionThenSquareResults() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> rsl = function.diapason(1, 4, x -> Math.pow(x, 2));
        List<Double> expected = Arrays.asList(1D, 4D, 9D);
        assertThat(rsl).containsAll(expected);
    }

    @Test
    public void whenLinearFunctionThenExponentialResults() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> rsl = function.diapason(2, 5, x -> Math.pow(3, x));
        List<Double> expected = Arrays.asList(9D, 27D, 81D);
        assertThat(rsl).containsAll(expected);
    }
}