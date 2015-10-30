package com.jc.geogrid.cli;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;

import com.jc.geogrid.engine.model.UnitOfMeasure;

public final class CommandLineManager {
	public static final AppParameters processCommandLine(String[] args) throws Exception {
		AppParameters parameters = null;
				
		// Create parameters		
		try {
			CommandLineParser parser = new DefaultParser();
			CommandLine line = parser.parse(getOptions(), args);
			
			// Create parameters
			parameters = new AppParameters(
				Double.parseDouble(line.getOptionValue("centerLatitude")),
				Double.parseDouble(line.getOptionValue("centerLongitude")), 
				Integer.parseInt(line.getOptionValue("azimuth")),
				Integer.parseInt(line.getOptionValue("rows")),
				Integer.parseInt(line.getOptionValue("columns")),
				Double.parseDouble(line.getOptionValue("resolution")),
				UnitOfMeasure.valueOf(line.getOptionValue("unitOfMeasure")),
				line.getOptionValue("outputDirectory")
			);
		
			// Validate parameters
			AppParametersValidator.validate(parameters);
		} catch(Exception ex) {
			System.err.println("Unable to create parameters from the supplied options. Please check the help for required values.");			
			System.err.println();
		    HelpFormatter formatter=new HelpFormatter();
		    formatter.printHelp("Geogrid", getOptions());
		    System.exit(-1);
		}	
		
		return parameters;
	}
	
	private static final Options getOptions() {
		Options options = new Options();
		
		options.addOption("r", "rows", true, "The number of rows required for the grid");
		options.addOption("c", "columns", true, "The number of columns required for the grid");		
		options.addOption("lat", "centerLatitude", true, "The latitude of the center of the grid");
		options.addOption("lon", "centerLongitude", true, "The longitude of the center of the grid");
		options.addOption("azim", "azimuth", true, "The azimuth of the grid");
		options.addOption("res", "resolution", true, "The resolution of the grid");
		options.addOption("uom", "unitOfMeasure", true, "The unit of the resolutions, accepted values [m=metres, km=kilometres, mi=miles, nm=nautical miles]");
		options.addOption("out", "outputDirectory", true, "The dirctory that will be used to save the output CSV file");
		
		return options; 
	}
}
