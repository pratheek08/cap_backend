package com.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.model.Product;
import com.shop.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired 
	private ProductRepository productRepo;
	
	@Override
	public Product saveProduct(Product product) {
		return productRepo.save(product);
	}

	@Override
	public List<Product> getAllProduct() {
		return productRepo.findAll();
	}

	@Override
	public Product getProductById(Integer id) {
		return productRepo.findById(id).get(); 
	}

	@Override
	public String deleteProduct(Integer id) {
		Product product = productRepo.findById(id).get();
		
		if(product != null) {
			productRepo.delete(product);
			return "Product deleted successfully";
		}
		
		return "something went wrong";
	}

	@Override
	public Product editProduct(Product p, Integer id) {

		Product oldProduct = productRepo.findById(id).get();

		oldProduct.setProductName(p.getProductName());
		oldProduct.setDescription(p.getDescription());
		oldProduct.setPrice(p.getPrice());
		oldProduct.setStatus(p.getStatus());

		return productRepo.save(oldProduct);
	}
}
