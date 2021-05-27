package com.ibm.repo;

import java.util.List;

import com.ibm.entity.Passenger;
import com.ibm.entity.Ticket;

public interface TicketRepo {
	
	boolean createTicket(Ticket t);
	
	boolean addPassenger(int pnr,Passenger p);
	
	boolean removeTicket(int pnr);
	
	boolean removePassenger(int id);
	
	boolean updatingTicket(Ticket t);
	
	boolean updatingPassenger(int pnr,Passenger p);
	
	Ticket fetchTicket(int pnr);
	
	List<Ticket> fetchAllTickets();

}
