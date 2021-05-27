package cpm.ibm.test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.ibm.entity.Passenger;
import com.ibm.entity.Ticket;
import com.ibm.repo.TicketRepo;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:appctx.xml")
public class TestTicketRepo {
	
	@Autowired
	private TicketRepo repo;
	
	@Test
	public void testCreateTicket() {

		Ticket t = new Ticket();
		t.setPnr(1002);
		t.setDate(LocalDate.parse("2021-09-18"));
		t.setAmount(100);	
		assertTrue(repo.createTicket(t));
	}
	
	@Test
	public void testAddPassenger() {
		Passenger p = new Passenger(103, "Arya P Menon", 23, "Female");
		assertTrue(repo.addPassenger(1002,p));
	}
	
	@Test
	public void testFetchAll() {
		List<Ticket> tickets = repo.fetchAllTickets();
		assertNotNull(tickets);
		tickets.forEach(System.out::println);
		
	}
	
	@Test
	public void testFetchTicket() {
		Ticket t = repo.fetchTicket(1001);
		assertNotNull(t);
		System.out.println(t);
		for(Passenger p : t.getPassengers())
			System.out.println(p);
		
	}
	
	@Test
	public void testUpdateTicket() {
		Ticket t = new Ticket(1001, LocalDate.now(), 200);
		assertTrue(repo.updatingTicket(t));
	}
	
	@Test
	public void testUpdatePassenger() {
		Passenger p = new Passenger(102, "Arya P M", 23, "Female");
		assertTrue(repo.updatingPassenger(1001,p));
	}

	@Test
	public void testRemovePassenger() {
		assertTrue(repo.removePassenger(102));
	}
	
	@Test
	public void testRemoveTicket() {
		assertTrue(repo.removeTicket(1002));
	}
}
