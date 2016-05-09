package it.uniroma3.db.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import it.uniroma3.db.products.Product;

public class ProductDao extends Dao<Product> {

	public ProductDao(EntityManagerFactory emf) {
		super(emf);
	}

	@Override
	public Product findById(long id) {
		EntityManager em = this.emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Product c = em.find(Product.class, id);
		tx.commit();
		em.close();
		return c;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Product> findAll() {
		EntityManager em = this.emf.createEntityManager();
		List<Product> result = em.createNamedQuery("Product.findAll").getResultList();
		em.close();
		return result;
	}

}
