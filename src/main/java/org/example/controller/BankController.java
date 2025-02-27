package org.example.controller;

import org.example.service.AccountService;

import java.util.Scanner;

public class BankController {

    private final AccountService accountService;
    private final Scanner scanner;

    public BankController(AccountService accountService) {
        this.accountService = accountService;
        this.scanner = new Scanner(System.in);
    }

    public void createAccount(){
        System.out.println("Please enter initials for creating account!!!");
        System.out.print("ID:");
        Long id = scanner.nextLong();
        System.out.print("Account Holder");
        String accountHolder = scanner.nextLine();
        System.out.print("Starting Balance:");
        Double balance = scanner.nextDouble();

        accountService.createAccount(id, accountHolder, balance);
    }
}
