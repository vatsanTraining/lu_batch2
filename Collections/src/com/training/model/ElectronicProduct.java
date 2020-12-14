package com.training.model;

public class ElectronicProduct extends Product {

	
	private int warrantyMonth;

	public ElectronicProduct() {
		// TODO Auto-generated constructor stub
	}

	public ElectronicProduct(int id, String name, double ratePerUnit) {
		super(id, name, ratePerUnit);
		// TODO Auto-generated constructor stub
	}

	public ElectronicProduct(int id, String name, double ratePerUnit, int warrantyMonth) {
		super(id, name, ratePerUnit);
		this.warrantyMonth = warrantyMonth;
	}

	public int getwarrantyMonth() {
		return warrantyMonth;
	}

	public void setwarrantyMonth(int warrantyMonth) {
		this.warrantyMonth = warrantyMonth;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + warrantyMonth;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ElectronicProduct other = (ElectronicProduct) obj;
		if (warrantyMonth != other.warrantyMonth)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return super.toString() +"ElectronicProduct [warrantyMonth=" + this.warrantyMonth + "]";
	}
	
	
	
}
