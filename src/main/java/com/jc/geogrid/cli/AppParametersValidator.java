package com.jc.geogrid.cli;

import java.io.File;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

public final class AppParametersValidator {	
	private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
	
	public static final void validate(AppParameters parameters) throws Exception {
		// Validate annotations
		Set<ConstraintViolation<AppParameters>> constraintViolations = validator.validate(parameters);
		if(!constraintViolations.isEmpty()) {
			throw new Exception(constraintViolations.iterator().next().getMessage());
		}		
		
		// Validate output file path
		File directory = new File(parameters.getOutputDirectory());
		if(!directory.isDirectory() || !directory.exists()) {
			throw new Exception("Output file directory is not valid.");
		}
	}
}
