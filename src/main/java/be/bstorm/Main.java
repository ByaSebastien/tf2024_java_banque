package be.bstorm;

import be.bstorm.exceptions.InsufficientBalanceException;
import be.bstorm.exceptions.NegativeAmountException;
import be.bstorm.models.*;
import be.bstorm.models.interfaces.IBanker;
import be.bstorm.models.interfaces.ICustomer;

public class Main {
    public static void main(String[] args) {

        Person owner = new Person();

        CurrentAccount currentAccount = new CurrentAccount(
                "BE12 1234 1234 1234",
                owner,
                1000,
                -1000
        );

        SavingsAccount savingsAccount = new SavingsAccount(
                "BE12 1234 1234 1235",
                owner
        );

        Account account = savingsAccount;


        Bank bank = new Bank("ma banque");

        bank.addAccount(currentAccount);

        try{
            currentAccount.withdraw(1500);
        }catch (NegativeAmountException | InsufficientBalanceException ex){
            System.out.println(ex.getMessage());
        }

//        ICustomer customer = currentAccount;
//        IBanker banker = currentAccount;
//
//        customer.deposit(999999999);
//        banker.applyInterest();

    }
}
