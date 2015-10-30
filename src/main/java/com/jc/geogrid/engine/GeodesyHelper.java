package com.jc.geogrid.engine;

import com.jc.geogrid.engine.model.LatLon;

final class GeodesyHelper {
	public final static LatLon getLatLonForDistanceAndBearing(LatLon startLatLon, double metres, double bearing) {			
		double dist = (metres / 1000) / 6371.0;
		double brng = Math.toRadians(bearing);
		double lat1 = Math.toRadians(startLatLon.getLatitude());
		double lon1 = Math.toRadians(startLatLon.getLongitude());

		double lat2 = Math.asin( Math.sin(lat1)*Math.cos(dist) + Math.cos(lat1)*Math.sin(dist)*Math.cos(brng) );
		
		double a = Math.atan2(Math.sin(brng)*Math.sin(dist)*Math.cos(lat1), Math.cos(dist)-Math.sin(lat1)*Math.sin(lat2));		
		double lon2 = lon1 + a;
		lon2 = (lon2+ 3*Math.PI) % (2*Math.PI) - Math.PI;

		// Convert to degrees and round to 7dp (approx 11mm accuracy)
		double lat2deg = Math.round(Math.toDegrees(lat2) * 10000000) / 10000000.0;
		double lon2deg = Math.round(Math.toDegrees(lon2) * 10000000) / 10000000.0;
		
		return new LatLon(lat2deg, lon2deg);
	}
	
	public final static double addDegrees(double degree1, double degree2) {
		return (degree1 + degree2) >= 360 ? (degree1 + degree2) - 360 : (degree1 + degree2);
	}
	
	public final static double getBearing(LatLon latLon1, LatLon latLon2) {
		double lat1 = Math.toRadians(latLon1.getLatitude());
		double lat2 = Math.toRadians(latLon2.getLatitude());
		double lon1 = Math.toRadians(latLon1.getLongitude());
		double lon2 = Math.toRadians(latLon2.getLongitude());
		
		double longDiff = lon2-lon1;
		double y = Math.sin(longDiff) * Math.cos(lat2);
		double x = Math.cos(lat1) * Math.sin(lat2) - Math.sin(lat1) * Math.cos(lat2) * Math.cos(longDiff);

		return (Math.toDegrees(Math.atan2(y, x)) + 360) % 360;
	}	
}
