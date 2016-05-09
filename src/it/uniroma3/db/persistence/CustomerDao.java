package it.uniroma3.db.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import it.uniroma3.db.products.Customer;

public class CustomerDao extends Dao<Customer> {

	public CustomerDao(EntityManagerFactory emf) {
		super(emf);
	}

	@Override
	public Customer findById(long id) {
		EntityManager em = this.emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Customer c = em.find(Customer.class, id);
		tx.commit();
		em.close();
		return c;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Customer> findAll() {
		EntityManager em = this.emf.createEntityManager();
		List<Customer> result = em.createNamedQuery("Customer.findAll").getResultList();
		em.close();
		return result;
	}
}
