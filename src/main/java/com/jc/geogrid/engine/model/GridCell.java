package com.jc.geogrid.engine.model;


public class GridCell {
	private LatLon latLon;
	
	public GridCell(LatLon latLon) {
		this.latLon = latLon;
	}
	
	public LatLon getLatLon() {
		return latLon;
	}	
}
