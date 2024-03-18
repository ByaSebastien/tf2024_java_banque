package be.bstorm.exceptions;

public class InsufficientBalanceException extends RuntimeException{

    public InsufficientBalanceException() {
        super("Solde insuffisant");
    }

    public InsufficientBalanceException(String message) {
        super(message);
    }
}
