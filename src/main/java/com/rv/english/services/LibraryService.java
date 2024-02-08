package com.rv.english.services;

import com.rv.english.models.workModels.Library;
import com.rv.english.models.workModels.Listing;
import com.rv.english.models.repositories.LibraryRepo;
import com.rv.english.models.repositories.ListingRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LibraryService {

    private final LibraryRepo libraryRepo;

    private final ListingRepo listingRepo;


    public List<Listing> listListing(Long libraryId) {
        if (libraryId != null) {
            return listingRepo.findListingByLibraryId(libraryId);
        } else {
            return new ArrayList<>();
        }
    }


    public void createListing(Listing listing, Library library) {

//, String listingName
//        if (listingRepo.findByListingName(listingName) != null){
//            return false;
//        }
//        listing.setListingName(listingName);
        listing.setTotalAmountWords(0L);
        listing.setLibrary(library);
        listingRepo.save(listing);
    }


}
