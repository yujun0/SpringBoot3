package com.example.problemdetail.controller;

import com.example.problemdetail.config.BookContainer;
import com.example.problemdetail.exp.BookNotFoundException;
import com.example.problemdetail.exp.IsbnNotFoundException;
import com.example.problemdetail.model.Book;
import jakarta.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class BookController {
    @Resource
    private BookContainer bookContainer;

    @GetMapping("/book")
    public Book getBook(String isbn) {
        Optional<Book> book = bookContainer.getBooks().stream()
                .filter(e1 -> e1.isbn().equals(isbn))
                .findFirst();
        if (book.isEmpty()) {
//            throw new BookNotFoundException("isbn: " + isbn + " -> 沒有此圖書");
            throw new IsbnNotFoundException(HttpStatus.NOT_FOUND, "isbn: " + isbn + " -> 沒有此圖書");
        }
        return book.get();
    }

}
