package org.example.service;

import org.example.model.Account;

import java.util.*;

public class AccountService {

    private List<Account> accounts;

    public String generateAccountNumber(){
        Random random = new Random();
        StringBuilder accountNumber = new StringBuilder();
        accountNumber.append(random.nextInt(9)+1);
        for (int i = 0; i<9; i++){
            accountNumber.append(random.nextInt(10));
        }
        return accountNumber.toString();
    }

    public void addAccount(String accountHolderName, Double balance){
            String accountNumber = generateAccountNumber();
            Account account = new Account(accountNumber, accountHolderName, balance);
            account.setBalance(balance);
            accounts.add(account);

        System.out.println("New account has been created!!!");
    }

    public List<Account> getAccounts(){
        return accounts;
    }

    public Account getAccountByNumber(String accountNumber){
        for (Account account : accounts){
            if (account.getAccountNumber().equals(accountNumber)){
                return account;
            }
        }
        return null;
    }

    public void deposit(String accountNumber, Double amount){
        Account account = getAccountByNumber(accountNumber);
        if (account != null){
            account.deposit(amount);
            System.out.println(amount+" USD deposited. New Balance is: " + account.getBalance());
        }else {
            System.out.println("Account cannot be found!!");
        }
    }

    public void withdraw(String accountNumber, Double amount){
        Account account = getAccountByNumber(accountNumber);
        if (account != null){
            if (amount <= account.getBalance()){
                account.withdraw(amount);
                System.out.println(amount+" USD has been withdrawed. New balance is: " + account.getBalance());
            }else {
                System.out.println("Balance can not be empty");
            }
        }else {
            System.out.println("Account cannot be found");
        }
    }









}
