package exceptions;

public class WrongResponseMessageException extends RuntimeException {

    public WrongResponseMessageException(String message) {
        super(message);
    }

    public WrongResponseMessageException(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongResponseMessageException(Throwable cause) {
        super(cause);
    }
}
