package ws.synopsis.training.exception;

public class TrainingException extends Exception{
    public TrainingException() {
    }

    public TrainingException(String message) {
        super(message);
    }

    public TrainingException(String message, Throwable cause) {
        super(message, cause);
    }

    public TrainingException(Throwable cause) {
        super(cause);
    }
}
