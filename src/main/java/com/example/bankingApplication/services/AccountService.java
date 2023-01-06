package com.example.bankingApplication.services;

import com.example.bankingApplication.dtos.AccountRequest;
import com.example.bankingApplication.model.Account;
import com.example.bankingApplication.model.Customer;
import com.example.bankingApplication.repositories.AccountRepository;
import com.example.bankingApplication.userDetails.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    AccountRepository accountRepository;
    public void saveAccount(AccountRequest request) {
        long customerId = getCurrentCustomerId();

         Account account =  accountMapper(request);
        accountRepository.save(account);
        
    }

    private Account accountMapper(AccountRequest request) {
        return Account.builder()
//                .customerId(request.getCustomerId())
                .accBalance(request.getAccBalance())
                .accNumber(request.getAccNumber())
                .build();
    }


//    private long getCurrentCustomerId(Account account) {
//        if (account.getId() != null) idCounter ++;
//        return idCounter;
//    }
private Long getCurrentCustomerId(){
    UserDetails userDetails = new UserDetails();

    Long userDetailsId = null;
    userDetailsId = Long.valueOf(userDetails.getId());

    return userDetailsId;
}
}
