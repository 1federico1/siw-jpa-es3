package it.uniroma3.db.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import it.uniroma3.db.products.Address;


public class AddressDao extends Dao<Address> {
	
	
	public AddressDao(EntityManagerFactory emf) {
		super(emf);
	}
	
	@Override
	public Address findById(long id) {
		EntityManager em = this.emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Address a = em.find(Address.class, id);
		tx.commit();
		em.close();
		return a;
	}

	@Override
	public List<Address> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
