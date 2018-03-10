package by.tc.epam.task5.parser_dao.exception;

public class DAOIOException extends Exception {

    public DAOIOException() {
    }

    public DAOIOException(String s) {
        super(s);
    }

    public DAOIOException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public DAOIOException(Throwable throwable) {
        super(throwable);
    }
}
