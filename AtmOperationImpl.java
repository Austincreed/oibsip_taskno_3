package com.company;
import java.util.Map;
import java.util.HashMap;

public class AtmOperationImpl implements AtmOperationInterf{
    Map<Double, String> transcation = new HashMap<>();
    @Override
    public void viewBalance(double amount[], int index) {
        System.out.println("Availabe balance:- "+amount[index]);
    }

    @Override
    public void depositAmount(double depositAmount, double []amount, int index) {
        transcation.put(depositAmount, "AMOUNT DEPOSITED");
        System.out.println(depositAmount+" has been deposited successfully..");
        amount[index] = amount[index] + depositAmount;
        viewBalance(amount, index);



    }

    @Override
    public void withdrawAmount(double withdrawAmount, double []amount, int index) {
        if(withdrawAmount>amount[index]){
            System.out.println("Insufficient amount.");
        }
        else{
            transcation.put(withdrawAmount, "AMOUNT WITHDRAWN");
            System.out.println(withdrawAmount+" has been withdrawned successfully..");
            amount[index] = amount[index] - withdrawAmount;
            viewBalance(amount, index);
        }
    }

    @Override
    public void transferAmount(double transferAmount, double amount[], int index, int index2) {
        if(transferAmount>amount[index]){
            System.out.println("Insufficient amount.");
        }
        else{
            transcation.put(transferAmount, "AMOUNT TRANSFERED" );
            System.out.println(transferAmount+" has been transfered Successfully.");
            amount[index] = amount[index] - transferAmount;
            amount[index2] = amount[index2] + transferAmount;
            viewBalance(amount, index);
        }

    }

    @Override
    public void accountHistory() {
        for(Map.Entry<Double, String>e:transcation.entrySet()){
            System.out.println(e.getKey()+" ---> "+e.getValue());
        }
    }
}
