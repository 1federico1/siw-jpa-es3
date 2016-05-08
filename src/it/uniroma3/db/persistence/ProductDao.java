package it.uniroma3.db.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import it.uniroma3.db.products.Product;

public class ProductDao implements Dao<Product>{
	private  EntityManagerFactory emf;
	private static EntityManager em;
	private static EntityTransaction tx;

	public ProductDao(EntityManagerFactory emf) {
		this.emf = emf;
	}

	public void save(Product c) {
		em = emf.createEntityManager();
		tx = em.getTransaction();
		tx.begin();
		em.persist(c);
		tx.commit();
		em.close();

	}

	public Product findById(long id) {
		em = emf.createEntityManager();
		tx = em.getTransaction();
		tx.begin();
		Product c = em.find(Product.class, id);
		tx.commit();
		em.close();
		return c;
	}

	public void delete(Product c) {
		em = emf.createEntityManager();
		tx = em.getTransaction();
		tx.begin();
		Product toRemove = em.merge(c);
		em.remove(toRemove);
		tx.commit();		
		em.close();

	}

	public void update(Product c) {
		em = emf.createEntityManager();
		tx = em.getTransaction();
		tx.begin();
		em.merge(c);
		tx.commit();
		em.close();
		

	}

	@SuppressWarnings("unchecked")
	public List<Product> findAll() {
		em = emf.createEntityManager();
		List<Product> result = em.createNamedQuery("Product.findAll").getResultList();
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
