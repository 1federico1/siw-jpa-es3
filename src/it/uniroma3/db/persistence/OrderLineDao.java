package it.uniroma3.db.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import it.uniroma3.db.products.OrderLine;

public class OrderLineDao {
	private  EntityManagerFactory emf;
	private static EntityManager em;
	private static EntityTransaction tx;

	public OrderLineDao(EntityManagerFactory emf) {
		this.emf = emf;
	}

	public void save(OrderLine c) {
		em = emf.createEntityManager();
		tx = em.getTransaction();
		tx.begin();
		em.persist(c);
		tx.commit();
		em.close();

	}

	public OrderLine findById(long id) {
		em = emf.createEntityManager();
		tx = em.getTransaction();
		tx.begin();
		OrderLine c = em.find(OrderLine.class, id);
		tx.commit();
		em.close();
		return c;
	}

	public void delete(OrderLine c) {
		em = emf.createEntityManager();
		tx = em.getTransaction();
		tx.begin();
		OrderLine toRemove = em.merge(c);
		em.remove(toRemove);
		tx.commit();		
		em.close();

	}

	public void update(OrderLine c) {
		em = emf.createEntityManager();
		tx = em.getTransaction();
		tx.begin();
		em.merge(c);
		tx.commit();
		em.close();
		

	}

	@SuppressWarnings("unchecked")
	public List<OrderLine> findAll() {
		em = emf.createEntityManager();
		List<OrderLine> result = em.createNamedQuery("OrderLine.findAll").getResultList();
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
