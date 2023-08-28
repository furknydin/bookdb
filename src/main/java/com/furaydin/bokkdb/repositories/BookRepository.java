package com.furaydin.bokkdb.repositories;

import com.furaydin.bokkdb.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
