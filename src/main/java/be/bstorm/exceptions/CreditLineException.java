package be.bstorm.exceptions;

public class CreditLineException extends Exception{
    public CreditLineException() {
        super("Credit line sould be positive");
    }

    public CreditLineException(String message) {
        super(message);
    }
}
