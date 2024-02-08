package com.rv.english.models.repositories;

import com.rv.english.models.workModels.Library;
import com.rv.english.models.workModels.Listing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LibraryRepo extends JpaRepository<Library, Long> {

    List<Listing> getLibrariesById(Long id);
}
