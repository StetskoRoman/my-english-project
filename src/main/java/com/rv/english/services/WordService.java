package com.rv.english.services;

import com.rv.english.models.Library;
import com.rv.english.models.Listing;
import com.rv.english.models.VisibleWord;
import com.rv.english.models.Word;
import com.rv.english.models.repositories.ListingRepo;
import com.rv.english.models.repositories.ProfileRepo;
import com.rv.english.models.repositories.WordRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WordService {

    private final WordRepo wordRepo;

    private final ListingRepo listingRepo;

    private final ProfileRepo profileRepo;

    public List<Word> listWords(Long listingId) {
        if (listingId != null) {
            return wordRepo.findByListingId(listingId);
        } else {
            return new ArrayList<>();
        }
    }

    public void addWord(Word word, Listing listing) {
// при изменении word напрямую вместо вставки нового просто вставлял новое слово на место старого, метод save() не помогал
        Word wordForSave = new Word();
        wordForSave.setListing(listing);

        boolean saveOrNot = profileRepo.findById(listing.getLibrary().getId()).orElse(null).getVisibleWords();

        if (saveOrNot == true){
                wordForSave.setShownWord(true);
        }
// не выносит null badWord ...
        VisibleWord visibleWord = new VisibleWord(0l, 0l, 0l, false, false);

        wordForSave.setVisibleWord(visibleWord);
        wordForSave.setWordName(word.getWordName());

        wordRepo.save(wordForSave);

        listing.setTotalAmountWords(listing.getTotalAmountWords()+1);
        listingRepo.save(listing);
    }

}

//            if (word.getExample() != "" && word.getExplanation() != "") {
