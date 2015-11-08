package com.example.assignxmlparsing;

public class Breakfast {

	String name, price, description, calories;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCalories() {
		return calories;
	}

	public void setCalories(String calories) {
		this.calories = calories;
	}

	

	@Override
	public String toString() {
		return name + "," + price;
	}

	public Breakfast(String name, String price, String description,
			String calories) {
		super();
		this.name = name;
		this.price = price;
		this.description = description;
		this.calories = calories;
	}

}
