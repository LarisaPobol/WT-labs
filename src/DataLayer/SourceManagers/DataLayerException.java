package dataLayer.sourceManagers;

/**
 * data layer exception
 */
public class DataLayerException extends Exception {
   // private static final long serialVersionUID = 1L;

    public DataLayerException() {
        super();
    }

    public DataLayerException(String message) {
        super(message);
    }

    public DataLayerException(Exception ex) {
        super(ex);
    }

    public DataLayerException(String message,Exception ex) {
        super(message, ex);
    }
}
