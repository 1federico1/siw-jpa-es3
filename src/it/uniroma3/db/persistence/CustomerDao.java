package it.uniroma3.db.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import it.uniroma3.db.products.Customer;

public class CustomerDao {
	private  EntityManagerFactory emf;
	private static EntityManager em;
	private static EntityTransaction tx;

	public CustomerDao(EntityManagerFactory emf) {
		this.emf = emf;
	}

	public void save(Customer c) {
		em = emf.createEntityManager();
		tx = em.getTransaction();
		tx.begin();
		em.persist(c);
		tx.commit();
		em.close();

	}

	public Customer findById(long id) {
		em = emf.createEntityManager();
		tx = em.getTransaction();
		tx.begin();
		Customer c = em.find(Customer.class, id);
		tx.commit();
		em.close();
		return c;
	}

	public void delete(Customer c) {
		em = emf.createEntityManager();
		tx = em.getTransaction();
		tx.begin();
		Customer toRemove = em.merge(c);
		em.remove(toRemove);
		tx.commit();		
		em.close();

	}

	public void update(Customer c) {
		em = emf.createEntityManager();
		tx = em.getTransaction();
		tx.begin();
		em.merge(c);
		tx.commit();
		em.close();
		

	}

	@SuppressWarnings("unchecked")
	public List<Customer> findAll() {
		em = emf.createEntityManager();
		List<Customer> result = em.createNamedQuery("Customer.findAll").getResultList();
		em.close();
		return result;
	}

	public void closeEmf() {
		emf.close();
	}
	
	public EntityManager getEntityManager() {
		return em = emf.createEntityManager();
	}

}
