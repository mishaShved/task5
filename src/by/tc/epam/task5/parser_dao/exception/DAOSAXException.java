package by.tc.epam.task5.parser_dao.exception;

public class DAOSAXException extends Exception {

    public DAOSAXException() {
    }

    public DAOSAXException(String s) {
        super(s);
    }

    public DAOSAXException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public DAOSAXException(Throwable throwable) {
        super(throwable);
    }
}
