package com.ibm.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Ticket")
@NamedQueries({@NamedQuery(name = "allTickets", query = "from Ticket")})
public class Ticket {

	@Id
	private int pnr;
	private LocalDate date;
	private double amount;
	
	@OneToMany(mappedBy = "ticket", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Passenger> passengers = new ArrayList<Passenger>();
	
	
	public Ticket() {
		// TODO Auto-generated constructor stub
	}

	public Ticket(int pnr, LocalDate date, double amount) {
		this.pnr = pnr;
		this.date = date;
		this.amount = amount;
	}

	public int getPnr() {
		return pnr;
	}

	public void setPnr(int pnr) {
		this.pnr = pnr;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public List<Passenger> getPassengers() {
		return passengers;
	}

	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}

	@Override
	public String toString() {
		return "Ticket [pnr=" + pnr + ", date=" + date + ", amount=" + amount + "]";
	}
	
	
	
}
