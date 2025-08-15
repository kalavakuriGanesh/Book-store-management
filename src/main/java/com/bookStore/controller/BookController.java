package com.bookStore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.io.ByteArrayInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.*;

import com.bookStore.entity.Book;
import com.bookStore.entity.MyBookList;
import com.bookStore.service.BookService;
import com.bookStore.service.ExportService;
import com.bookStore.service.MyBookListService;

@Controller
public class BookController {
	
	@Autowired
	private BookService service;
	
	@Autowired
	private MyBookListService myBookService;
	
	@Autowired
	private ExportService exportService;
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/book_register")
	public String bookRegister() {
		return "bookRegister";
	}
	
	@GetMapping("/available_books")
	public ModelAndView getAllBook() {
		List<Book>list=service.getAllBook();
//		ModelAndView m=new ModelAndView();
//		m.setViewName("bookList");
//		m.addObject("book",list);
		return new ModelAndView("bookList","book",list);
	}
	
	@PostMapping("/save")
	public String addBook(@ModelAttribute Book b, @RequestParam("imageFile") MultipartFile imageFile) throws IOException {
	    if (!imageFile.isEmpty()) {
	        String fileName = UUID.randomUUID() + "_" + imageFile.getOriginalFilename();
	        Path uploadPath = Paths.get("uploads");
	        if (!Files.exists(uploadPath)) Files.createDirectories(uploadPath);
	        Path filePath = uploadPath.resolve(fileName);
	        Files.copy(imageFile.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
	        b.setImagePath("/uploads/" + fileName);
	    }
	    service.save(b);
	    return "redirect:/available_books";
	}
	@GetMapping("/my_books")
	public String getMyBooks(Model model)
	{
		List<MyBookList>list=myBookService.getAllMyBooks();
		model.addAttribute("book",list);
		return "myBooks";
	}
	@RequestMapping("/mylist/{id}")
	public String getMyList(@PathVariable("id") int id) {
		Book b=service.getBookById(id);
		MyBookList mb=new MyBookList(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
		myBookService.saveMyBooks(mb);
		return "redirect:/my_books";
	}
	
	@RequestMapping("/editBook/{id}")
	public String editBook(@PathVariable("id") int id,Model model) {
		Book b=service.getBookById(id);
		model.addAttribute("book",b);
		return "bookEdit";
	}
	@RequestMapping("/deleteBook/{id}")
	public String deleteBook(@PathVariable("id")int id) {
		service.deleteById(id);
		return "redirect:/available_books";
	}
	
	@GetMapping("/search")
	public String searchBooks(@RequestParam String query, Model model) {
		List<Book> books = service.searchBooks(query);
		model.addAttribute("book", books);
		model.addAttribute("searchQuery", query);
		return "bookList";
	}
	
	@GetMapping("/available_books_paginated")
	public String getAllBooksPaginated(@RequestParam(defaultValue = "0") int page, 
	                                   @RequestParam(defaultValue = "5") int size, Model model) {
		Page<Book> bookPage = service.getAllBooksPaginated(page, size);
		model.addAttribute("book", bookPage.getContent());
		model.addAttribute("currentPage", page);
		model.addAttribute("totalPages", bookPage.getTotalPages());
		model.addAttribute("totalItems", bookPage.getTotalElements());
		return "bookListPaginated";
	}
	
	@GetMapping("/export/excel")
	public ResponseEntity<InputStreamResource> exportToExcel() throws IOException {
	    List<Book> books = service.getAllBook();
	    ByteArrayInputStream in = exportService.exportToExcel(books);
	    HttpHeaders headers = new HttpHeaders();
	    headers.add("Content-Disposition", "attachment; filename=books.xlsx");
	    return ResponseEntity.ok()
	            .headers(headers)
	            .contentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
	            .body(new InputStreamResource(in));
	}
	
}
