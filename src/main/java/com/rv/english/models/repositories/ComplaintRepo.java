package com.rv.english.models.repositories;

import com.rv.english.models.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComplaintRepo extends JpaRepository<Complaint, Long> {
}
