package it.uniroma3.db.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import it.uniroma3.db.products.OrderLine;

public class OrderLineDao implements Dao<OrderLine>{
	private  EntityManagerFactory emf;

	public OrderLineDao(EntityManagerFactory emf) {
		this.emf = emf;
	}

	public void save(OrderLine ol) {
		EntityManager em = this.emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(ol);
		tx.commit();
		em.close();

	}

	public OrderLine findById(long id) {
		EntityManager em = this.emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		OrderLine c = em.find(OrderLine.class, id);
		tx.commit();
		em.close();
		return c;
	}

	public void delete(OrderLine ol) {
		EntityManager em = this.emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		OrderLine toRemove = em.merge(ol);
		em.remove(toRemove);
		tx.commit();		
		em.close();

	}

	public void update(OrderLine ol) {
		EntityManager em = this.emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(ol);
		tx.commit();
		em.close();
		

	}

	@SuppressWarnings("unchecked")
	public List<OrderLine> findAll() {
		EntityManager em = this.emf.createEntityManager();
		List<OrderLine> result = em.createNamedQuery("OrderLine.findAll").getResultList();
		em.close();
		return result;
	}

}
