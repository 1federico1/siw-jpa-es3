package it.uniroma3.db.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import it.uniroma3.db.products.OrderLine;

public class OrderLineDao extends Dao<OrderLine> {

	public OrderLineDao(EntityManagerFactory emf) {
		super(emf);
	}

	@Override
	public OrderLine findById(long id) {
		EntityManager em = this.emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		OrderLine c = em.find(OrderLine.class, id);
		tx.commit();
		em.close();
		return c;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<OrderLine> findAll() {
		EntityManager em = this.emf.createEntityManager();
		List<OrderLine> result = em.createNamedQuery("OrderLine.findAll").getResultList();
		em.close();
		return result;
	}

}
