public class DSListException extends Exception{
    public DSListException() {
    super();
    }
    public DSListException(String message) {
    super(message);
    }
    public DSListException(String message, Throwable cause) {
    super(message, cause);    
    }
    public DSListException(Throwable cause) {
    super(cause);
    }
    protected DSListException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
    }
}