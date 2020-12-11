package com.exercise;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.exercise.model.BloodDonor;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HashMap<String,List<BloodDonor>> bloodDonors = new HashMap<>();
		
		BloodDonor donor1 = new BloodDonor(100, "Shreyas" , 22 , "bpos");
		BloodDonor donor2 = new BloodDonor(101, "Nayak" , 22 , "bpos");
		BloodDonor donor3 = new BloodDonor(102, "Blah" , 28 , "apos");
		BloodDonor donor4 = new BloodDonor(103, "Blah1" , 25 , "opos");
		BloodDonor donor5 = new BloodDonor(104, "Blah2" , 23 , "bpos");
		BloodDonor donor6 = new BloodDonor(105, "Blah3" , 27 , "apos");
		BloodDonor donor7 = new BloodDonor(106, "Blah4" , 22 , "apos");
		BloodDonor donor8 = new BloodDonor(107, "Blah5" , 20 , "opos");
		
		
		List<BloodDonor> aposDonors = Arrays.asList(donor3,donor6, donor7);
		List<BloodDonor> bposDonors = Arrays.asList(donor1,donor2, donor5);
		List<BloodDonor> oposDonors = Arrays.asList(donor4,donor8);
		
		bloodDonors.put("A-Positive", aposDonors);
		bloodDonors.put("B-Positive", bposDonors);
		bloodDonors.put("O-Positive", oposDonors);
		
		Set<Map.Entry<String,List<BloodDonor>>> donorsSet = bloodDonors.entrySet();
		
		for(Map.Entry<String, List<BloodDonor>> eachGroup : donorsSet) {
			System.out.println("List of Donors with Blood group "+eachGroup.getKey());
			
			for(BloodDonor donor : eachGroup.getValue()) {
				System.out.println(donor.toString());
			}
		}
		
		
		
	}

}
