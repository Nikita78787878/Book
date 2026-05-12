package org.example.book.exception;


//TODO Плохо понимаю, пронать более развернуто !!!
public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(String bookNotFound) {
        super(bookNotFound);
    }
}
