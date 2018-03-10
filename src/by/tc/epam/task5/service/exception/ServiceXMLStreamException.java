package by.tc.epam.task5.service.exception;

public class ServiceXMLStreamException extends Exception {

    public ServiceXMLStreamException() {
    }

    public ServiceXMLStreamException(String s) {
        super(s);
    }

    public ServiceXMLStreamException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public ServiceXMLStreamException(Throwable throwable) {
        super(throwable);
    }
}
