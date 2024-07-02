package com.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Location {
@Id

private int id;
@Column(name = "from_location", length = 100, nullable = false)
private String fromLocation;
@Column(name = "to_location", length = 100, nullable = false)
private String toLocation;
private int price;

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getFromLocation() {
	return fromLocation;
}
public void setFromLocation(String fromLocation) {
	this.fromLocation = fromLocation;
}
public String getToLocation() {
	return toLocation;
}
public void setToLocation(String toLocation) {
	this.toLocation = toLocation;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}

}