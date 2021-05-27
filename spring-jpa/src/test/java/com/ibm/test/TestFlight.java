package com.ibm.test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.ibm.entity.Flight;
import com.ibm.repo.FlightRepository;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:appctx.xml")
public class TestFlight {

	@Autowired
	private FlightRepository flightRepo;

	@Test
	public void testSave() {

		Flight f = new Flight("A500", "Delhi", "Cochin", "JetAirways");

		assertNotNull(flightRepo.save(f));
	}

	@Test
	public void testFetch() {
		Flight f = flightRepo.fetch("A400");
		assertNotNull(f);
	}

	@Test
	public void testFetchAll() {
		List<Flight> flights = flightRepo.fetchAll();
		assertNotNull(flights);
		flights.forEach(System.out::println);
	}

	@Test
	public void testUpdate() {

		Flight f = new Flight("A500", "New Delhi", "Bangalore", "Indigo");
		assertTrue(flightRepo.update(f));
		;

	}

	@Test
	public void testRemove() {
		assertTrue(flightRepo.remove("A400"));

	}

	@Test
	public void testFindByCarrier() {

		List<Flight> flights = flightRepo.findByCarrier("Indigo");
		assertNotNull(flights);
		flights.forEach(System.out::println);

	}

}
