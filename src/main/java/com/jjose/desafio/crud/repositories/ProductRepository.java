package com.jjose.desafio.crud.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.jjose.desafio.crud.domain.product.Product;
@Repository
public interface ProductRepository extends MongoRepository<Product, String>{


}
