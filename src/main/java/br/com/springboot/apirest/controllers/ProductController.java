package br.com.springboot.apirest.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
  public Product create(@RequestBody @Valid Product product) throws Exception {

    if(product.getQuantidade() == null) { throw new Exception("Quantidade not null");} 
    if(product.getNome() == null) { throw new Exception("Nome not null");} 
    if(product.getValor() == null) { throw new Exception("Valor not null"); }
    else { return this.productRepository.save(product); }

  }

  @GetMapping("/product")
  public List<Product> read(){
    return this.productRepository.findAll();
  }

  @GetMapping("/product/{id}")
  public Optional<Product> readId(@PathVariable(value = "id") Long id){
    return this.productRepository.findById(id);
  }

  @PutMapping("/product/{id}")
  public Product update(@PathVariable("id") Long id, @RequestBody @Valid Product product) throws Exception {
    Optional<Product> oldProduct = this.productRepository.findById(id);

    Product newProduct = oldProduct.get();

    newProduct.setNome(product.getNome());
    newProduct.setQuantidade(product.getQuantidade());
    newProduct.setValor(product.getValor());

    if(product.getQuantidade() == null) { throw new Exception("Quantidade not null");} 
    if(product.getNome() == null) { throw new Exception("Nome not null");} 
    if(product.getValor() == null) { throw new Exception("Valor not null"); }
    else { return this.productRepository.save(newProduct); }
    
  }

  @DeleteMapping("/product/{id}")
  public void delete(@PathVariable(value = "id") Long id){
    this.productRepository.deleteById(id);
  }
}
