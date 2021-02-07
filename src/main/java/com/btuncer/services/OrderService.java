package com.btuncer.services;


import com.btuncer.entities.*;
import com.btuncer.repositories.OrdersRepo;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Date;
import java.util.UUID;

@Component
public class OrderService {

    private final OrdersRepo ordersRepo;


    public OrderService(OrdersRepo ordersRepo) {
        this.ordersRepo = ordersRepo;
    }

    public void orderOperations(){

        Author author = new Author();
        author.setName("Hüseyin Karabakla");
        author.setId(1);

        //book op

        Book book = new Book();

        book.setName("JavaApp");
        book.setIsbn(UUID.randomUUID().toString());
        book.setDescription("Software");
        book.setPrice(20.56);
        book.setImageURL("http://java.com");
        book.setCurrency("Tl");
        Date publishedDate=new Date();
        publishedDate.setYear(2015);
        publishedDate.setMonth(11);
        book.setPublishedDate(publishedDate);

        book.setAuthors(Collections.singletonList(author));
        //categoryOperation
        Category category = new Category();
        category.setName("Science");
        category.setBooks(Collections.singletonList(book));

        author.setRegisteredBook(Collections.singletonList(book));

        //user operation

        User user = new User();
        user.setName("Burak Tuncer");

        Address address = new Address();

        address.setCity("Ankara");
        address.setNumber("3");
        address.setZipcode(06564);
        address.setStreet("Gülhane");

        user.setAddress(address);

        //order op

        Orders order = new Orders();

        order.setUsers(user);

        order.setTotal(56.45);
        order.getOrderedBook().add(book);
        book.getOrders().add(order);

        ordersRepo.save(order);

        System.out.println("User: "+user.getName()+" orders and informations ="+ ordersRepo.findByUsersName("Burak Tuncer"));




    }
}
