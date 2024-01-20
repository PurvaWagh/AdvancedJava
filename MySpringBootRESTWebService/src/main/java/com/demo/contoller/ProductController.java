package com.demo.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.model.Product;
import com.demo.service.ProductServiceImpl;

@Controller
@RequestMapping("/product")
public class ProductController {
	@Autowired
	ProductServiceImpl ps;
	
	
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getproducts(){
		List<Product>plist=ps.getallproduct();
		return ResponseEntity.ok(plist);
	}
	
	@GetMapping("/products/{pid}")
	public ResponseEntity<Product>getbyid(@PathVariable int pid){
		Product p=ps.getbyid(pid);
		if(p!=null) {
			return ResponseEntity.ok(p);
		}
		else
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@PostMapping("/products/{pid}")
	public ResponseEntity<String>addproduct(@RequestBody Product p){
		ps.add(p);
		return ResponseEntity.ok("data added successfully");
		
	}
	@PutMapping("/products/{pid}")
	public ResponseEntity<String>update(@RequestBody Product p){
		ps.update(p);
		return ResponseEntity.ok("data updated successfully");
	}
	
	@DeleteMapping("/products/{pid}")
	public ResponseEntity<String>delete(@PathVariable int pid){
		ps.delete(pid);
		return ResponseEntity.ok("data deleted successfully");
	}

}
