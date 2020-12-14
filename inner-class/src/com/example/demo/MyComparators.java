package com.example.demo;

import java.util.Comparator;
import java.util.Map;

public class MyComparators {

	public class EmployeeNameComparator implements Comparator<Employee>{
		
		@Override
		public int compare(Employee o1, Employee o2) {
		
			return o1.getName().compareTo(o2.getName());
		}
	}
	
	Map map;
	public class EmployeeIdComparator implements Comparator<Employee>{
		
		@Override
		public int compare(Employee o1, Employee o2) {
		
			if (o1.getId() < o2.getId()) return 1;
			if (o1.getId() > o2.getId()) return -1;
					 return 0;
		}
	}
}
