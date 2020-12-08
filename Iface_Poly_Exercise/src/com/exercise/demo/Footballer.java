package com.exercise.demo;

import com.exercise.iface.Billable;

public class Footballer implements Billable {

	@Override
	public double calculate() {
		// TODO Auto-generated method stub
		
		double salary = 100000.00;
		
		if((this.playerPosition).equals("Goalkeeper")) {
			salary=80000.00;
		}else if((this.playerPosition).equals("Defender")) {
			salary=60000.00;			
		}else if((this.playerPosition).equals("Midfielder")) {
			salary=70000.00;
		}
		return salary;
	}
	
	@Override
	public void printCalculate() {
		// TODO Auto-generated method stub
		
		double salary = this.calculate();
		
		System.out.println(this.playerName + " with the job of "+ this.playerPosition +" earns Rs."+salary);
	}
	
	private String playerPosition;
	private String playerName;
	
	
	public Footballer(String playerPosition, String playerName) {
		super();
		this.playerPosition = playerPosition;
		this.playerName = playerName;
	}


	public String getPlayerPosition() {
		return playerPosition;
	}


	public void setPlayerPosition(String playerPosition) {
		this.playerPosition = playerPosition;
	}


	public String getPlayerName() {
		return playerName;
	}


	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}



	
	
	
	

}
