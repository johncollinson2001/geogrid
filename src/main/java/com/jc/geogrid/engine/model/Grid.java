package com.jc.geogrid.engine.model;


public class Grid {	
	private double centerLat;
	private double centerLon;
	private int azimuth;	
	private double resolution;
	private GridCell[][] cells;
	
	public Grid(double centerLat, double centerLon, int azimuth, double resolution, GridCell[][] cells)
	{
		this.centerLat = centerLat;
		this.centerLon = centerLon;
		this.azimuth = azimuth;		
		this.resolution = resolution;			
		this.cells = cells;
	}
	
	public int getRows() {
		return cells.length;
	}
	
	public int getColumns() {
		return cells[0].length;
	}

	public GridCell[][] getCells() {
		return cells;
	}	

	public double getCenterLatitude() {
		return centerLat;
	}

	public double getCenterLongitude() {
		return centerLon;
	}

	public int getAzimuth() {
		return azimuth;
	}

	public double getResolution() {
		return resolution;
	}
}
