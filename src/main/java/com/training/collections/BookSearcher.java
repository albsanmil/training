package com.training.collections;

import com.training.collections.exception.BookNotFoundException;
import com.training.collections.model.Book;

import java.util.List;

public class BookSearcher {

    public Book searchByIsbn(List<Book> books, String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn.toUpperCase())) {
                return book;
            }
        }
        throw new BookNotFoundException("Could not find the book which ISBN is \'" + isbn + "\'");
    }
}
