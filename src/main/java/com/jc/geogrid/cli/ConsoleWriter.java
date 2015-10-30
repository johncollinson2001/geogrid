package com.jc.geogrid.cli;

import com.jc.geogrid.engine.model.Grid;

public final class ConsoleWriter {
	public final static void writeOutput(Grid grid)
	{
		System.out.println("Grid Information");
		System.out.format("Center Latitude: %s\n", grid.getCenterLatitude());
		System.out.format("Center Longitude: %s\n", grid.getCenterLongitude());
		System.out.format("Azimuth: %s\n", grid.getAzimuth());
		System.out.format("Rows: %s\n", grid.getRows());
		System.out.format("Columns: %s\n", grid.getColumns());
		System.out.format("Resolution (metres): %s\n", grid.getResolution());				
	    
		for(int row = 0; row < grid.getRows(); row++) {
			for(int column = 0; column < grid.getColumns(); column++) {				
				System.out.println("-------------------------------------------");
				System.out.format("Cell [%s, %s]\n", Integer.toString(row), Integer.toString(column));
				System.out.format("Latitude: %s\n", grid.getCells()[row][column].getLatLon().getLatitude());
				System.out.format("Longitude: %s\n", grid.getCells()[row][column].getLatLon().getLongitude());							
			}
		}
    }
}
