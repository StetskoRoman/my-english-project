package com.rv.english.services;

import com.rv.english.models.Account;
import com.rv.english.models.Library;
import com.rv.english.models.Profile;
import com.rv.english.models.enums.AccountRoles;
import com.rv.english.models.repositories.AccountRepo;
import com.rv.english.models.repositories.LibraryRepo;
import com.rv.english.models.repositories.ProfileRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.parameters.P;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class AccountService  {

    private final AccountRepo accountRepo;

    private final LibraryRepo libraryRepo;

    private final ProfileRepo profileRepo;

    private final PasswordEncoder passwordEncoder;


    public boolean createAccount(Account account) {
        String accountMail = account.getEmail();

        if (accountRepo.findByEmail(accountMail) != null){
            return false;
        }

        account.setActive(true);
        account.setRoles(Collections.singletonList(AccountRoles.USER));   //change role to ADMIN to create first administrator on server
        account.setPassword(passwordEncoder.encode(account.getPassword()));
//        account.setCountBadWords(0L);
//        account.setVisibleWords(false);

//TO DO  message to email
        accountRepo.save(account);
//        create immediately library for account
        Long accountId = accountRepo.findByEmail(accountMail).getId();
        System.out.println("acc id = "  + accountId);
        Library library = new Library();
        library.setAccount(account);
        library.setTotalWordsInLibrary(0L);
        libraryRepo.save(library);

        System.out.println("library is = " + library.toString());


        Profile profile = new Profile();
        profile.setAccount(account);
        profile.setRating(0);
        profile.setVisibleWords(false);
        profile.setCountBadWords(0l);
        profileRepo.save(profile);

        return true;
    }


}
