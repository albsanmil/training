package com.training.collections;

import com.training.collections.exception.BookNotFoundException;
import com.training.collections.model.Book;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CollectionsApplication {

    public static void main(String[] args) {
        // Example with a list of integers
        List<Integer> numbers = new ArrayList<>(10);

        numbers.add(1);
        numbers.add(5);
        numbers.add(8);

        System.out.println(ListUtil.maximum(numbers));

        // Example with a list of books
        Book isbn1a = new Book("ISBN1", "The Shepherd’s Hut", "Tim Winton");
        Book isbn1b = new Book("ISBN1", "The Shepherd’s Hut", "Tim Winton");
        Book isbn2 = new Book("ISBN2", "The Queen of Bloody Everything", "Joanna Nadin");
        Book isbn3 = new Book("ISBN3", "The Only Story", "Julian Barnes");

        List<Book> books = new ArrayList<>();
        books.add(isbn1a);
        books.add(isbn2);
        books.add(isbn3);
        System.out.println(books);

        try {
            BookSearcher bookSearcher = new BookSearcher();
            Book secondBook = bookSearcher.searchByIsbn(books, "isbn2");
            System.out.println(secondBook);

            Book nonExistingBook = bookSearcher.searchByIsbn(books, "isbn50");
            System.out.println(nonExistingBook);
        }
        catch (BookNotFoundException e) {
            System.out.println(e.getMessage());
        }

        // Example with set of integers
        Set<Integer> integersSet = new HashSet<>();
        integersSet.add(new Integer(5));
        integersSet.add(new Integer(5));
        integersSet.add(5);
        integersSet.add(7);
        System.out.println(integersSet);

        // Example with a set of books
        Set<Book> booksSet = new HashSet<>();
        booksSet.add(isbn1a);
        booksSet.add(isbn1b);
        booksSet.add(isbn2);
        booksSet.add(isbn3);
        System.out.println(booksSet);

        if (isbn1a.equals(isbn1b)) {
            System.out.println("Both objects (isbn1a and isbn1b) are pointed to the same real book");
        }
    }
}
