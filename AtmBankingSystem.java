package com.company;
import java.util.Scanner;

public class AtmBankingSystem {
    public static void main(String[] args){
        int c = -1;
        Scanner sc= new Scanner(System.in);
        AtmOperationInterf a = new AtmOperationImpl();
        int atmnumber[] = {98765, 45675, 45678, 90654, 98012};
        double atmpin[] = {457890, 908765, 789654, 345678, 349876};
        double amount[] = {50000, 98000, 45300, 60000, 56000};
        System.out.println("Enter Account Number:- ");
        int atmNumber = sc.nextInt();
        System.out.println("Enter Pin:- ");
        double atmPin = sc.nextDouble();
        for(int i=0;i<atmnumber.length;i++){
            if(atmNumber==atmnumber[i]){
                c = i;
                break;
            }
        }
        if(c ==-1){
            System.out.println("Invalid account number.");
            System.exit(0);
        }
        if(atmPin==atmpin[c]){
            while(true){
                System.out.println();
                System.out.println("1. Transcation History\n2. Withdraw\n3. Deposit\n4. Transfer\n5. Quit");
                System.out.println("Enter Your choice:- ");
                int choice  = sc.nextInt();
                if(choice == 1){
                    a.accountHistory();
                }
                else if(choice == 2){
                    //Withdraw
                    System.out.println("Enter the amount to withdraw:- ");
                    double withdrawAmount = sc.nextDouble();
                    a.withdrawAmount(withdrawAmount, amount, c);
                }
                else if(choice == 3){
                    //deposit
                    System.out.println("Enter the amount to be deposited:- ");
                    double depositAmount = sc.nextDouble();
                    a.depositAmount(depositAmount, amount, c);
                }
                else if(choice == 4){
                    //transfer
                    int index2 = -1;
                    System.out.println("Enter account number you want to transfer amount:- ");
                    double transferNumber = sc.nextDouble();
                    for(int j=0;j<atmnumber.length;j++){
                        if(transferNumber==atmnumber[j]){
                            index2 = j;
                            break;
                        }
                    }
                    if(index2==c){
                        System.out.println("You cannot transfer amount to your own account...INVALID ACTION.");
                        System.exit(0);
                    }
                    if(index2==-1){
                        System.out.println("Account is not present in the bank..");
                        System.exit(0);
                    }

                    System.out.println("Amount of money you want to transfer:- ");
                    double transferAmount = sc.nextDouble();
                    a.transferAmount(transferAmount, amount, c, index2);
                }
                else if(choice == 5){
                    System.out.println("THANK YOU...");
                    System.exit(0);
                }
                else{
                    System.out.println("Enter valid User Input");
                }
            }
        }
        else{
            System.out.println("Invalid pin.");
            System.exit(0);
        }



    }
}
