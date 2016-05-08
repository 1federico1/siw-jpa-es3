package it.uniroma3.db.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import it.uniroma3.db.products.Order;

public class OrderDao implements Dao<Order>{
	private EntityManagerFactory emf;

	public OrderDao(EntityManagerFactory emf) {
		this.emf = emf;
	}

	public void save(Order o) {
		EntityManager em = this.emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(o);
		tx.commit();
		em.close();

	}

	public Order findById(long id) {
		EntityManager em = this.emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Order c = em.find(Order.class, id);
		tx.commit();
		em.close();
		return c;
	}

	public void delete(Order o) {
		EntityManager em = this.emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Order toRemove = em.merge(o);
		em.remove(toRemove);
		tx.commit();		
		em.close();

	}

	public void update(Order o) {
		EntityManager em = this.emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(o);
		tx.commit();
		em.close();
		

	}

	@SuppressWarnings("unchecked")
	public List<Order> findAll() {
		EntityManager em = this.emf.createEntityManager();
		List<Order> result = em.createNativeQuery("Order.findAll").getResultList();
		em.close();
		return result;
	}

}
