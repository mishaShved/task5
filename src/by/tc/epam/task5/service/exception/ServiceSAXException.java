package by.tc.epam.task5.service.exception;

public class ServiceSAXException extends Exception {

    public ServiceSAXException() {
    }

    public ServiceSAXException(String s) {
        super(s);
    }

    public ServiceSAXException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public ServiceSAXException(Throwable throwable) {
        super(throwable);
    }
}
