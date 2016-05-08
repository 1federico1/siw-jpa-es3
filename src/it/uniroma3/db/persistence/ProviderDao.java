package it.uniroma3.db.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import it.uniroma3.db.products.Provider;

public class ProviderDao implements Dao<Provider>{
	private  EntityManagerFactory emf;

	public ProviderDao(EntityManagerFactory emf) {
		this.emf = emf;
	}

	public void save(Provider c) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(c);
		tx.commit();
		em.close();

	}

	public Provider findById(long id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Provider c = em.find(Provider.class, id);
		tx.commit();
		em.close();
		return c;
	}

	public void delete(Provider c) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Provider toRemove = em.merge(c);
		em.remove(toRemove);
		tx.commit();		
		em.close();

	}

	public void update(Provider c) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(c);
		tx.commit();
		em.close();
		

	}

	@SuppressWarnings("unchecked")
	public List<Provider> findAll() {
		EntityManager em = emf.createEntityManager();
		List<Provider> result = em.createNamedQuery("Provider.findAll").getResultList();
		em.close();
		return result;
	}
}
