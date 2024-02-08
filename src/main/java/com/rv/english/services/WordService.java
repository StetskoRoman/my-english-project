package com.rv.english.services;

import com.rv.english.models.enums.LevelUsefulWord;
import com.rv.english.models.repositories.ListingRepo;
import com.rv.english.models.repositories.ProfileRepo;
import com.rv.english.models.repositories.WordRepo;
import com.rv.english.models.repositories.WorldWordRepo;
import com.rv.english.models.workModels.Listing;
import com.rv.english.models.workModels.VisibleWord;
import com.rv.english.models.workModels.Word;
import com.rv.english.models.workModels.WorldWord;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WordService {

    private final WordRepo wordRepo;

    private final ListingRepo listingRepo;

    private final ProfileRepo profileRepo;
    private final WorldWordRepo worldWordRepo;

// как будто бы не стоит лишний раз лезть в БД, особенном в поисках слов, лучше напрямую их подгружать (mappedBy и eager справляются вроде...)
//    public List<Word> listWords(Long listingId) {
//        if (listingId != null) {
//            return wordRepo.findByListingId(listingId);
//        } else {
//            return new ArrayList<>();
//        }
//    }

    public void addWord(Word word, Listing listing, Long profileId) {
// при изменении word напрямую вместо вставки нового просто вставлял новое слово на место старого, метод save() не помогал
        Word wordForSaveInListing = new Word();
        WorldWord worldWord = new WorldWord();
        wordForSaveInListing.setListing(listing);

        boolean saveOrNot = profileRepo.findById(profileId).orElse(null).getVisibleWords();

        if (saveOrNot == true && word.getExample() != null) {

//            worldWord.setShownWord(true);
            VisibleWord visibleWord = new VisibleWord(0l, 0l, 0l, false, false);

            worldWord.setVisibleWord(visibleWord);

            if (word.getExample() != null && word.getExample().length() >= 1) {
                worldWord.setExample(word.getExample());

                worldWord.setWordName(word.getWordName());
                worldWord.setExplanation(word.getExplanation());
                worldWord.setLevelUsefulWord(word.getLevelUsefulWord());

                if (word.getTranscription() != null) {
                    worldWord.setTranscription(word.getTranscription());
                } else worldWord.setTranscription("");

                worldWordRepo.save(worldWord);

            }

        }
// не выносит null badWord ...


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

        listing.setTotalAmountWords(listing.getTotalAmountWords()+1);
        listingRepo.save(listing);
    }

    public void editWord(Word word) {



    }

}

//            if (word.getExample() != "" && word.getExplanation() != "") {
