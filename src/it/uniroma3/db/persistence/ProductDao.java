package it.uniroma3.db.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import it.uniroma3.db.products.Product;

public class ProductDao implements Dao<Product>{
	private  EntityManagerFactory emf;

	public ProductDao(EntityManagerFactory emf) {
		this.emf = emf;
	}

	public void save(Product p) {
		EntityManager em = this.emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(p);
		tx.commit();
		em.close();

	}

	public Product findById(long id) {
		EntityManager em = this.emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Product c = em.find(Product.class, id);
		tx.commit();
		em.close();
		return c;
	}

	public void delete(Product p) {
		EntityManager em = this.emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Product toRemove = em.merge(p);
		em.remove(toRemove);
		tx.commit();		
		em.close();

	}

	public void update(Product p) {
		EntityManager em = this.emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(p);
		tx.commit();
		em.close();
		

	}

	@SuppressWarnings("unchecked")
	public List<Product> findAll() {
		EntityManager em = this.emf.createEntityManager();
		List<Product> result = em.createNamedQuery("Product.findAll").getResultList();
		em.close();
		return result;
	}

}
