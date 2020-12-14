package com.example.demo;


public class Application{


   public static void main(String args[]){

      Doctor ramesh= new Doctor();
    
           ramesh.setDoctorId(1010);

       int  doctorId = ramesh.getDoctorId();

       System.out.println(doctorId);

      Doctor suresh=new Doctor();
    
           suresh.setDoctorId(2010);

       int  doctorId2 = suresh.getDoctorId();

       System.out.println(doctorId2);

}



}