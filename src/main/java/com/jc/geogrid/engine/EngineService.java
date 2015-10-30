package com.jc.geogrid.engine;

import com.jc.geogrid.engine.model.Grid;
import com.jc.geogrid.engine.model.GridCell;
import com.jc.geogrid.engine.model.UnitOfMeasure;

public final class EngineService {
	public final static Grid createGrid(double centerLatitude, double centerLongitude, int azimuth, int rows, int columns, 
			double resolution, UnitOfMeasure unitOfMeasure)
	{
		// Resolve the resolution to metres as required by cell generation
		double resolutionInMetres = ResolutionTransformer.getResolutionInMetres(resolution, unitOfMeasure);
		
		// Generate the cells
		GridCell[][] cells = new CellGenerator().createCells(centerLatitude, centerLongitude, azimuth, rows, columns, resolutionInMetres);
		
		// Create the Grid
		Grid grid = new Grid(centerLatitude, centerLongitude, azimuth, resolutionInMetres, cells);
		
		return grid;
    }
}
