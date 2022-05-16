package br.com.springboot.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.springboot.apirest.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
  
}
