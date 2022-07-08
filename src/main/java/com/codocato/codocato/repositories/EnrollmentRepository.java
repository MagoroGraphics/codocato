package com.codocato.codocato.repositories;

import com.codocato.codocato.models.Enrollment;
import com.codocato.codocato.models.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    Optional<Enrollment> findFirstByIsCompleteFalseAndPlayer_IdOrderByIdAsc(Long id);

}
