package com.cognizant.ormlearn.service.exception;

public class CountryNotFoundException extends Exception {

	
		
		public CountryNotFoundException(String countryCode) {
			super(countryCode+" not found");
			

	}
}


