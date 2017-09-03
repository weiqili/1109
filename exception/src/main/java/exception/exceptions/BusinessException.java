package exception.exceptions;

/**
 * 业务级异常
 */
@ExceptionLevel2
public class BusinessException extends BaseException {
    public BusinessException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "BusinessException, message: " + getMessage();
    }
}
