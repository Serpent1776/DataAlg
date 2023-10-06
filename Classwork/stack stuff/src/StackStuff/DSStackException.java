package StackStuff;

public class DSStackException extends Exception {
    public DSStackException() {
    super();
    }
    public DSStackException(String message) {
    super(message);
    }
    public DSStackException(String message, Throwable cause) {
    super(message, cause);    
    }
    public DSStackException(Throwable cause) {
    super(cause);
    }
    protected DSStackException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
    }
}

