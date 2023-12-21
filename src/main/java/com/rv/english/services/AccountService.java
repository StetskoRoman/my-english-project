package com.rv.english.services;

import com.rv.english.models.Account;
import com.rv.english.models.Library;
import com.rv.english.models.Listing;
import com.rv.english.models.enums.AccountRoles;
import com.rv.english.models.repositories.AccountRepo;
import com.rv.english.models.repositories.LibraryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService implements UserDetailsService {

    @Lazy
    private final AccountRepo accountRepo;

    private final LibraryRepo libraryRepo;

    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String accountName) throws UsernameNotFoundException {
        Account account = accountRepo.findByAccountName(accountName);
        if (account == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return account;
    }

    public boolean createAccount(Account account) {
        String accountMail = account.getEmail();

        if (accountRepo.findByEmail(accountMail) != null){
            return false;
        }

        account.setActive(true);
        account.setRoles(Collections.singletonList(AccountRoles.USER));   //change role to ADMIN to create first administrator on server
        account.setPassword(passwordEncoder.encode(account.getPassword()));

//TO DO  message to email
        accountRepo.save(account);

//        create immediately library for account
        Long accountId = accountRepo.findByEmail(accountMail).getId();
        System.out.println("acc id = "  + accountId);
        Library library = new Library();
        library.setAccount(account);
        library.setTotalWordsInLibrary(0L);
        libraryRepo.save(library);

        return true;
    }


}
