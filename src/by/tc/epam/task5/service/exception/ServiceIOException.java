package by.tc.epam.task5.service.exception;

public class ServiceIOException extends Exception {

    public ServiceIOException() {
    }

    public ServiceIOException(String s) {
        super(s);
    }

    public ServiceIOException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public ServiceIOException(Throwable throwable) {
        super(throwable);
    }
}
