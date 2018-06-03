package ar.edu.unlam.tallerweb1.services;

import java.util.List;

import ar.edu.unlam.tallerweb1.dto.OfferDTO;
import ar.edu.unlam.tallerweb1.model.Offer;
import ar.edu.unlam.tallerweb1.model.Status;

public interface OfferService {

	List<OfferDTO> getAllOffers();
	
	List<OfferDTO> getAllOffersByStatus(Status status);

	void save(Offer offer);

	Object findOneOfferById(Long id);

}
