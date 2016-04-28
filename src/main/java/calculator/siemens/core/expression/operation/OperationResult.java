package calculator.siemens.core.expression.operation;

import calculator.siemens.core.expression.Operand;

/**
 *
 */
public class OperationResult {

    private boolean success;

    private Operand result;

    private String error;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Operand getResult() {
        return result;
    }

    public void setResult(Operand result) {
        this.result = result;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

}
