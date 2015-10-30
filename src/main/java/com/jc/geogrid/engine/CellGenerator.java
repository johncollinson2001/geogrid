package com.jc.geogrid.engine;

import com.jc.geogrid.engine.model.GridCell;
import com.jc.geogrid.engine.model.LatLon;

public class CellGenerator {
	public GridCell[][] createCells(double centerLatitude, double centerLongitude, int azimuth, int rows, int columns, double resolutionInMetres) {						
		GridCell[][] cells = new GridCell[rows][columns];
		
		LatLon gridCentreLatLon = new LatLon(centerLatitude, centerLongitude);
		double middleColumnOfGrid = (columns - 1) / 2.0;
		double middleRowOfGrid = (rows - 1) / 2.0;
				
		// Iterate over rows and columns and create the grid cells
		for(int r = 0; r < rows; r++) {
			// Work out distance and bearing to the centre point of the row we're about to
			// create cells for
			double distanceToNewRowCentre = 0.0;
			double bearingToNewRowCentre = 0.0;
			
			// To make the code readable, place all logic conditions into bools
			boolean creatingRowBelowCentre = r < middleRowOfGrid;
			boolean creatingRowAboveCentre = r > middleRowOfGrid;
			boolean creatingRowExactlyAtCentre = (r == middleRowOfGrid);
			
			if(creatingRowBelowCentre) {
				distanceToNewRowCentre = resolutionInMetres * (middleRowOfGrid - r);
				bearingToNewRowCentre = GeodesyHelper.addDegrees(azimuth, 180);
			} else if(creatingRowAboveCentre) {
				distanceToNewRowCentre = resolutionInMetres * (r - middleRowOfGrid);
				bearingToNewRowCentre = azimuth;
			} else {
				// Creating a row exactly at the centre of the grid..leave values as default				
			}
			
			// Get the lat lon of the centre point of the new row			
			LatLon rowCentreLatLon = GeodesyHelper.getLatLonForDistanceAndBearing(
				gridCentreLatLon,				
				distanceToNewRowCentre,
				bearingToNewRowCentre);			
			
			// Iterate over columns and populate the grid cells
			for(int c = 0; c < columns; c++) {
				// Work out distance and bearing to the cell we're about to create
				double distanceToNewCell = 0.0;
				double bearingToNewCell = 0.0;
				
				// To make the code readable, place all logic conditions into bools
				boolean creatingCellLeftOfCentre = c < middleColumnOfGrid;
				boolean creatingCellRightOfCentre = c > middleColumnOfGrid;
				
				if(creatingCellLeftOfCentre) {
					distanceToNewCell = resolutionInMetres * (middleColumnOfGrid - c);
					bearingToNewCell = GeodesyHelper.addDegrees(azimuth, 270);										
				} else if(creatingCellRightOfCentre) {
					distanceToNewCell = resolutionInMetres * (c - middleColumnOfGrid);
					bearingToNewCell = GeodesyHelper.addDegrees(azimuth, 90);
				} else {
					// Creating a cell exactly at the centre of the row..leave values as default 
				}
				
				// Add on rhumb line adjustment
				// ...
				// The bearing from source row to target row is different when reversed, because of the nature of navigating
				// a sphere (most commonly understood via rhumb lines). Therefore we need to adjust the azimuth in order to 
				// create regimented grid at near-exact intervals
				if(!creatingRowExactlyAtCentre) {										
					double rhumbLineAdjustment = GeodesyHelper.getBearing(rowCentreLatLon, gridCentreLatLon) - azimuth;
					bearingToNewCell = bearingToNewCell + rhumbLineAdjustment;
				}
				
				// Get the lat lon of the new grid cell
				LatLon newCellLatLon = GeodesyHelper.getLatLonForDistanceAndBearing(
						rowCentreLatLon, 
						distanceToNewCell, 
						bearingToNewCell);
								
				// Add the new cell into the array of grid cells
				cells[r][c] = new GridCell(newCellLatLon);
			}
		}
		
		return cells;
	}
}
