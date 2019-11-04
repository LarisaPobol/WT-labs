package Servises;

public class ServiseException extends Exception {
    public ServiseException() {
    }

    public ServiseException(String message) {
        super(message);
    }

    public ServiseException(Exception ex) {
        super(ex);
    }

    public ServiseException(String message, Exception ex) {
        super(message, ex);
    }
}
