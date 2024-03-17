package com.ex.CurdOperation.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Product {
	@Id
	int pid;
	String pName;
	public Product() {
		
	}
	public Product(int pid, String pName) {
		super();
		this.pid = pid;
		this.pName = pName;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pName=" + pName + "]";
	}
	
	
	

}
