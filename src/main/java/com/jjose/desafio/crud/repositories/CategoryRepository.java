package com.jjose.desafio.crud.repositories;

import com.jjose.desafio.crud.domain.category.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRepository extends MongoRepository<Category, String>{


}
