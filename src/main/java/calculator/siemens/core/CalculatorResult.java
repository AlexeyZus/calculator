package calculator.siemens.core;

/**
 *This class is contain:
 *  private boolean success - it's said is CalculatorResult have a good result without error.
 *  private double value - value of expression result after all operations
 *  private String error - when have a success "error"="", in case have fail "error" contain explanation error what is wrong.
 *
 */
public class CalculatorResult {

    private boolean success;

    private double value;

    private String error;

    public CalculatorResult(double value) {
        this.value = value;
        setSuccess(true);
    }

    public CalculatorResult(String error) {
        this.error = error;
        setSuccess(false);
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

}
