package com.miniamazon.backend.repository;

import com.miniamazon.backend.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product, String> {

    List<Product> findByCategories(String categoryId);
}
