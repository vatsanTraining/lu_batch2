package com.training.services;

import java.util.*;
import com.training.model.*;
public class CatalogService{

	
	private List<Product> catalog;

	public CatalogService() {
		
		this.catalog = new ArrayList<>();
	}
	
	public boolean add(Product product) {
		
		return this.catalog.add(product);
	}
	
	public List<Product> getAll(){
		
		return this.catalog;
	}
	
	
}
