package com.btuncer.services;

import com.btuncer.entities.Author;
import com.btuncer.entities.Book;
import com.btuncer.repositories.AuthorRepo;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class AuthorService {

    private final AuthorRepo authorRepo;

    public AuthorService(AuthorRepo authorRepo) {
        this.authorRepo = authorRepo;
    }

    public void authorOperation(){

        Author author = new Author();
        author.setName("Hüseyin Karabakla");

        Book book = new Book();
        book.setIsbn(UUID.randomUUID().toString());
        book.setName("Java App");


        authorRepo.save(author);

        System.out.println(authorRepo.findByName("Hüseyin"));


    }


}
