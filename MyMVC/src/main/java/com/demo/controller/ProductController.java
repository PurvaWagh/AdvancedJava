package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.model.Product;
import com.demo.service.ProductService;
import com.demo.service.ProductServiceImpl;

@Controller
@RequestMapping("/product")
public class ProductController {
	@Autowired
	ProductService ps= new ProductServiceImpl();
	
	@GetMapping("/products")
	public ModelAndView getall()
	{
		List<Product> plist=ps.getallproduct();
		return new ModelAndView("displayproduct","plist",plist);
		
	}
	@GetMapping("/addproduct")
	public String displayaddform() {
		return "addproduct";
	}
	@PostMapping("/insertProduct")
	public ModelAndView insert(@RequestParam int pid,@RequestParam String pname,@RequestParam int qty,@RequestParam double price) {
		Product p=new Product(pid,pname,qty,price);
		ps.add(p);
		return new ModelAndView("redirect:/product/products");
	}
	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable int id) {
		Product p=ps.getbyid(id);
		return new ModelAndView("editProduct","p",p);
	}
	@PostMapping("/updateProduct")
	public ModelAndView update(@RequestParam int pid,@RequestParam String pname,@RequestParam int qty,@RequestParam double price) {
		Product p=new Product(pid,pname,qty,price);
		ps.update(p);
		return new ModelAndView("redirect:/product/products");
	}
	@GetMapping("/delete/{id}")
	public ModelAndView deleteproduct(@PathVariable int id) {
		Product p=ps.getbyid(id);
		ps.delete(id);
		return new ModelAndView("redirect:/product/products");
	}
	

}
