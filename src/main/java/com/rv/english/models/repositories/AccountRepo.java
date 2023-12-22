package com.rv.english.models.repositories;

import com.rv.english.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepo extends JpaRepository<Account, Long> {

//    private String accountName;
    Optional<Account> findById(Long id);

    Account findByEmail(String email);

}
