package com.example.citybikeproject;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Station {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	String station_name;
	String station_address;
	String coordinate_x;
	String coordinate_y;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getStation_name() {
		return station_name;
	}
	public void setStation_name(String station_name) {
		this.station_name = station_name;
	}
	public String getStation_address() {
		return station_address;
	}
	public void setStation_address(String station_address) {
		this.station_address = station_address;
	}
	public String getCoordinate_x() {
		return coordinate_x;
	}
	public void setCoordinate_x(String coordinate_x) {
		this.coordinate_x = coordinate_x;
	}
	public String getCoordinate_y() {
		return coordinate_y;
	}
	public void setCoordinate_y(String coordinate_y) {
		this.coordinate_y = coordinate_y;
	}
	
}
