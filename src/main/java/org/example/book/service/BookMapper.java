package org.example.book.service;

import org.example.book.dto.BookDto;
import org.example.book.entity.Book;

public class BookMapper {

    public static BookDto toDto(Book book){
        return new BookDto(book.getTitle(), book.getAuthor());
    }

    public static Book toEntity(BookDto bookDto){
        return new Book(bookDto.title(), bookDto.author());
    }
}
