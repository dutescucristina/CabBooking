package com.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "booking")
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
	@SequenceGenerator(name = "sequenceGenerator", allocationSize = 1)
	private int id;
	@Column(name = "location_id")
	private int locationId;
	@Column(unique = true)
	private String email;
	@Column(name = "type_of_cab", nullable = false)
	private int typeOfCab;

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public int getTypeOfCab() {
	return typeOfCab;
}
public void setTypeOfCab(int typeOfCab) {
	this.typeOfCab = typeOfCab;
}

	@java.lang.Override
	public java.lang.String toString() {
		return "Booking{" +
				"id=" + id +
				", locationId=" + locationId +
				", email=" + email +
				", typeOfCab=" + typeOfCab +
				'}';
	}
}