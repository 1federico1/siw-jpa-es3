package it.uniroma3.db.products;

import java.util.Date;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import it.uniroma3.db.persistence.AddressDao;
import it.uniroma3.db.persistence.CustomerDao;
import it.uniroma3.db.persistence.OrderDao;
import it.uniroma3.db.persistence.ProductDao;

public class Main {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("products-unit");

		CustomerDao customerDao = new CustomerDao(emf);
		AddressDao addressDao = new AddressDao(emf);
		OrderDao orderDao = new OrderDao(emf);
		ProductDao productDao = new ProductDao(emf);

		Product product = new Product("KRIDDIG", "A wonderful bla bla", 3.5F, "123456");

		Product p2 = new Product("prova", "descrizione", 0F, "222");

		Customer paperino = new Customer("paperino", "dePaperoni", "paperino@email.it");

		Order order = new Order();
		order.setCreationTime(new Date());

		Order newOrder = new Order();
		newOrder.setCreationTime(new Date());

		orderDao.save(newOrder);

		OrderLine line1 = new OrderLine(1, 2F);
		line1.setProduct(product);

		OrderLine line2 = new OrderLine(2, 3F);
		line2.setProduct(product);

		order.addOrderLine(line1);
		order.addOrderLine(line2);

		Address address = new Address("via fasulla", "roma", "italy", "00118", "it");

		Address address1 = new Address("via vai", "milano", "italy", "00012", "it");
		addressDao.save(address1);
		address1.setCity("bologna");
		addressDao.update(address1);

		Customer pippo = new Customer("pippo", "pluto", "pippo@pluto.com", address);
		pippo.addOrder(order);

		customerDao.save(pippo);
		customerDao.save(paperino);
		customerDao.delete(paperino);

		emf.close();

	}

}
