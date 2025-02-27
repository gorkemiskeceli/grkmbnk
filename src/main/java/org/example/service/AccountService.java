package org.example.service;

import org.example.model.Account;

import javax.swing.plaf.synth.SynthOptionPaneUI;
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

            if (accountHolderName != null && accountHolderName.trim().isEmpty()) {
                System.out.println("Account holder name cannot be empty");
                return;
            }
            if (balance <= 0){
                System.out.println("Balance must be greater than zero!");
                return;
            }
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
            if (amount < 0 ){
                System.out.println("Amount cannot negative");
                return;
            }
            account.deposit(amount);
            System.out.println(amount+" USD deposited. New Balance is: " + account.getBalance());
        }else {
            System.out.println("Account cannot be found!!");
        }
    }

    public void withdraw(String accountNumber, Double amount){
        Account account = getAccountByNumber(accountNumber);
        if (account != null){
            if (amount <=0){
                System.out.println("Invalid amount! Amount must be greater than zero");
            }
            if (amount > 0 && amount <= account.getBalance()){
                account.withdraw(amount);
                System.out.println(amount+" USD has been withdrawed. New balance is: " + account.getBalance());
            }else {
                System.out.println("Balance can not be empty");
            }
        }else {
            System.out.println("Account cannot be found");
        }
    }

    public void getAccountDetails(String accountNumber){
        Account account = getAccountByNumber(accountNumber);
        if (account != null){
            System.out.println("\n--- ACCOUNT DETAILS ---");
            System.out.println("Account Number: " + account.getAccountNumber());
            System.out.println("Account Holder: " + account.getAccountNumber());
            System.out.println("Balance: " + account.getBalance());
        }else {
            System.out.println("Account cannot be found!!!");
        }

    }


    public void deleteAcc(String accountNumber){
        Account account = getAccountByNumber(accountNumber);
        if (account != null) {
            if (deleteConfirmation()) {
                accounts.remove(account);
                System.out.println("Account with " + accountNumber + " has been deleted");
            }else {
                System.out.println("Account deletion canceled.");
            }
        }else {
            System.out.println("Account cannot be found!!!");
        }
    }


    public boolean deleteConfirmation(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Are you sure wou want to delete this account? (y/n): ");
        String response = scanner.nextLine();
        return response.equalsIgnoreCase("y");
    }






}
