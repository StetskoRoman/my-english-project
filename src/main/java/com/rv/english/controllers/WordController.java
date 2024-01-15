package com.rv.english.controllers;

import com.rv.english.models.Account;
import com.rv.english.models.Listing;
import com.rv.english.models.Word;
import com.rv.english.services.WordService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class WordController {

    private final WordService wordService;


    @GetMapping("/{id}/library/{listing}/createWord")
    public String emptyWord(
            @AuthenticationPrincipal Account account,
            @PathVariable Long id,
            @PathVariable Listing listing,
            Model model
    ) {
        model.addAttribute("listing", listing);

        return "wordEdit";
    }

    @PostMapping("/{id}/library/{listing}/createWord")
    public String createWord(
            @AuthenticationPrincipal Account account,
            @PathVariable Listing listing,
            @Valid Word word,
            Model model) {


        wordService.addWord(word, listing);
        System.out.println("listing name = " + listing.getListingName());
        System.out.println("Listing else = " + listing.getId());
        return "redirect:/{id}/library/{listing}";
    }

}
