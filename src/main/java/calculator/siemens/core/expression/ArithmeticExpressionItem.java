package calculator.siemens.core.expression;

import calculator.siemens.core.CalculatorResult;

/**
 *
 * It's interface for Operands and Operation
 * if subclass is Operand, method isOperand return true, and method is Operation return false
 * if subclass is Operation, method isOperation return true, and method is isOperand return false
 */
public interface ArithmeticExpressionItem {


    final static int prioritet = 0;

    boolean isOperand();
    boolean isOperation();
    int getPriority();



}
