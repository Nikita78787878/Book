package org.example.book.controller;

import org.example.book.dto.BookDto;
import org.example.book.dto.UpdateBookDto;
import org.example.book.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookService service;

    public BookController(BookService bookService) {
        this.service = bookService;
    }

    @GetMapping()
    public ResponseEntity<List<BookDto>> getAllBooks(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDto> getBookById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }


    @PostMapping
    @Transactional
    public ResponseEntity<BookDto> createBook(@RequestBody BookDto dto){
        return ResponseEntity
                .status(201)
                .body(service.saveBook(dto));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<BookDto> updateBook(@RequestBody UpdateBookDto book){
        return ResponseEntity.ok(service.updateBook(book));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> deleteBook(@PathVariable Long id){
        service.deleteBook(id);
        return ResponseEntity.noContent().build();

    }
}
