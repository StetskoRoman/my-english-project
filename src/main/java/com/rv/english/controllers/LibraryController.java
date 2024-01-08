package com.rv.english.controllers;


import com.rv.english.models.Account;
import com.rv.english.models.repositories.LibraryRepo;
import com.rv.english.models.repositories.ListingRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class LibraryController {

    private final LibraryRepo libraryRepo;

    private final ListingRepo listingRepo;


    @GetMapping("/{id}/library")
    public String showLibrary(@AuthenticationPrincipal Account currentAccount
    ) {
        return "library";
    }
}

