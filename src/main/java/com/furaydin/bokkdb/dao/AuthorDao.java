package com.furaydin.bokkdb.dao;

import com.furaydin.bokkdb.domain.Author;

public interface AuthorDao {
    Author getById(Long id);
    Author getByName(String firstName, String lastName);
    Author saveAuthor(Author author);
}
