package com.rv.english.models.repositories;

import com.rv.english.models.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoRepo extends JpaRepository<Photo, Long> {

}
