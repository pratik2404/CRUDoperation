package com.ex.CurdOperation.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Category {
	@Id
	private int categoryId;
	private String categoryName;
	private String description;
	
	@OneToMany
	@JoinColumn
	List<Product> listProduct;

	public Category() {
	}

	
	public Category(int categoryId, String categoryName, String description, List<Product> listProduct) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.description = description;
		this.listProduct = listProduct;
	}
	

	public List<Product> getListProduct() {
		return listProduct;
	}


	public void setListProduct(List<Product> listProduct) {
		this.listProduct = listProduct;
	}


	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Category{" + "categoryId=" + categoryId + ", categoryName='" + categoryName + '\'' + ", description='"
				+ description + '\'' + '}';
	}
}
