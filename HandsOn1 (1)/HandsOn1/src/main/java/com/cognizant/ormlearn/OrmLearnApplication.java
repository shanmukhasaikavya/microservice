package com.cognizant.ormlearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class OrmLearnApplication {
	private static CountryService countryService;
	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

	private static void testGetAllCountries() {
		LOGGER.info("Start");
		List<Country> countries = countryService.getAllCountries();
		LOGGER.debug("countries={}", countries);
		LOGGER.info("End");
	}

	private static void getAllCountriesTest() throws CountryNotFoundException {

		LOGGER.info("Start");
		Country country = countryService.findCountryByCode("IN");
		LOGGER.debug("Country:{}", country);
		LOGGER.info("End");
	}

	private static void testAddCountry() throws CountryNotFoundException {
		LOGGER.info("Start");
		Country country = new Country();
		country.setCode("MU");
		country.setName("Mauritius");
		countryService.addCountry(country);
		country = countryService.findCountryByCode("MU");
		LOGGER.debug("Country:{}", country);
		LOGGER.info("End");	
	}
	private static void testUpdateCountry() throws CountryNotFoundException {
		LOGGER.info("Start");
		countryService.updateCountry("RU", "Russia");
		Country country = countryService.findCountryByCode("RU");
		LOGGER.debug("Country:{}", country);
		LOGGER.info("End");		
	}
	private static void testDeleteCountry() throws CountryNotFoundException{
		LOGGER.info("Start");
		countryService.deleteCountry("RU");
		Country country = countryService.findCountryByCode("RU");
		LOGGER.debug("Country:{}", country);
		LOGGER.info("End");		
	}

	public static void main(String[] args) throws CountryNotFoundException {
		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
		countryService = context.getBean(CountryService.class);
		testGetAllCountries();
		getAllCountriesTest();
		testAddCountry();
		testUpdateCountry();
		testDeleteCountry();
		LOGGER.info("Inside main");
	}
}
