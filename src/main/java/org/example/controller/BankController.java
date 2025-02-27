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

}
