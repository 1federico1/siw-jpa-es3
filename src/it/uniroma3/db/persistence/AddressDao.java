package it.uniroma3.db.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import it.uniroma3.db.products.Address;


public class AddressDao {
	private EntityManagerFactory emf;
	private static EntityManager em;
	private static EntityTransaction tx;
	
	public AddressDao(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	public void save(Address a) {
		em = this.emf.createEntityManager();
		tx = em.getTransaction();
		tx.begin();
		em.persist(a);
		tx.commit();
		em.close();

	}
	public void delete(Address a) {
		em = emf.createEntityManager();
		tx = em.getTransaction();
		tx.begin();
		Address toRemove = em.merge(a);
		em.remove(toRemove);
		tx.commit();
		
		em.close();

	}
	
	public void update(Address a) {
		em = this.emf.createEntityManager();
		tx = em.getTransaction();
		tx.begin();
		em.merge(a);
		tx.commit();
		em.close();
	}
	
	public Address findById(long id) {
		em = this.emf.createEntityManager();
		tx = em.getTransaction();
		tx.begin();
		Address a = em.find(Address.class, id);
		tx.commit();
		em.close();
		return a;
	}
	
	public void closeEmf() {
		this.emf.close();
	}


}
