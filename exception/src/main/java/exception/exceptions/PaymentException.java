package exception.exceptions;

/**
 * 交易异常
 */
public class PaymentException extends BusinessException {
    public PaymentException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "PaymentException, message: " + getMessage();
    }
}
