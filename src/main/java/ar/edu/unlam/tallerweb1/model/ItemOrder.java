package ar.edu.unlam.tallerweb1.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ItemOrder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String description;
	private BigDecimal precioSinComision;
	private BigDecimal precioFinal;
	private String paisOrigen;
	private String paisDestino;

	@Enumerated(EnumType.STRING)
	private Status status;
	
	@ManyToOne
	private User comprador;

	@ManyToOne
	private User voyager;
	
	@ManyToOne
	private Item item;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BigDecimal getPrecioSinComision() {
		return precioSinComision;
	}
	public void setPrecioSinComision(BigDecimal precioSinComision) {
		this.precioSinComision = precioSinComision;
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
	public String getPaisDestino() {
		return paisDestino;
	}
	public void setPaisDestino(String paisDestino) {
		this.paisDestino = paisDestino;
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
