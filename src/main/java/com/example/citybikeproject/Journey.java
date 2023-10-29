package com.example.citybikeproject;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Journey {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	String departure_date_time;
	String return_date_time;
	
	@ManyToOne
    @JoinColumn(name = "departure_station_id", referencedColumnName = "id")
    private Station departureStation;

    @ManyToOne
    @JoinColumn(name = "return_station_id", referencedColumnName = "id")
    private Station returnStation;
    
    private Integer distance = null; 
    private Integer duration = null;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDeparture_date_time() {
		return departure_date_time;
	}
	public void setDeparture_date_time(String departure_date_time) {
		this.departure_date_time = departure_date_time;
	}
	public String getReturn_date_time() {
		return return_date_time;
	}
	
	public Station getDepartureStation() {
		return departureStation;
	}
	public void setDepartureStation(Station departureStation) {
		this.departureStation = departureStation;
	}
	public Station getReturnStation() {
		return returnStation;
	}
	public void setReturnStation(Station returnStation) {
		this.returnStation = returnStation;
	}
	public void setReturn_date_time(String return_date_time) {
		this.return_date_time = return_date_time;
	}
	public Integer getDistance() {
		return distance;
	}
	public void setDistance(Integer distance) {
		this.distance = distance;
	}
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	

}