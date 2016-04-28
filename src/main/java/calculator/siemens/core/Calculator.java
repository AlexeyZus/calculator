package calculator.siemens.core;

/**
 *
 *  main and single entry point into core module
 */
public interface Calculator {

    /**
     * calculate input expression
     * @param expression - serialized view of arithmetic expression
     * @return result of expression if it is correct or error message in the following cases:
     *              - "Input expression is not defined" if specified expression is empty;
     *              - "invalid expression" if specified expression is invalid (invalid order of elements,
     *                 unexpected or/unknown elements);
     *              - "Invalid expression: EXPRESSION (unexpected chars)" if specified expression contains unexpected char
     *              - error message from some operation if its operands are not supported
     *              - "wrong sequence of elements" - if elements valid but sequence is wrong
     *
     * @throws NullPointerException if specified expression is Null
     *
     *
     */
     CalculatorResult calculate(String expression);
}
