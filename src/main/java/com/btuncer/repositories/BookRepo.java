package com.btuncer.repositories;

import com.btuncer.entities.Book;
import org.springframework.data.repository.CrudRepository;
import java.util.*;

public interface BookRepo extends CrudRepository<Book,String> {

    public List<Book> findByName(String name);

}
