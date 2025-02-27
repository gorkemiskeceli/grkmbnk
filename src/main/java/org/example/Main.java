package org.example;

import org.example.controller.BankController;
import org.example.service.AccountService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AccountService accountService = new AccountService();
        BankController bankController = new BankController(accountService);

        bankController.createAccount();
    }
}