package DSQueuestuff;

public class DSQueueException extends Exception {
    public DSQueueException() {
        super();
        }
        public DSQueueException(String message) {
        super(message);
        }
        public DSQueueException(String message, Throwable cause) {
        super(message, cause);    
        }
        public DSQueueException(Throwable cause) {
        super(cause);
        }
        protected DSQueueException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        }
}
