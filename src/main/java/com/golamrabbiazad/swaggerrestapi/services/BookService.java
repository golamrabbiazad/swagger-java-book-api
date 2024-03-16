package com.golamrabbiazad.swaggerrestapi.services;

import com.golamrabbiazad.swaggerrestapi.exceptions.BookNotFoundException;
import com.golamrabbiazad.swaggerrestapi.model.Book;
import com.golamrabbiazad.swaggerrestapi.repository.BookRepository;
import org.springframework.stereotype.Service;


import java.util.Collection;

@Service
public class BookService {
    private final BookRepository repository;

    BookService(BookRepository repository) {
        this.repository = repository;
    }

    public Book findById(long id) {
        return repository.findById(id).orElseThrow(BookNotFoundException::new);
    }

    public void createBook(Book book) {
        repository.add(book);
    }

    public Collection<Book> findBooks() {
        return repository.getBooks();
    }

    public Book updateBook(final long id, final Book book) {
        return repository.updateBook(id, book);
    }
}
