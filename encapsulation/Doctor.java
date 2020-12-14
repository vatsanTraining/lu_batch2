package com.example.demo;

public class Doctor{

   // SEGMENT -1  => ATTRIBUTES
   private int doctorId;

   //private Integer doctorId;

   private String doctorName;
   
   // SEGMENT-2    => CONSTRUCTOR
   // METHOD WITH SAME NAME AS THE CLASS NAME BUT WITHOUT RETURN TYPE
    public Doctor(){
         
     }

    // SEGMENT -3 METHODS

  // MODIFIER RETURNTYPE: VOID NAME ( ARGUMENTS)

   public void setDoctorId(int id ){
       
     if(id<=0){
          System.out.println("invalid value -should be positive integer");
         } else {
        doctorId = id;
        }
    }

  // MODIFIER RETURNTYPE:INT NAME ( ARGUMENTS)

    public int getDoctorId(){
         return doctorId;
  }
}