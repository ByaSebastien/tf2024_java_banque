package be.bstorm.models;

import java.util.HashMap;

public class Bank {

    private final String name;
    private final HashMap<String, CurrentAccount> currentAccounts = new HashMap<>();
    private final HashMap<String, SavingsAccount> savingsAccounts = new HashMap<>();

    public Bank(String name) {
        this.name = name;
    }


    public void addAccount(CurrentAccount toAdd){
        System.out.println("version current");
        if( !currentAccounts.containsKey( toAdd.getNumber() ) ){
            currentAccounts.put(toAdd.getNumber(), toAdd);
        }
    }

    public void addAccount(SavingsAccount toAdd){
        System.out.println("version savings");
        if( !savingsAccounts.containsKey( toAdd.getNumber() ) ){
            savingsAccounts.put(toAdd.getNumber(), toAdd);
        }
    }

    public void addAccount(Account account){
        System.out.println("version general");
        if( account instanceof CurrentAccount currentAccount ){
            this.addAccount(currentAccount);
        }
        else if ( account instanceof SavingsAccount savingsAccount ){
            this.addAccount(savingsAccount);
        }
    }

}
