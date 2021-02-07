package com.btuncer.entities;


import javax.persistence.*;
import java.util.List;

@Entity

public class Author {

    @Id
    @GeneratedValue()
    private long id;
    private String name;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    @JoinTable(
            name = "author_book",
            joinColumns = @JoinColumn(name = "author_id"),
            inverseJoinColumns = @JoinColumn(name = "book_isbn"))
    private List<Book> registeredBook;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getRegisteredBook() {
        return registeredBook;
    }

    public void setRegisteredBook(List<Book> registeredBook) {
        this.registeredBook = registeredBook;
    }


    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}