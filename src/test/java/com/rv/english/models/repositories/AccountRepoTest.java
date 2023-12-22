package com.rv.english.models.repositories;

import com.rv.english.models.Account;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AccountRepoTest {

    @Autowired
    private AccountRepo accountRepo;

    @Test
    public void testFindByEmail() {
        String email = "example@example.com";
        Account account = accountRepo.findByEmail(email);

        // Добавьте код для проверки результата
    }
}

