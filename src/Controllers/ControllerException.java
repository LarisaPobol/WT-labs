package controllers;

/**
 * controller exception
 */
public class ControllerException extends Exception {
    public ControllerException() {
    }

    public ControllerException (String message) {
        super(message);
    }

    public ControllerException(Exception ex) {
        super(ex);
    }

    public ControllerException(String message, Exception ex) {
        super(message, ex);
    }
}
