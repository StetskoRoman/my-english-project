package com.rv.english.models.repositories;

import com.rv.english.models.workModels.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComplaintRepo extends JpaRepository<Complaint, Long> {
}
