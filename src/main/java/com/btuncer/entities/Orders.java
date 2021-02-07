package com.btuncer.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Orders {


    @Id
    @GeneratedValue()
    private int id;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User users;


    private double total;


    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(
            name = "order_book",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "book_isbn"))
    private Set<Book> orderedBook=new HashSet<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Set<Book> getOrderedBook() {
        return orderedBook;
    }

    public void setOrderedBook(Set<Book> orderedBook) {
        this.orderedBook = orderedBook;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", users=" + users +
                ", total=" + total +
                ", orderedBook=" + orderedBook +
                '}';
    }
}