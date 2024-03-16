package com.golamrabbiazad.swaggerrestapi.controllers;

import com.golamrabbiazad.swaggerrestapi.model.Book;
import com.golamrabbiazad.swaggerrestapi.services.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/v1/books")
@Tags(value = {
        @Tag(name = "Book Controller", description = "Book now controlled")
})
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public Collection<Book> getAllBooks() {
        return bookService.findBooks();
    }

    @Operation(summary = "Create Book")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created a book",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Book.class))}),
            @ApiResponse(responseCode = "400", description = "Please supply right field", content = @Content),
    })
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void addBook(@RequestBody Book book) {
         bookService.createBook(book);
    }

    @Operation(summary = "Get a book by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the book",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Book.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied", content = @Content),
            @ApiResponse(responseCode = "404", description = "Book not found", content = @Content)})

    @GetMapping("/{id}")
    public Book findBookById(@PathVariable Long id) {
        return bookService.findById(id);
    }

    @Operation(summary = "Update book by its id")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public Book updateBookById(@PathVariable("id") final long id, @RequestBody final Book book) {
        return bookService.updateBook(id, book);
    }
}
