package com.jc.geogrid.engine.model;


public class LatLon {
	private double latitude;
	private double longitude;
	
	public LatLon(double latitude, double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public double getLatitude() {
		return latitude;
	}
	
	public double getLongitude() {
		return longitude;
	}	
}
