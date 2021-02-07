package com.btuncer.services;

import com.btuncer.entities.Author;
import com.btuncer.entities.Book;
import com.btuncer.entities.Category;
import com.btuncer.repositories.CategoryRepo;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.UUID;


import java.util.Date;

@Component
public class CategoryService {

    private final CategoryRepo categoryRepo;

    public CategoryService(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    public void categoryOperations() {

        Book b1 = new Book();
        Date date = new Date();
        b1.setIsbn(UUID.randomUUID().toString());
        b1.setName("Spring in Action");
        b1.setCurrency("Tl");
        b1.setDescription("Education");
        b1.setImageURL("www.image.com");
        b1.setPrice(45.45);
        Date publishedDate = new Date();
        publishedDate.setYear(2018);
        publishedDate.setMonth(11);
        b1.setPublishedDate(publishedDate);


        Author author = new Author();
        author.setName("Burak Tuncer");

        b1.setAuthors(Collections.singletonList(author));

        Category c1 = new Category();
        c1.setName("Computer Science");
        c1.setBooks(Collections.singletonList(b1));

        categoryRepo.save(c1);

        System.out.println(c1);
    }
}
