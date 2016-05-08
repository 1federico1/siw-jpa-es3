package it.uniroma3.db.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import it.uniroma3.db.products.Order;

public class OrderDao implements Dao<Order>{
	private  EntityManagerFactory emf;
	private static EntityManager em;
	private static EntityTransaction tx;

	public OrderDao(EntityManagerFactory emf) {
		this.emf = emf;
	}

	public void save(Order c) {
		em = emf.createEntityManager();
		tx = em.getTransaction();
		tx.begin();
		em.persist(c);
		tx.commit();
		em.close();

	}

	public Order findById(long id) {
		em = emf.createEntityManager();
		tx = em.getTransaction();
		tx.begin();
		Order c = em.find(Order.class, id);
		tx.commit();
		em.close();
		return c;
	}

	public void delete(Order c) {
		em = emf.createEntityManager();
		tx = em.getTransaction();
		tx.begin();
		Order toRemove = em.merge(c);
		em.remove(toRemove);
		tx.commit();		
		em.close();

	}

	public void update(Order o) {
		em = emf.createEntityManager();
		tx = em.getTransaction();
		tx.begin();
		em.merge(o);
		tx.commit();
		em.close();
		

	}

	@SuppressWarnings("unchecked")
	public List<Order> findAll() {
		em = emf.createEntityManager();
		List<Order> result = em.createNamedQuery("Order.findAll").getResultList();
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
