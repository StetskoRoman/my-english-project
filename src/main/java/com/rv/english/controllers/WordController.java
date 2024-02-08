package com.rv.english.controllers;

import com.rv.english.models.workModels.Account;
import com.rv.english.models.workModels.Listing;
import com.rv.english.models.workModels.Word;
import com.rv.english.services.WordService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
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

        return "createWord";
    }

    @PostMapping("/{id}/library/{listing}/createWord")
    public String createWord(
            @AuthenticationPrincipal Account account,
            @PathVariable Listing listing,
            @Valid Word word
            ) {


        wordService.addWord(word, listing, account.getId());

//        System.out.println("listing name = " + listing.getListingName());
//        System.out.println("Listing else = " + listing.getId() + "   " + word.getExplanation()+"  name " + word.getWordName());
        return "redirect:/{id}/library/{listing}";
    }

    @GetMapping("/{id}/library/{listing}/{word}")
    public String editWord(@AuthenticationPrincipal Account account,
                           @PathVariable Listing listing,
                           @PathVariable Word word,
                           Model model) {


        return "editWord";
    }

}
