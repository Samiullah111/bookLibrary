package com.example.booklibrary.Repository;


import com.example.booklibrary.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
    Optional<Book> findBookByBookTitle(String B);
    Book findByBookId(Long id);
}
