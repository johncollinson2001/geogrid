package com.jc.geogrid.engine;

import com.jc.geogrid.engine.model.UnitOfMeasure;

final class ResolutionTransformer {
	private final static double M_TO_KM_MULTIPLIER = 1000;
	private final static double MI_TO_M_MULTIPLIER = 1609.344;
	private final static double NM_TO_M_MULTIPLIER = 1852.00;	
	
	public static final double getResolutionInMetres(double resolution, UnitOfMeasure unitOfMeasure) {
		switch(unitOfMeasure) {
			case m: 	return resolution;
			case km: 	return resolution * M_TO_KM_MULTIPLIER;
			case mi:	return resolution * MI_TO_M_MULTIPLIER;
			case nm:	return resolution * NM_TO_M_MULTIPLIER;
			default:	return 0.0;
		}		
	}
}
