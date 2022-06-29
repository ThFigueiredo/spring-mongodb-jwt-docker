package com.covid.repo;

import com.covid.models.Book;
import org.springframework.data.repository.CrudRepository;

public interface BooksRepository extends CrudRepository<Book, String>{

}
