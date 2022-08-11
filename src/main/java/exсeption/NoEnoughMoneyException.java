package exсeption;

public class NoEnoughMoneyException extends Exception {
    public NoEnoughMoneyException() {
        super("Не достаточно средств");
    }

}
