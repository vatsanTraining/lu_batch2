package com.example.demo.apps;

import java.util.*;
import com.example.demo.Professor;
import com.example.demo.services.PaymentService;

public class FlowControlApplication  {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Professor prof = new Professor(101, "Ramesh", "CS", "PG");
		
		
		PaymentService service = new PaymentService();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the qualification");
		
		String qual = sc.next();
		
		double phdSalary = service .calculateSalary(qual);
		
		System.out.println(qual+ " Salary :="+ phdSalary);
		
		double pgSalary = service.calculateSalary(prof);
		
		System.out.println("PG Salary :="+ pgSalary);
		
		sc.close();
	}

}
