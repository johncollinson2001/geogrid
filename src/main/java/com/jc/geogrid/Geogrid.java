package com.jc.geogrid;

import com.jc.geogrid.cli.AppParameters;
import com.jc.geogrid.cli.CommandLineManager;
import com.jc.geogrid.cli.ConsoleWriter;
import com.jc.geogrid.cli.CsvWriter;
import com.jc.geogrid.engine.EngineService;
import com.jc.geogrid.engine.model.Grid;
 
class Geogrid {	
	public static void main(String[] args) throws Exception
    {		
		// Process the command line, get the application parameters
		AppParameters parameters = CommandLineManager.processCommandLine(args);
		
		// Create the grid
		Grid grid = EngineService.createGrid(
			parameters.getCenterLatitude(), 
			parameters.getCenterLongitude(), 
			parameters.getAzimuth(), 
			parameters.getRows(), 
			parameters.getColumns(), 
			parameters.getResolution(),
			parameters.getUnitOfMeasure());
		
		// Write output to console
		ConsoleWriter.writeOutput(grid);
		
		// Generate CSV file		
		CsvWriter.generateFile(parameters.getOutputDirectory(), grid);		
    }
}