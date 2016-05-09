package it.uniroma3.db.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import it.uniroma3.db.products.Order;

public class OrderDao extends Dao<Order> {

	public OrderDao(EntityManagerFactory emf) {
		super(emf);
	}

	@Override
	public Order findById(long id) {
		EntityManager em = this.emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Order c = em.find(Order.class, id);
		tx.commit();
		em.close();
		return c;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Order> findAll() {
		EntityManager em = this.emf.createEntityManager();
		List<Order> result = em.createNativeQuery("Order.findAll").getResultList();
		em.close();
		return result;
	}

}
