package com.codocato.codocato.repositories;

import com.codocato.codocato.models.Lesson;
import com.codocato.codocato.models.Prompt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface PromptRepository extends JpaRepository<Prompt, Long> {
}
