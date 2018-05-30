package ar.edu.unlam.tallerweb1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Offer {

	public static enum Status {
	    PENDING,
	    ACCEPTED,
	    REJECTED;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;
	
//	private User comprador;
	
//	private User voyager;
	
//	@Column (columnDefinition = "varchar")
//	private Status status;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


}
