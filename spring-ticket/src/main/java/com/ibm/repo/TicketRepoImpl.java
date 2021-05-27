package com.ibm.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.ibm.entity.Passenger;
import com.ibm.entity.Ticket;

@Repository
public class TicketRepoImpl implements TicketRepo {
	
	@PersistenceContext(unitName = "SpringTicket")
	private EntityManager em;

	@Transactional
	public boolean createTicket(Ticket t) {
		em.persist(t);
		return true;
	}

	@Transactional
	public boolean addPassenger(int pnr,Passenger p) {
		Ticket t = em.find(Ticket.class, pnr);
		t.getPassengers().add(p);
		p.setTicket(t);
		em.persist(p);
		return true;
	}

	@Transactional
	public boolean removeTicket(int pnr) {
		Ticket t = em.find(Ticket.class, pnr);
		//List<Passenger> passengers = t.getPassengers();
		
		em.remove(t);
		return true;
	}

	@Transactional
	public boolean removePassenger(int id) {
		Passenger p = em.find(Passenger.class, id);
		Ticket t = p.getTicket();
		t.getPassengers().remove(p);
		em.remove(p);
		return true;
	}
	
	@Transactional
	public boolean updatingTicket(Ticket t) {
		em.merge(t);
		return true;
	}

	@Transactional
	public boolean updatingPassenger(int pnr,Passenger p) {
		Ticket t = em.find(Ticket.class, pnr);
		p.setTicket(t);
		em.merge(p);
		return true;
	}

	public Ticket fetchTicket(int pnr) {
		return em.find(Ticket.class, pnr);
	}

	public List<Ticket> fetchAllTickets() {
		return em.createNamedQuery("allTickets").getResultList();
	}

}
