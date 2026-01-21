package com.miniamazon.backend.repository;

import com.miniamazon.backend.model.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRepository  extends MongoRepository<Category, String>{

    boolean existsByName(String name);
}
