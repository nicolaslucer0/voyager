package ar.edu.unlam.tallerweb1.model;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ItemOrder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private BigDecimal precioComisionVoyager;
	private BigDecimal precioFinal;
	private String paisOrigen;

	@Enumerated(EnumType.STRING)
	private Status status;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private User comprador;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private User voyager;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Item item;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public BigDecimal getPrecioComisionVoyager() {
		return precioComisionVoyager;
	}
	public void setPrecioComisionVoyager(BigDecimal precioComisionVoyager) {
		this.precioComisionVoyager = precioComisionVoyager;
	}
	public BigDecimal getPrecioFinal() {
		return precioFinal;
	}
	public void setPrecioFinal(BigDecimal precioFinal) {
		this.precioFinal = precioFinal;
	}
	public String getPaisOrigen() {
		return paisOrigen;
	}
	public void setPaisOrigen(String paisOrigen) {
		this.paisOrigen = paisOrigen;
	}
	public User getComprador() {
		return comprador;
	}
	public void setComprador(User comprador) {
		this.comprador = comprador;
	}
	public User getVoyager() {
		return voyager;
	}
	public void setVoyager(User voyager) {
		this.voyager = voyager;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}

	
}
