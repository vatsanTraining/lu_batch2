package com.training.model;

public class FoodProduct extends Product {

	
	private String shelfLife;

	public FoodProduct() {
		// TODO Auto-generated constructor stub
	}

	public FoodProduct(int id, String name, double ratePerUnit) {
		super(id, name, ratePerUnit);
		// TODO Auto-generated constructor stub
	}

	public FoodProduct(int id, String name, double ratePerUnit, String shelfLife) {
		super(id, name, ratePerUnit);
		this.shelfLife = shelfLife;
	}

	public String getShelfLife() {
		return shelfLife;
	}

	public void setShelfLife(String shelfLife) {
		this.shelfLife = shelfLife;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((shelfLife == null) ? 0 : shelfLife.hashCode());
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
		FoodProduct other = (FoodProduct) obj;
		if (shelfLife == null) {
			if (other.shelfLife != null)
				return false;
		} else if (!shelfLife.equals(other.shelfLife))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return super.toString()+"FoodProduct [shelfLife=" + shelfLife + "]";
	}
	
	
}
