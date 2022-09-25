package exсeption;

public class WrongLoginException extends Exception {
    public WrongLoginException() {
        super("Не правильный логин или пароль");
    }
}
