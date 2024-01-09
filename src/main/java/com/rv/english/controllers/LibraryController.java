package com.rv.english.controllers;


import com.rv.english.models.Account;
import com.rv.english.models.Library;
import com.rv.english.models.Listing;
import com.rv.english.models.repositories.LibraryRepo;
import com.rv.english.models.repositories.ListingRepo;
import com.rv.english.services.LibraryService;
import com.rv.english.services.ListingService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class LibraryController {

    private final LibraryService libraryService;

    private final ListingService listingService;


    @GetMapping("/{id}/library")
    public String showLibrary(@AuthenticationPrincipal Account currentAccount,
//                              @PathVariable Library library,
                              @PathVariable Long id,
                              Model model) {

        if (libraryService.listListing(id).size() == 0) {
            model.addAttribute("errorMessage", "Empty library");
            return "library";
        }
        model.addAttribute("listingList", libraryService.listListing(id));
        return "library";
    }

    @GetMapping("/{id}/library/{listingId}")
    public String showListing(@AuthenticationPrincipal Account currentAccount,
                              @PathVariable Long id,
                              @PathVariable Long listingId) {

        return "wordList";
    }


    @PostMapping("/{library}/library/createListing")
    public String createListing(@AuthenticationPrincipal Account currentAccount,
                                @PathVariable Library library,
                                Listing listing,
                                //                                @RequestParam String listingName,
                                Model model) {
        libraryService.createListing(listing, library);

        return "redirect:/{library}/library";
    }
}

