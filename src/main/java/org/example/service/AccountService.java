package org.example.service;

import org.example.model.Account;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class AccountService {

    private Map<String, Account> accounts = new HashMap<>();

    public String accountNumbeGenerator(){
        Random random = new Random();
        return String.format("%010d", random.nextInt(10000)); //creates 10 digit number
    }

    public void createAccount(Long id,String accountHolder,Double balance){
        String accountNumber = accountNumbeGenerator();
        if (accounts.containsKey(accountNumber)){
            System.out.println("This account is already existing in application");
            accountNumber = accountNumbeGenerator();
            return;
        }
        Account account = new Account(id, accountNumber, accountHolder, balance);
        accounts.put(accountNumber, account);
        System.out.println("hesap oluşturuldu:" +accountHolder);
    }


}
