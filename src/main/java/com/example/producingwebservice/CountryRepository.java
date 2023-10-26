package com.example.producingwebservice;

import io.spring.guides.gs_producing_web_service2.Country2;
import io.spring.guides.gs_producing_web_service2.Currency2;
import jakarta.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

import io.spring.guides.gs_producing_web_service.Country;
import io.spring.guides.gs_producing_web_service.Currency;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class CountryRepository {
	private static final Map<String, Country> countries = new HashMap<>();
	private static final Map<String, Country2> countries2 = new HashMap<>();


	@PostConstruct
	public void initData() {
		Country spain = new Country();
		spain.setName("Spain");
		spain.setCapital("Madrid");
		spain.setCurrency(Currency.EUR);
		spain.setPopulation(46704314);

		countries.put(spain.getName(), spain);

		Country poland = new Country();
		poland.setName("Poland");
		poland.setCapital("Warsaw");
		poland.setCurrency(Currency.PLN);
		poland.setPopulation(38186860);

		countries.put(poland.getName(), poland);

		Country uk = new Country();
		uk.setName("United Kingdom");
		uk.setCapital("London");
		uk.setCurrency(Currency.GBP);
		uk.setPopulation(63705000);

		countries.put(uk.getName(), uk);


		Country2 spain2= new Country2();
		spain2.setName("Spain");
		spain2.setCapital("Madrid");
		spain2.setCurrency(Currency2.EUR);
		spain2.setPopulation(46704314);

		countries2.put(spain2.getName(), spain2);

		Country2 poland2 = new Country2();
		poland2.setName("Poland");
		poland2.setCapital("Warsaw");
		poland2.setCurrency(Currency2.PLN);
		poland2.setPopulation(38186860);

		countries2.put(poland2.getName(), poland2);

		Country2 uk2 = new Country2();
		uk2.setName("United Kingdom");
		uk2.setCapital("London");
		uk2.setCurrency(Currency2.GBP);
		uk2.setPopulation(63705000);

		countries2.put(uk2.getName(), uk2);
	}

	public Country findCountry(String name) {
		Assert.notNull(name, "The country's name must not be null");
		return countries.get(name);
	}
	public Country2 findCountry2(String name) {
		Assert.notNull(name, "The country's name must not be null");
		return countries2.get(name);
	}
}
