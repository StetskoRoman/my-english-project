package com.rv.english.models.repositories;

import com.rv.english.models.Word;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface WordRepo extends JpaRepository<Word, Long> {

//    List<Word> findByLibraryId(Long libraryId);

    List<Word> findByWordName(String wordName);

    List<Word> findByListingId(Long listingId);
}
