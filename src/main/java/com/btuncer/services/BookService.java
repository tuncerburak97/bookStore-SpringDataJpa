package com.btuncer.services;

import com.btuncer.entities.Author;
import com.btuncer.entities.Book;
import com.btuncer.repositories.BookRepo;
import com.btuncer.repositories.CategoryRepo;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Date;
import java.util.UUID;

@Component
public class BookService {

    private final BookRepo bookRepo;
    private final CategoryRepo categoryRepo;


    public BookService(BookRepo bookRepo, CategoryRepo categoryRepo) {
        this.bookRepo = bookRepo;
        this.categoryRepo = categoryRepo;
    }

    public void bookOperations(){

        Author author = new Author();
        author.setName("Max Planck");

        Book book = new Book();
        book.setIsbn(UUID.randomUUID().toString());
        book.setName("Computers");
        book.setPrice(25.14);
        book.setDescription("Tech");
        book.setCurrency("Dollars");
        book.setImageURL("www.computers.com");
        Date publishedDate = new Date();
        publishedDate.setYear(2000);
        publishedDate.setMonth(05);
        book.setPublishedDate(publishedDate);



        author.setRegisteredBook(Collections.singletonList(book));
        book.setAuthors(Collections.singletonList(author));

        bookRepo.save(book);

        System.out.println(bookRepo.findByName("Computers"));


    }

}
