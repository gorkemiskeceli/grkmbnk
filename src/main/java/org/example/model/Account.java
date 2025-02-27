package org.example.model;

import java.util.Random;

public class Account {
    
    private String accountNumber;
    private String accountHolder;
    private Double balance;


    //constructors
    public Account(String accountNumber, String accountHolder, Double balance){
        this.accountNumber=accountNumber;
        this.accountHolder=accountHolder;
        this.balance= 0.0; //0.0 at start
    }

    //getter setter
    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        if (balance>=0){
            this.balance=balance;
        }else {
            throw new IllegalArgumentException("Balance cannot be negative");
        }
    }

    public void deposit(Double amount){
      if (amount > 0){
          balance += amount;
      }
    }
    public void withdraw(Double amount){
        if (amount > 0 && amount <= balance){
            balance -= amount;
        }
    }


}
