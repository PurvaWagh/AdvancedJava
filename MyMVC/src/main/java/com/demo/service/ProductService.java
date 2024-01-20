package com.demo.service;

import java.util.List;

import com.demo.model.Product;

public interface ProductService {

	List<Product> getallproduct();

	void add(Product p);

	Product getbyid(int id);

	void update(Product p);

	void delete(int id);

}
