package it.uniroma3.db.products;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "order_line")

public class OrderLine {
	
	public OrderLine() {
		this.products = new ArrayList<>();
	}
	
	public OrderLine(Integer quantity, Float unitPrice) {
		this.products = new ArrayList<>();
		this.unitPrice = unitPrice;
		this.quantity = quantity;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private Float unitPrice;
	
	@Column(nullable = false)
	private Integer quantity;
	
	@OneToMany(fetch=FetchType.LAZY, cascade={CascadeType.PERSIST, CascadeType.REMOVE})
	@JoinColumn(name = "products_id")
	private List<Product> products;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Float getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Float unitPrice) {
		this.unitPrice = unitPrice;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	
	
	public void addProduct(Product p) {
		this.products.add(p);
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
		result = prime * result + ((unitPrice == null) ? 0 : unitPrice.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderLine other = (OrderLine) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		if (unitPrice == null) {
			if (other.unitPrice != null)
				return false;
		} else if (!unitPrice.equals(other.unitPrice))
			return false;
		return true;
	}
	
	
	
	

}
