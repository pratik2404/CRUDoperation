package com.ex.CurdOperation.controller;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ex.CurdOperation.entity.Category;
import com.ex.CurdOperation.entity.Product;

@RestController
public class MainController {

	@Autowired
	SessionFactory sf;

	@RequestMapping("test") //for testing purpose
	public String test() {
		return "Test";

	}
	
//	Category

	@GetMapping("getAllCategory")
	public List<Category> getAll() {
		Session s = sf.openSession();
		Query query = s.createQuery("from Category");
		List<Category> list = query.list();
		return list;
	}

	@PostMapping("insertCategory")
	public void insrtCategory(@RequestBody Category cat) {
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		s.persist(cat);
		t.commit();
	}

	@GetMapping("getCategory/{id}")
	public Category getSingleCat(@PathVariable int id) {
		Session s = sf.openSession();
		Category c = s.get(Category.class, id);
		return c;
	}

	@DeleteMapping("deleteOneCategory/{id}")
	public int deleteCategory(@PathVariable int id) {
		Session ss = sf.openSession();
		Transaction tx = ss.beginTransaction();
		Category cat1 = ss.load(Category.class, id);
		ss.remove(cat1);
		System.out.println("Record Deleted Successfully Done... " + id);
		tx.commit();
		return id;
	}

	// Product

	@GetMapping("getAllProduct")
	public List<Product> getAllProduct() {
		Session s = sf.openSession();
		Query query = s.createQuery("from Product");
		List<Product> list = query.list();
		return list;
	}

	@PostMapping("insertProduct")
	public void insrtProduct(@RequestBody Product pro) {
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		s.persist(pro);
		t.commit();

	}
	@GetMapping("getProduct/{id}")
	public Product getSinglePro(@PathVariable int id) {
	Session s = sf.openSession();
	Product p = s.get(Product.class, id);
	return p;
	}
	
	
	@DeleteMapping("deleteOnePro/{id}")
	public int deleteProduct(@PathVariable int id) {
	Session ss = sf.openSession();
	Transaction tx = ss.beginTransaction();
	Product Pro1 = ss.load(Product.class, id);
	ss.remove(Pro1);
	System.out.println("Record Deleted Successfully Done... " + id);
	tx.commit();
	return id;
	}

}
