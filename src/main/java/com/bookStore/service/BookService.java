package com.bookStore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.bookStore.entity.Book;
import com.bookStore.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bRepo;
	
	public void save(Book b) {
		bRepo.save(b);
	}
	
	public List<Book> getAllBook(){
		return bRepo.findAll();
	}
	
	/**
	 * Returns a book with the given id.
	 *
	 * @param  id  the id of the book to retrieve
	 * @return     the book with the given id, or null if no book with the given id exists
	 * @throws  NoSuchElementException  if no book with the given id exists
	 */
	public Book getBookById(int id) {
		return bRepo.findById(id).get();
	}
	public void deleteById(int id) {
		bRepo.deleteById(id);
	}
	
	public List<Book> searchBooks(String query) {
		return bRepo.findByNameContainingIgnoreCaseOrAuthorContainingIgnoreCase(query, query);
	}
	
	public Page<Book> getAllBooksPaginated(int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		return bRepo.findAll(pageable);
	}
	
	public Page<Book> searchBooksPaginated(String query, int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		return bRepo.findByNameContainingIgnoreCaseOrAuthorContainingIgnoreCase(query, query, pageable);
	}
}
