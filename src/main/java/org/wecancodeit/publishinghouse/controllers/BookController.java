package org.wecancodeit.publishinghouse.controllers;

import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.wecancodeit.publishinghouse.models.Book;
import org.wecancodeit.publishinghouse.repositories.BookRepository;

@Controller
public class BookController {
	
	@Resource
	BookRepository bookRepo;

	@GetMapping("/books/{bookId}")
	public String getBook(@PathVariable Long bookId, Model model) throws Exception {
		Optional<Book> book = bookRepo.findById(bookId);
		if (book.isPresent()) {
			model.addAttribute("book", book.get());
		} else {
			throw new Exception("That doesn't exist");
		}
		return "books/single";
	}

}
