package com.training.services;

public class Transaction implements Comparable<Transaction>{

	private int txnId;
	private String description;
	private double amount;
	
	public Transaction() {
		}
	
	public Transaction(int txnId, String description, double amount) {
		super();
		this.txnId = txnId;
		this.description = description;
		this.amount = amount;
	}
	public int getTxnId() {
		return txnId;
	}
	public void setTxnId(int txnId) {
		this.txnId = txnId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + txnId;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (txnId != other.txnId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Transaction [txnId=" + txnId + ", description=" + description + ", amount=" + amount + "]";
	}
	@Override
	public int compareTo(Transaction other) {
     if(this.txnId < other.txnId) return -1;
     if(this.txnId > other.txnId) return 1;
     
		return 0;
	}
	
	
}
