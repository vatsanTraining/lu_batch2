package com.contacts;

import java.util.Scanner;

import com.contacts.services.MenuService;
import com.contacts.services.ReportService;

public class Application {


	public static void main(String[] args) {
		String equalsChar = "=";
		String underscoreChar = "_";
		MenuService contactMenuService = new MenuService();
		
		
		boolean isServiceDone;
		Scanner myObj = new Scanner(System.in);
		do {
			
			isServiceDone = false;
			System.out.println(equalsChar.repeat(250));
			System.out.println(ReportService.fixedLengthString("Main Menu", 70));
			System.out.println(equalsChar.repeat(250));
			
			System.out.println("Choose an option");
			System.out.println(underscoreChar.repeat(250));
			System.out.println("1. Add New Contact");
			System.out.println("2. Add Contacts from CSV File");
			System.out.println("3. Search Contacts");
			System.out.println("4. Update Contacts");
			System.out.println("5. Delete Contacts");
			System.out.println("6. Generate Special Reports");
			System.out.println("0. Exit Application");
			
			int option = myObj.nextInt();
			
			switch (option) {
			case 1:
				System.out.println(equalsChar.repeat(250));
				System.out.println(ReportService.fixedLengthString("Add Contact", 70));
				System.out.println(equalsChar.repeat(250));
				isServiceDone = contactMenuService.addContactMenu(myObj);
				break;
				
			case 2:
				System.out.println(equalsChar.repeat(250));
				System.out.println(ReportService.fixedLengthString("Add Contact from CSV", 70));
				System.out.println(equalsChar.repeat(250));
				isServiceDone = contactMenuService.addContactsFromCSV(myObj);
				break;	
				
			case 3:
				System.out.println(equalsChar.repeat(250));
				System.out.println(ReportService.fixedLengthString("Search Contacts", 70));
				System.out.println(equalsChar.repeat(250));
				isServiceDone = contactMenuService.searchContactMenu(myObj);
				break;	
			
			case 4:
				System.out.println(equalsChar.repeat(250));
				System.out.println(ReportService.fixedLengthString("Update Contacts", 70));
				System.out.println(equalsChar.repeat(250));
				isServiceDone = contactMenuService.updateContactMenu(myObj);
				break;		

			case 5:
				System.out.println(equalsChar.repeat(250));
				System.out.println(ReportService.fixedLengthString("Delete Contacts", 70));
				System.out.println(equalsChar.repeat(250));
				isServiceDone = contactMenuService.deleteContactMenu(myObj);
				break;	
			
			case 6:
				System.out.println(equalsChar.repeat(250));
				System.out.println(ReportService.fixedLengthString("Special Reports", 70));
				System.out.println(equalsChar.repeat(250));
				isServiceDone = contactMenuService.reportGenerateMenu(myObj);
				break;		
				
			default:
				System.out.println(equalsChar.repeat(250));
				System.out.println("Are you sure you want to exit? (Y/N)");
				String exitOption = myObj.next();
				if(exitOption.equalsIgnoreCase("Y")) {
					System.out.println("Closing application...");
					System.exit(0);
				} else {
					isServiceDone = true;
				}
				break;
			}
			
			
		} while (isServiceDone);
		
		System.out.println("Done!");
		myObj.close();

		
	}
}
