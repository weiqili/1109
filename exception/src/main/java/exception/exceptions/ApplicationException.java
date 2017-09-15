package exception.exceptions;

@ExceptionLevel1
public class ApplicationException extends SystemException {
    public ApplicationException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "ApplicationException, message: " + getMessage();
    }
}
