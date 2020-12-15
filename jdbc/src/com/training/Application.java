package com.training;

import java.time.LocalDate;
import java.time.Month;

import com.training.daos.DoctorDaoImpl;
import com.training.entity.Doctor;
import com.training.ifaces.DataAccess;
import com.training.utils.DbConnectionUtil;

public class Application {

	public static void main(String[] args) {

        int  key=4;
         
        DataAccess<Doctor> dao = new DoctorDaoImpl();
         
		switch (key) {
		case 1:
			Doctor doc = new Doctor(103, "Gaurav", 744422100, "Ortho", 
					    LocalDate.of(1971, Month.JULY, 21));
			int rowAdded =dao.add(doc);
			System.out.println("Row Added :="+ rowAdded);
			break;
		case 2:
			  dao.findAll().stream().forEach(System.out::println);
			break;
		case 3:
			Doctor doc1 = new Doctor(106, "Nikkil", 644422100, "Pede", 
				    LocalDate.of(1972, Month.JUNE, 23));
			Doctor doc2 = new Doctor(107, "Vicky", 544452100, "Eye", 
				    LocalDate.of(1978, Month.DECEMBER, 21));
             int[] result =dao.addInBatch(doc1,doc2);
             
             for(int resp : result)
             {
            	 System.out.println(resp);
             }
			break;
		case 4:
			DoctorDaoImpl dao2=(DoctorDaoImpl)dao;
			 dao2.usingTransaction();
		default:
			break;
		}
	}
	

}
