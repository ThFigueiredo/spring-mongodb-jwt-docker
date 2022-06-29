package com.covid.api;

import com.covid.models.Book;
import com.covid.repo.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/books")
public class BooksApi {

	@Autowired
    BooksRepository booksRepository;

    @RequestMapping(method=RequestMethod.GET)
    public Iterable<Book> books() {
        return booksRepository.findAll();
    }
	
	
}
