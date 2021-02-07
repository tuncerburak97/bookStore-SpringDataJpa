package com.btuncer.repositories;

import com.btuncer.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepo extends CrudRepository<User, Integer> {

    User findByName(String name);

    List<User> findAllByNameContainingIgnoreCase(String name);

    List<User> findAllByIdLessThanAndName(Integer id, String name);
}
