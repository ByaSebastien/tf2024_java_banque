package be.bstorm.exceptions;

public class NegativeAmountException extends RuntimeException{
    public NegativeAmountException() {
        super("Amount should be positive");
    }

    public NegativeAmountException(String message) {
        super(message);
    }
}
