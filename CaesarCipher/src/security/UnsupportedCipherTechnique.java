package security;

/**
 * Created by sameen on 24/09/2016.
 */
public class UnsupportedCipherTechnique extends Exception {
    public UnsupportedCipherTechnique() {
    }

    public UnsupportedCipherTechnique(String message) {
        super(message);
    }

    public UnsupportedCipherTechnique(String message, Throwable cause) {
        super(message, cause);
    }

    public UnsupportedCipherTechnique(Throwable cause) {
        super(cause);
    }

    public UnsupportedCipherTechnique(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
