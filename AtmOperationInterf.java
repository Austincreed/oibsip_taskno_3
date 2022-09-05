package com.company;

public interface AtmOperationInterf {
    public void viewBalance(double amount[], int index);
    public void depositAmount(double depositAmount, double []amount, int index);
    public void withdrawAmount(double withdrawAmount, double []amount, int index);
    public void transferAmount(double transferAmount, double []amount, int index, int index2);
    public void accountHistory();
}

//this is the interface of the atm banking system.
