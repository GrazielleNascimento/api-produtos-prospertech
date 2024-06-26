package com.prospertech.apirestprodutos.repository;

import com.prospertech.apirestprodutos.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {


}
