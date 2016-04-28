package calculator.siemens.core.expression.operation;

import calculator.siemens.core.expression.ArithmeticExpressionItem;

/**
 * method getOperation return object class ArithmeticExpressionItem which matches by char "+ - / * √".
 *
 * if item == '+' return object class AddOperation
 * if item == '-' return object class SubOperaion
 * if item == '*' return object class MultOperation
 * if item == '/' return object class DivOperation
 * if item == '√' return object class SqrtOperation
 *
 */
public interface OperationFactory {

    Operation getOperation(char item);

}
