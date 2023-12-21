package com.rv.english.models.repositories;

import com.rv.english.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepo extends JpaRepository<Account, Long> {

//    private String accountName;
    Account findByAccountName(String account);

    Account findByEmail(String account);
}
