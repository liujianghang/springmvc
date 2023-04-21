package com.example.controller;

import com.example.domin.Book;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

// 1 定义controller
// 使用@Component定义bean
@RestController
@RequestMapping("/book")
public class BookController {
    @PostMapping
    public String save(@RequestBody Book book) {
        System.out.println("book save ..." + book);
        return "{'Book':'save book success'}";
    }
    @GetMapping
    public List<Book> getAll() {
        List<Book> bookList = new ArrayList<Book>();
        Book book1 = new Book();
        book1.setName("123");
        book1.setType("123");
        book1.setDescription("132");
        Book book2 = new Book();
        book2.setName("123");
        book2.setType("123");
        book2.setDescription("132");
        bookList.add(book1);
        bookList.add(book2);
        return bookList;
    }
}
