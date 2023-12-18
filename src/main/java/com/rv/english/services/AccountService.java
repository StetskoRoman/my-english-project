package com.rv.english.services;

import com.rv.english.models.Account;
import com.rv.english.models.repositories.AccountRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService implements UserDetailsService {

    @Lazy
    private final AccountRepo accountRepo;

    @Override
    public UserDetails loadUserByUsername(String accountName) throws UsernameNotFoundException {
        Account account = accountRepo.findByAccountName(accountName);
        if (account == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return account;
    }
}
