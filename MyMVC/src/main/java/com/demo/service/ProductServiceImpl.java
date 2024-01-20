package com.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.ProductDao;
import com.demo.model.Product;

@Service
public class ProductServiceImpl implements ProductService {
 @Autowired
 ProductDao pdao;

@Override
public List<Product> getallproduct() {
	
	return pdao.findAll() ;
}

@Override
public void add(Product p) {
	pdao.save(p);
	
}

@Override
public Product getbyid(int id) {
	// TODO Auto-generated method stub
	Optional<Product>op=pdao.findById(id);
	if(op.isPresent()) {
		return op.get();
	}
	return null;
}

@Override
public void update(Product p) {
	Optional<Product>op=pdao.findById(p.getPid());
	if(op.isPresent()) {
		Product p1=op.get();
		p1.setPid(p.getPid());
		p1.setPname(p.getPname());
		p1.setQty(p.getQty());
		p1.setPrice(p.getPrice());
		pdao.save(p1);
	}
	
}

@Override
public void delete(int id) {
	pdao.deleteById(id);
}
}
