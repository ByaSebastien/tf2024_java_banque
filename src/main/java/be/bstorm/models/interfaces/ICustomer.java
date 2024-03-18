package be.bstorm.models.interfaces;

public interface ICustomer {

    double getBalance();
    void deposit(double amount);
    void withdraw(double amount);
}
