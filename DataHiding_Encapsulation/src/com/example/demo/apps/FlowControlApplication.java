package com.example.demo.apps;

import com.example.demo.Professor;
import com.example.demo.services.PaymentService;

public class FlowControlApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Professor prof = new Professor(101, "Ramesh", "CS", "PG");
		
		
		PaymentService service = new PaymentService();
		
		double phdSalary = service .calculateSalary("phd");
		
		System.out.println("Phd Salary :="+ phdSalary);
		
		double pgSalary = service.calculateSalary(prof);
		
		System.out.println("PG Salary :="+ pgSalary);
	}

}
