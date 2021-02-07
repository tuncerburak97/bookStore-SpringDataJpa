package com.btuncer.repositories;

import com.btuncer.entities.Author;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface AuthorRepo extends CrudRepository<Author,Integer> {

    public Set<Author> findByName(String name);

}
