package com.bookStore.repository;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookStore.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer>  {
    
    List<Book> findByNameContainingIgnoreCaseOrAuthorContainingIgnoreCase(String name, String author);
    Page<Book> findAll(Pageable pageable);
    Page<Book> findByNameContainingIgnoreCaseOrAuthorContainingIgnoreCase(String name, String author, Pageable pageable);
}
