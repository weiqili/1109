package exception.exceptions;

/**
 * 系统级异常
 */
@ExceptionLevel1
public class SystemException extends BaseException {
    public SystemException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "SystemException, message: " + getMessage();
    }
}
