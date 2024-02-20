package com.rv.english.controllers;


import com.rv.english.models.workModels.Account;
import com.rv.english.models.workModels.Library;
import com.rv.english.models.workModels.Listing;
import com.rv.english.services.LibraryService;
import com.rv.english.services.WordService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class LibraryController {

    private final LibraryService libraryService;

    private final WordService wordService;


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

    @GetMapping("/{id}/library/{listing}")
    public String showListing(@AuthenticationPrincipal Account currentAccount,
                              @PathVariable Long id,
                              @PathVariable Listing listing,
                              Model model) {
        if (listing.getWords().size()== 0) {
            model.addAttribute("errorMessage", "Empty wordlist");
            return "wordList";
        }
        model.addAttribute("wordList", listing.getWords());

//        The same but through the Database
//        if (wordService.listWords(listing.getId()).size() == 0) {
//            model.addAttribute("errorMessage", "Empty wordlist");
//            return "wordList";
//        }
//        model.addAttribute("wordList", wordService.listWords(listing.getId()));

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

