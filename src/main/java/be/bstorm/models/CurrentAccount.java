package be.bstorm.models;

import be.bstorm.exceptions.CreditLineException;
import be.bstorm.exceptions.InsufficientBalanceException;
import be.bstorm.exceptions.NegativeAmountException;

public class CurrentAccount extends Account {
    private double creditLine;

    public CurrentAccount(String number, Person owner) {
        super(number, owner);
//        this( number, owner, 0);
    }

    public CurrentAccount(String number, Person owner, double balance) {
        super(number, balance, owner);
//        this(number, owner, balance, 0);
    }

    public CurrentAccount(String number, Person owner, double balance, double creditLine) {
        super(number, balance, owner);
        try {
            this.setCreditLine(creditLine);
        } catch (CreditLineException e) {
            System.out.println(e.getMessage());
            try {
                setCreditLine(-creditLine);
            } catch (CreditLineException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public double getCreditLine() {
        return creditLine;
    }

    public void setCreditLine(double creditLine) throws CreditLineException {
        if (creditLine < 0) {
            throw new CreditLineException("Credit line should be positive.");
        }
        this.creditLine = creditLine;
    }

    @Override
    public void withdraw(double amount) {
        if (this.getBalance() + this.getCreditLine() < amount) {
            throw new InsufficientBalanceException();
        }
        double previousBalance = getBalance();
        super.withdraw(amount);
        if (previousBalance >= 0 && getBalance() < 0) {
            raisePassageEnNegatifEvent();
        }
    }

    @Override
    protected double calculateInterest() {
        return this.getBalance() >= 0 ? 3 : 9.75;
//        if( this.getBalance() >= 0 ) {
//            return 3;
//        }
//        else {
//            return 9.75;
//        }
    }
}
