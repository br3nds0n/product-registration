package br.com.springboot.apirest.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.springboot.apirest.models.Product;
import br.com.springboot.apirest.repository.ProductRepository;

@RestController
@RequestMapping(value = "/api")
public class ProductController {

  @Autowired
  ProductRepository productRepository;

  @PostMapping("/product")
  public Product create(@RequestBody Product product){
    return this.productRepository.save(product);
  }

  @GetMapping("/product")
  public List<Product> read(){
    return this.productRepository.findAll();
  }

  @GetMapping("/product/{id}")
  public Optional<Product> readId(@PathVariable(value = "id") Long id){
    return this.productRepository.findById(id);
  }

  @DeleteMapping("/product/{id}")
  public void delete(@PathVariable(value = "id") Long id){
    this.productRepository.deleteById(id);
  }
}
