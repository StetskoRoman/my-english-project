package com.rv.english.models.repositories;

import com.rv.english.models.Word;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WordRepo extends JpaRepository<Word, Long> {
}
