package com.rv.english.models.repositories;

import com.rv.english.models.workModels.Profile;
import com.rv.english.models.workModels.WorldWord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorldWordRepo extends JpaRepository<WorldWord, Long> {


}
