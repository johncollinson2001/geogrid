package com.jc.geogrid.cli;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.jc.geogrid.engine.model.Grid;

public final class CsvWriter {
	public final static void generateFile(String directoryPath, Grid grid)
	{
		try
		{
			String filePath = createFilePath(directoryPath, grid);
			
		    FileWriter writer = new FileWriter(filePath);			 
		    writer.append("CellNo,Latitude,Longitude");
		    writer.append('\n');
		    writer.append(String.format("%s,%s,%s", "Grid center", grid.getCenterLatitude(), grid.getCenterLongitude()));
			writer.append('\n');
		    
		    for(int row = 0; row < grid.getRows(); row++) {
				for(int column = 0; column < grid.getColumns(); column++) {
					String cellNo = String.format("Cell [%s:%s]", Integer.toString(row), Integer.toString(column));
					String latitude = Double.toString(grid.getCells()[row][column].getLatLon().getLatitude());
					String longitude = Double.toString(grid.getCells()[row][column].getLatLon().getLongitude());
					writer.append(String.format("%s,%s,%s", cellNo, latitude, longitude));
					writer.append('\n');
				}
			}
				
		    writer.flush();
		    writer.close();
		    
		    System.out.println("-------------------------------------------");
			System.out.println("Csv file generated: " + filePath);
		}
		catch(IOException e)
		{
		     e.printStackTrace();
		} 
    }

	private static String createFilePath(String directoryPath, Grid grid) {
		DecimalFormat doubleFormat = new DecimalFormat("#.###");
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		
		return directoryPath + "\\" +
			doubleFormat.format(grid.getCenterLatitude()) + "_" + 
			doubleFormat.format(grid.getCenterLongitude()) + "_" + 
			String.valueOf(grid.getRows()) + "x" + String.valueOf(grid.getColumns()) + "_" +
			String.valueOf(grid.getAzimuth()) + "azim" + "_" +
			doubleFormat.format(grid.getResolution()) + "m" + "_" + 
			dateFormat.format(new Date()) + ".csv";
	}
}
