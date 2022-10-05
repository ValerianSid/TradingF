package exсeption;

public class WrongLoginException extends RuntimeException {
    public WrongLoginException(String msg) {
        super(msg);
    }
    public WrongLoginException(String msg, Throwable couse){super(msg,couse);}
}
