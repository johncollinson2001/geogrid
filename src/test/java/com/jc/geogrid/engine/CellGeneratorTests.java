package com.jc.geogrid.engine;

import com.jc.geogrid.engine.model.GridCell;

import junit.framework.Assert;
import junit.framework.TestCase;

public class CellGeneratorTests extends TestCase {
	CellGenerator cellGenerator;
		
	protected void setUp() {
        cellGenerator = new CellGenerator();
    }
		
	protected void tearDown() {
        cellGenerator = null;
    }
    
	// create cells should produce a grid with the expected number of rows
	public void test_createCells_producesGridWithExpectedNumberOfRows() {
        // Arrange
		int rows = 10;
		int columns = 5;
		double lat = 50;
		double lon = -10;
		int azimuth = 45;
		double resolution = 100;
    	
    	// Act
		GridCell[][] cells = cellGenerator.createCells(lat, lon, azimuth, rows, columns, resolution);
    	
    	// Assert
    	Assert.assertEquals(cells.length, rows);
    }
	
	// create cells should produce a grid with the expected number of columns
	public void test_createCells_producesGridWithExpectedNumberOfColumns() {
        // Arrange
		int rows = 10;
		int columns = 5;
		double lat = 50;
		double lon = -10;
		int azimuth = 45;
		double resolution = 100;
    	
    	// Act
		GridCell[][] cells = cellGenerator.createCells(lat, lon, azimuth, rows, columns, resolution);
    	
    	// Assert
    	Assert.assertEquals(cells[0].length, columns);
    }
	
	// create cells should produce a grid of the expected resolution
	public void test_createCells_producesGridWithExpectedResolution() {
        // Arrange
		int rows = 1;
		int columns = 10;
		double lat = 0;
		double lon = -10;
		int azimuth = 0;		
		
		// Length of one degree longitude at 0 degrees latitude is 111319.458m
		// We will use this to test that each cells longitude is one degree apart
		double resolution = 111319.458;
    	
    	// Act
		GridCell[][] cells = cellGenerator.createCells(lat, lon, azimuth, rows, columns, resolution);
    	
    	// Assert		
		for(int c = 0; c < cells[0].length; c++) {
			double expectedLongitude = (lon - ((columns-1.0) / 2)) + c;
			// Assert on rounded longitude to 1 dp
			Assert.assertEquals(Math.round(cells[0][c].getLatLon().getLongitude() * 10) / 10.0, expectedLongitude);
		}    	
    }
	
	// create cells should produce a grid centered on the expected lat/lon
	public void test_createCells_producesGridCenteredOnExpectedLatLon() {
        // Arrange
		int rows = 5;
		int columns = 9;
		double lat = 0;
		double lon = -10;
		int azimuth = 0;				
		// Length of one degree longitude at 0 degrees latitude is 111319.458m
		double resolution = 111319.458;
    	
    	// Act
		GridCell[][] cells = cellGenerator.createCells(lat, lon, azimuth, rows, columns, resolution);
    	
    	// Assert		
		Assert.assertEquals(cells[2][4].getLatLon().getLatitude(), lat);    	
		Assert.assertEquals(cells[2][4].getLatLon().getLongitude(), lon);
    }	
}
