package calculator.siemens.core.expression;

import calculator.siemens.core.CalculatorResult;

import java.util.List;

/**
 *
 *
 *
 * interface ArithmeticExpression contain:
 *  method deserialize - parsing expression to operands(Operand) and operations(Operation).
 *  method getItems - if call befor deserialize return List<>, and return list of elements (Operand and Operation)
 *  method calculate - return object of class CalculatorResult, which contain: result(double), error if expression is fail, status of operation success or fail.
 */


public interface ArithmeticExpression{

    String deserialize(String expression); //необходимо продумывать либо возвращ. знач, либо выбрасывать exception

    /**
     * Get items of the expression, which contains Operands, Operations and Brackets.
     * @return List of AE items if the expression is already deserialized, otherwise <code>null</code>
     */
    List<ArithmeticExpressionItem> getItems();

    CalculatorResult calculate();
}
