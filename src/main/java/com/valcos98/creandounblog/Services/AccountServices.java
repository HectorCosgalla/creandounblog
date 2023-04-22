package com.valcos98.creandounblog.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valcos98.creandounblog.models.Account;
import com.valcos98.creandounblog.repositories.AccountRepository;

@Service
public class AccountServices {
    @Autowired
    private AccountRepository accountRepository;

    public Account save(Account account){
        return accountRepository.save(account);
    }
}
