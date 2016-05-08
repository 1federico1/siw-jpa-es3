package it.uniroma3.db.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import it.uniroma3.db.products.Address;


public class AddressDao implements Dao<Address> {
	private EntityManagerFactory emf;
	
	public AddressDao(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	public void save(Address a) {
		EntityManager em = this.emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(a);
		tx.commit();
		em.close();

	}
	public void delete(Address a) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Address toRemove = em.merge(a);
		em.remove(toRemove);
		tx.commit();
		
		em.close();

	}
	
	public void update(Address a) {
		EntityManager em = this.emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(a);
		tx.commit();
		em.close();
	}
	
	public Address findById(long id) {
		EntityManager em = this.emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Address a = em.find(Address.class, id);
		tx.commit();
		em.close();
		return a;
	}

	@Override
	public List<Address> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
