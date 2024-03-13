package be.bstorm.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SavingsAccount extends Account {

    private LocalDateTime lastWithdrawal;

    public SavingsAccount(String number, Person owner) {
        super(number, owner);
//        this(number, 0, owner);
    }

    public SavingsAccount(String number, double balance, Person owner) {
        super(number, balance, owner);
    }

    public LocalDateTime getLastWithdrawal() {
        return lastWithdrawal;
    }

    private void setLastWithdrawal(LocalDateTime lastWithdrawal) {
        this.lastWithdrawal = lastWithdrawal;
    }

    @Override
    public void withdraw(double amount) {
        if( this.getBalance() >= amount && amount > 0 ){
            super.withdraw(amount);
            this.setLastWithdrawal( LocalDateTime.now() );
        }
    }

    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ISO_DATE;
        return "SavingsAccount{ " +
                "number:"+this.getNumber()+ ", "+
                "lastWithdrawal: "+ (this.getLastWithdrawal() == null ? "null" : this.getLastWithdrawal().format(dtf))
                +" }";
    }

    @Override
    protected double calculateInterest() {
        return 4.5;
    }
}
