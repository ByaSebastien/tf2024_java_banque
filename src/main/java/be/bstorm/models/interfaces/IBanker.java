package be.bstorm.models.interfaces;

import be.bstorm.models.Person;

public interface IBanker extends ICustomer{

    void applyInterest();
    Person getOwner();
    String getNumber();
}
