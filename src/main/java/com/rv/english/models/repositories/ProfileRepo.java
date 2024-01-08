package com.rv.english.models.repositories;

import com.rv.english.models.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepo extends JpaRepository<Profile, Long> {


}
