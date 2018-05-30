package ar.edu.unlam.tallerweb1.services;

import java.util.List;

import ar.edu.unlam.tallerweb1.dto.OfferDTO;

public interface OfferService {

	List<OfferDTO> getAllOffers();

	List<OfferDTO> getAllOffersAsView();

}
