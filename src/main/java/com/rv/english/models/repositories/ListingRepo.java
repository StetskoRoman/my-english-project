package com.rv.english.models.repositories;

import com.rv.english.models.Listing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ListingRepo extends JpaRepository<Listing, Long> {

    Listing findByListingName(String listingName);

    Listing findListingByLibraryId(Long libraryId);
}
