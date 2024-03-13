package be.bstorm.models;

public class CurrentAccount extends Account {
    private double creditLine;

    public CurrentAccount(String number, Person owner) {
        super( number, owner );
//        this( number, owner, 0);
    }
    public CurrentAccount(String number, Person owner, double balance) {
        super( number, balance, owner );
//        this(number, owner, balance, 0);
    }
    public CurrentAccount(String number, Person owner, double balance, double creditLine) {
        super( number, balance, owner );
        this.setCreditLine(creditLine);
    }

    public double getCreditLine() {
        return creditLine;
    }
    public void setCreditLine(double creditLine) {
        if( creditLine >= 0 ) {
            this.creditLine = creditLine;
        }
    }

    @Override
    public void withdraw(double amount) {
        if( this.getBalance() + this.getCreditLine() >= amount ){
            super.withdraw(amount);
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
