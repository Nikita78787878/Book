package org.example.book.service;

import org.example.book.dto.BookDto;
import org.example.book.dto.UpdateBookDto;
import org.example.book.exception.BookNotFoundException;
import org.example.book.entity.Book;
import org.example.book.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {
    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;

    }

    public BookDto findById(Long id){
        if(id == null) throw new IllegalArgumentException("id is null");

        Book book = repository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book not found"));

        return BookMapper.toDto(book);
    }

    public BookDto saveBook(BookDto dto) {
        Book book = BookMapper.toEntity(dto);
        Book bookSave = repository.save(book);
        return  BookMapper.toDto(bookSave);
    }

    public List<BookDto> findAll() {
        return repository.findAll().stream().map(BookMapper::toDto).collect(Collectors.toList());
    }

    public BookDto updateBook(UpdateBookDto updateBookDto) {
        Book oldBook = repository.findById(updateBookDto.id()).orElseThrow(() -> new BookNotFoundException("Book not found"));

        oldBook.setTitle(updateBookDto.title());
        oldBook.setAuthor(updateBookDto.author());
        Book saved = repository.save(oldBook);
        return BookMapper.toDto(saved);
    }

    public void deleteBook(Long id) {
        repository.deleteById(id);
    }

}
