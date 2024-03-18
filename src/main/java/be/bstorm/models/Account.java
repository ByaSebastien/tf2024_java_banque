package be.bstorm.models;

import be.bstorm.exceptions.NegativeAmountException;
import be.bstorm.models.interfaces.IBanker;
import be.bstorm.models.interfaces.ICustomer;

import java.util.function.Consumer;

public abstract class Account implements ICustomer, IBanker {

    private String number;
    private double balance;
    private Person owner;
    private Consumer<Account> passageEnNegatifEvent;

    public Account(String number, double balance, Person owner) {
        this.number = number;
        this.balance = balance;
        this.owner = owner;
    }

    public Account(String number, Person owner) {
        this(number, 0, owner);
    }

    public String getNumber() {
        return number;
    }

    private void setNumber(String number) {
        this.number = number;
    }

    public double getBalance() {
        return balance;
    }

    private void setBalance(double balance) {
        this.balance = balance;
    }

    public Person getOwner() {
        return owner;
    }

    private void setOwner(Person owner) {
        this.owner = owner;
    }

    public void deposit(double amount){
        if( amount < 0 ){
            throw new NegativeAmountException();
        }

        this.setBalance( this.getBalance() + amount );
    }

    public void withdraw(double amount){
        if( amount < 0 ){
            throw new NegativeAmountException();
        }

        this.setBalance( this.getBalance() - amount );
    }

    abstract protected double calculateInterest();
    public void applyInterest(){
        double toAdd = this.balance * (calculateInterest() /100);
        this.setBalance( this.getBalance() + toAdd );
    }
    protected void raisePassageEnNegatifEvent(){
        if(passageEnNegatifEvent == null){
            return;
        }
        this.passageEnNegatifEvent.accept(this);
    }

    public void setPassageEnNegatifAction(Consumer<Account> action){
        this.passageEnNegatifEvent = action;
    }
}
