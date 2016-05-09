package it.uniroma3.db.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import it.uniroma3.db.products.Provider;

public class ProviderDao extends Dao<Provider> {

	public ProviderDao(EntityManagerFactory emf) {
		super(emf);
	}

	@Override
	public Provider findById(long id) {
		EntityManager em = this.emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Provider c = em.find(Provider.class, id);
		tx.commit();
		em.close();
		return c;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Provider> findAll() {
		EntityManager em = this.emf.createEntityManager();
		List<Provider> result = em.createNamedQuery("Provider.findAll").getResultList();
		em.close();
		return result;
	}
}
