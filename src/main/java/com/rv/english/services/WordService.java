package com.rv.english.services;

import com.rv.english.models.enums.LevelUsefulWord;
import com.rv.english.models.repositories.ListingRepo;
import com.rv.english.models.repositories.ProfileRepo;
import com.rv.english.models.repositories.WordRepo;
import com.rv.english.models.repositories.WorldWordRepo;
import com.rv.english.models.workModels.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class WordService {

    private final WordRepo wordRepo;

    private final ListingRepo listingRepo;

    private final ProfileRepo profileRepo;
    private final WorldWordRepo worldWordRepo;

// как будто бы не стоит лишний раз лезть в БД, особенном в поисках слов, лучше напрямую их подгружать
//    public List<Word> listWords(Long listingId) {
//        if (listingId != null) {
//            return wordRepo.findByListingId(listingId);
//        } else {
//            return new ArrayList<>();
//        }
//    }

    public void addWord(Word word, Listing listing, Long profileId) {

        Word wordForSaveInListing = new Word();
        WorldWord worldWord = new WorldWord();
        wordForSaveInListing.setListing(listing);

        Optional<Profile> profile = profileRepo.findById(profileId);

        boolean saveOrNot = profile.orElse(null).getVisibleWords();
        ;

        if (saveOrNot == true && word.getExample() != null) {

            VisibleWord visibleWord = new VisibleWord(0l, 0l, 0l, false, false);
            worldWord.setVisibleWord(visibleWord);

            if (word.getExample() != null && word.getExample().length() >= 1) {
                worldWord.setExample(word.getExample());

                worldWord.setWordName(word.getWordName());
                worldWord.setExplanation(word.getExplanation());
                worldWord.setLevelUsefulWord(word.getLevelUsefulWord());
                worldWord.setProfile(profile.orElse(null));

                if (word.getTranscription() != null) {
                    worldWord.setTranscription(word.getTranscription());
                } else worldWord.setTranscription("");

                worldWordRepo.save(worldWord);
            }
        }

        wordForSaveInListing.setWordName(word.getWordName());
        wordForSaveInListing.setExplanation(word.getExplanation());
        if (word.getLevelUsefulWord() != null) {
            wordForSaveInListing.setLevelUsefulWord(word.getLevelUsefulWord());
        } else wordForSaveInListing.setLevelUsefulWord(LevelUsefulWord.VERY_LOW);

        if (word.getExample() != null) {
            wordForSaveInListing.setExample(word.getExample());
        } else wordForSaveInListing.setExample("");

        if (word.getTranscription() != null) {
            wordForSaveInListing.setTranscription(word.getTranscription());
        } else wordForSaveInListing.setTranscription("");

        wordRepo.save(wordForSaveInListing);

        listing.setTotalAmountWords(listing.getTotalAmountWords() + 1);
        listingRepo.save(listing);
    }

//    public void editWord(Word word, Listing listing) {
//
//        Word changedWord = wordRepo.findById(word.getId()).orElse(new Word());
//
//        log.info("in Service " + changedWord.getId() + "  " +  changedWord.getWordName());
//
//        changedWord.setListing(listing);
////        changedWord.setWordName(word.getWordName());
//        changedWord.setWordName("SomeOther name");
//        changedWord.setLevelUsefulWord(word.getLevelUsefulWord());
//        changedWord.setExplanation(word.getExplanation());
//        changedWord.setExample(word.getExample());
//
//        log.info("After changing " + changedWord.getId() + "  " + changedWord.getWordName() + "  list " + changedWord.getListing());
//
//        wordRepo.save(changedWord);
//        listingRepo.save(listing);
//
//    }
}

//        Word changedWord = wordRepo.findById(wordId).orElse(null);
//        changedWord.setListing(listing);
//        changedWord.setWordName(wordId);
//        System.out.println(changedWord);

//        word.setWordName(word.getWordName());
//        word.setExplanation(word.getExplanation());
//
//        if (word.getExample() != null) {
//            word.setExample(word.getExample());
//        } else word.setExample("");
//
//        if (word.getTranscription() != null) {
//            word.setTranscription(word.getTranscription());
//        } else word.setTranscription("");
////        System.out.println("word = "  + word);
//        wordRepo.save(word);
//        listingRepo.save(listing);

//word.setTranscription(word.getTranscription());
//        Word changedWord = new Word();
//        changedWord.setListing(listing);
//        changedWord.setExample(word.getExample());

//            if (word.getExample() != "" && word.getExplanation() != "") {
