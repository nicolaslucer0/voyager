package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.dto.OfferDTO;
import ar.edu.unlam.tallerweb1.model.Offer;
import ar.edu.unlam.tallerweb1.model.Status;

public interface OfferDao {

	List<OfferDTO> getAllOffers();

	List<OfferDTO> getAllOffersByStatus(Status status);

	void save(Offer offer);

	Offer findOneOfferById(Long id);

}
