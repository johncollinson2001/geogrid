# Geogrid
Create grids of geographic points at accurately spaced intervals across the geoid.

Geogrid requires a center latitude/longitude, grid dimensions/azimuth and resolution in a variety of measures. Using spherical calculations, the program then generates a CSV file of equally spaced grid points placed across the earth that can be loaded into another application.

# About the Program
Geogrid is a simple lightweight program written in Java, using the Maven build manager. It's so simple it would be easily portable to any other language. It contains two main packages, com.jc.geogrid.engine and com.jc.geogrid.cli.

The engine package contains the grid models, a few classes that generate the grid, a class that transforms different units of measure, and a service that the cli project uses. 

The cli project implements a command line user interface for the program.

Use it for whatever you wish, however it would be nice to know what you use it for :)

# Running the Program from a Console
The repository contains the compiled jar file, which you must run using the JVM. Using Windows, assuming you have Java installed, open command prompt and navigate to the bin directory. Run java -jar geogrid.jar <parameters>.

Geogrid requires the following parameters:  

1. -centerLatitude : The latitude of the center of the grid  
2. -centerLongitude : The longitude of the center of the grid  
3. -columns : The number of columns required for the grid  
4. -rows : The number of rows required for the grid
5. -azimuth : The azimuth of the grid
6. -outputDirectory : The directory that will be used to save the output CSV file  
7. -resolution : The resolution of the grid  
8. -unitOfMeasure : The unit of the resolutions, accepted values [m=metres, km=kilometres, mi=miles, nm=nautical miles]

# Example of Output
These images show the output loaded into ArcGIS Explorer - a free GIS tool available from http://www.esri.com/software/arcgis/explorer-desktop/download. The tool loads point files such as that produced by Geogrid, and loads it into the map viewer.

##### Small grid, 10'000 metre resolution, 0 azimuth  
![smallgrid-0azim](https://raw.githubusercontent.com/johncollinson2001/geogrid/master/docs/10000m_0azim.png)

##### Small grid, 10'000 metre resolution, 60 azimuth  
![smallgrid-60azim](https://raw.githubusercontent.com/johncollinson2001/geogrid/master/docs/10000m_60azim.png)

##### Medium grid, 100'000 metre resolution, 60 azimuth  
![mediumgrid-60azim](https://raw.githubusercontent.com/johncollinson2001/geogrid/master/docs/100000m_60azim.png)

##### Medium grid, 100'000 metre resolution, 230 azimuth, over the pole  
![mediumgrid-230azim](https://raw.githubusercontent.com/johncollinson2001/geogrid/master/docs/100000m_230azim-overpoles.png)

##### Large grid, 800'000 metre resolution, 230 azimuth, all over the world  
![largegrid-230azim-1](https://raw.githubusercontent.com/johncollinson2001/geogrid/master/docs/800000m_230azim-allover.png)

##### Large grid 800'000 metre resolution, 230 azimuth, view 90 degs from center of grid, where points converge
![largegrid-230azim-2](https://raw.githubusercontent.com/johncollinson2001/geogrid/master/docs/800000m_230azim-oppositecentrell.png)

##### Large grid, 800'000 metre resolution, 230 azimuth, projected onto a 2d map  
![largegrid-230azim-3](https://raw.githubusercontent.com/johncollinson2001/geogrid/master/docs/800000m_230azim-projected.png)