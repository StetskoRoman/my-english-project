package com.rv.english.models.repositories;

import com.rv.english.models.Library;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryRepo extends JpaRepository<Library, Long> {

}
