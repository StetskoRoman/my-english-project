package com.rv.english.models.repositories;

import com.rv.english.models.Listing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListingRepo extends JpaRepository<Listing, Long> {
}
