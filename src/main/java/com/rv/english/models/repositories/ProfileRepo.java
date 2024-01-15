package com.rv.english.models.repositories;

import com.rv.english.models.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfileRepo extends JpaRepository<Profile, Long> {


    Optional<Profile> findById(Long id);
}
