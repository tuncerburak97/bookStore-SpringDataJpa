package com.btuncer.repositories;

import com.btuncer.entities.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepo extends CrudRepository<Category, Integer> {
    public Category findCategoryById(int id);
}
