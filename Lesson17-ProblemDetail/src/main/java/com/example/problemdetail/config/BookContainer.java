package com.example.problemdetail.config;

import com.example.problemdetail.model.Book;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@Setter
@Getter
@ConfigurationProperties(prefix = "product")
public class BookContainer {
    private List<Book> books;
}
