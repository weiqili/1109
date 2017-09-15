package exception.exceptions;

@ExceptionAnno
public abstract class BaseException extends Exception {
    public BaseException(String message) {
        super(message);
    }

    public abstract String toString();
}
