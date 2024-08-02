package com.priyank.springDemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.priyank.springDemo.model.Product;
import com.priyank.springDemo.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
	
	public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }
	
	public Product addProduct(Product product) {
        return productRepository.save(product);
    }
	
	public Product updateProduct(Long id, Product productDetails) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
        product.setName(productDetails.getName());
        product.setType(productDetails.getType());
        product.setPlace(productDetails.getPlace());
        product.setWarranty(productDetails.getWarranty());
        return productRepository.save(product);
    }
	
	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
    }



}
