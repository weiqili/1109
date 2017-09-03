package exception.exceptions;

/**
 * for testing
 * 无关紧要的异常
 * 不配置紧急程度，将执行默认异常处理
 */
public class InessentialException extends SystemException {
    public InessentialException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "InessentialException, message: " + getMessage();
    }
}
