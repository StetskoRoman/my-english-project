package com.rv.english.services;

import com.rv.english.models.Account;
import com.rv.english.models.Library;
import com.rv.english.models.Listing;
import com.rv.english.models.repositories.LibraryRepo;
import com.rv.english.models.repositories.ListingRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LibraryService {

    private final LibraryRepo libraryRepo;

    private final ListingRepo listingRepo;



    public boolean createListing(Listing listing) {

        Library libraryId = listing.getLibrary();

//        if (listingRepo.findByListingName(listingName) != null){
//            return false;
//        }

        return true;
    }


}
