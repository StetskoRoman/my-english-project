package com.rv.english.services;

import com.rv.english.models.repositories.LibraryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LibraryService {

    private final LibraryRepo libraryRepo;


}
