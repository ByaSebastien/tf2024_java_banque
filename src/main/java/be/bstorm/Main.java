package be.bstorm;

import be.bstorm.models.*;

public class Main {
    public static void main(String[] args) {

        Person owner = new Person();

        CurrentAccount currentAccount = new CurrentAccount(
                "BE12 1234 1234 1234",
                owner
        );

        SavingsAccount savingsAccount = new SavingsAccount(
                "BE12 1234 1234 1235",
                owner
        );

        Account account = savingsAccount;


        Bank bank = new Bank("ma banque");

        bank.addAccount(account);

    }
}
