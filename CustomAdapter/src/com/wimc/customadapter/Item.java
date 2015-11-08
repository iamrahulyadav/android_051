package com.wimc.customadapter;

import java.io.Serializable;

public class Item implements Serializable{
String name;
float price;
int quantity;
String category;

public Item() {
	super();
}

public Item(String name, float price, int quantity, String category) {
	super();
	this.name = name;
	this.price = price;
	this.quantity = quantity;
	this.category = category;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public float getPrice() {
	return price;
}

public void setPrice(float price) {
	this.price = price;
}

public int getQuantity() {
	return quantity;
}

public void setQuantity(int quantity) {
	this.quantity = quantity;
}

public String getCategory() {
	return category;
}

public void setCategory(String category) {
	this.category = category;
}

@Override
public String toString() {
	return name+":"+price;
}

}
