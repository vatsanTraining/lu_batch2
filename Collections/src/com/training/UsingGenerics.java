package com.training;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.training.model.ElectronicProduct;
import com.training.model.FoodProduct;
import com.training.model.Product;
import com.training.services.CatalogService;

public class UsingGenerics {

	
	public static void pushAndPull(List<? super Product> list,Product prod) {
		
		System.out.println(list.add(prod));
		System.out.println(list.get(1));
		
	}
	
       public static void onlyPullNotPush(List<? extends ElectronicProduct> list,Product prod) {
		
		//System.out.println(list.add(prod));
		System.out.println(list.get(1));
	}
       
       
	public static void main(String[] args) {

		
		CatalogService service =new CatalogService();
		
		
		 
		Product panner = new FoodProduct(1010, "panner", 20.00,"5days");
		
		Product tv  = new ElectronicProduct(4848, "Sony LED Tv", 45000,24);
		
		ElectronicProduct tv2  = new ElectronicProduct(4847, "Samsung LED Tv", 42000,24);
		
		service.add(tv);
		
		service.add(panner);
		
		// service.add(new String("sfsdfds"));
		

		List<Product> list =  service.getAll();

		List<ElectronicProduct> list2=new ArrayList<>();
		
		// push(list,tv2);
		
	    pushAndPull(list,tv2);
	    

	     System.out.println(list);
		
	
	     onlyPullNotPush(list2, tv2);
	     
	     onlyPullNotPush(list2, tv);
	     
	     
	}

}
