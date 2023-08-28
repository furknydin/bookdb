package com.furaydin.bokkdb.repositories;

import com.furaydin.bokkdb.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
