package br.com.springboot.apirest.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.springboot.apirest.models.Product;
import br.com.springboot.apirest.repository.ProductRepository;

@RestController
@RequestMapping(value = "/api")
public class ProductController {

  @Autowired
  ProductRepository productRepository;

  @GetMapping("/product")
  public List<Product> read(){
    return this.productRepository.findAll();
  }
}
