package com.ibm.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.ibm.entity.Flight;

@Repository
public class FlightRepositoryImpl implements FlightRepository {
	
	@PersistenceContext(unitName = "SpringJpa")
	private EntityManager em;

	@Transactional(value = TxType.REQUIRED)
	public String save(Flight f) {
		em.persist(f);
		return f.getCode();
	}

	@Override
	public Flight fetch(String code) {
		// TODO Auto-generated method stub
		return em.find(Flight.class, code);
	}

	@Override
	public List<Flight> fetchAll() {
//		Query sql = em.createQuery("from Flight");
//		return sql.getResultList();
//		return em.createQuery("from Flight").getResultList();
		return em.createNamedQuery("allFlights").getResultList();
	}

	@Transactional
	public boolean remove(String code) {
		em.remove(em.find(Flight.class, code));
		return true;
	}

	@Transactional
	public boolean update(Flight f) {
		em.merge(f);
		return true;
	}
	
	public List<Flight> findByCarrier(String carrier){
		Query query= em.createNamedQuery("byCarrier");
		query.setParameter("car", carrier);
		return query.getResultList();
		
	}

}
