class GuessingTreeException extends Exception {
    public GuessingTreeException() {
        super();
        }
        public GuessingTreeException(String message) {
        super(message);
        }
        public GuessingTreeException(String message, Throwable cause) {
        super(message, cause);    
        }
        public GuessingTreeException(Throwable cause) {
        super(cause);
        }
        protected GuessingTreeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        }
}
