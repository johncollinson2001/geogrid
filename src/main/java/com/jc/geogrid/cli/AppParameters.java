package com.jc.geogrid.cli;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

import com.jc.geogrid.engine.model.UnitOfMeasure;

public class AppParameters {
	@NotNull	
	@Range(min=-90, max=90)
	private double centerLatitude;
	@NotNull	
	@Range(min=-180, max=180)
	private double centerLongitude;
	@NotNull	
	@Range(min=0, max=360)
	private int azimuth;
	@NotNull	
	private int rows; 
	@NotNull	
	private int columns;
	@NotNull	
	private double resolution;
	@NotNull		
	private UnitOfMeasure unitOfMeasure;
	@NotNull	
	private String outputDirectory;
		
	public AppParameters(double centerLatitude, double centerLongitude, int azimuth, int rows, int columns,
			double resolution, UnitOfMeasure unitOfMeasure, String csvFilePath) {		
		this.centerLatitude = centerLatitude;
		this.centerLongitude = centerLongitude;
		this.azimuth = azimuth;
		this.rows = rows;
		this.columns = columns;
		this.resolution = resolution;
		this.unitOfMeasure = unitOfMeasure;
		this.outputDirectory = csvFilePath;
	}
	
	public double getCenterLatitude() {
		return centerLatitude;
	}
	public void setCenterLatitude(double centerLatitude) {
		this.centerLatitude = centerLatitude;
	}
	public double getCenterLongitude() {
		return centerLongitude;
	}
	public void setCenterLongitude(double centerLongitude) {
		this.centerLongitude = centerLongitude;
	}
	public int getAzimuth() {
		return azimuth;
	}
	public void setAzimuth(int azimuth) {
		this.azimuth = azimuth;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getColumns() {
		return columns;
	}
	public void setColumns(int columns) {
		this.columns = columns;
	}
	public double getResolution() {
		return resolution;
	}
	public void setResolution(double resolution) {
		this.resolution = resolution;
	}
	public UnitOfMeasure getUnitOfMeasure() {
		return unitOfMeasure;
	}
	public void setUnitOfMeasure(UnitOfMeasure unitOfMeasure) {
		this.unitOfMeasure = unitOfMeasure;
	}
	public String getOutputDirectory() {
		return outputDirectory;
	}
	public void setOutputDirectory(String outputDirectory) {
		this.outputDirectory = outputDirectory;
	}
}
