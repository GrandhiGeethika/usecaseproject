package com.usecase.travel_company_platform.data;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.decimal4j.util.DoubleRounder;

@Entity(name="WeatherInfoData")
public class WeatherInfoData {

	@Id
    @GeneratedValue
	private Long id;
	private Date date;
	private double lat;
	private double lon;
	private String city;
	private String state;
	private double temperature;


	public Long getId() {
		return id;
	}

	public double getLat() {
		return lat;
	}

	public double getLon() {
		return lon;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public double getTemperature() {
		return temperature;
	}

	public void setLat(float lat) {
		this.lat = DoubleRounder.round(lat, 4);
	}

	public void setLon(float lon) {
		this.lon = DoubleRounder.round(lon, 4);;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}