package ar.edu.unlam.tallerweb1.services;

import java.util.List;

import ar.edu.unlam.tallerweb1.dto.OfferDTO;
import ar.edu.unlam.tallerweb1.model.ItemOrder;
import ar.edu.unlam.tallerweb1.model.Offer;
import ar.edu.unlam.tallerweb1.model.Status;
import ar.edu.unlam.tallerweb1.model.User;

public interface OfferService {

	List<OfferDTO> getAllOffers();
	
	List<OfferDTO> getAllOffersByStatus(Status status);

	void save(Offer offer);

	Offer findOneOfferById(Long id);

	Offer newOffer(Long orderId, User userSession);

	List<Offer> findAllMyOfferedOrders(Long id);

	Offer cancelOffer(Long offerId, User userSession);

	List<ItemOrder> findAllByVoyagerId(Long id, Status status);

	List<ItemOrder> findAllActiveOffersByVoyagerId(Long id);

	void cancelAllOffersExceptCurrent(Long offerId, Long orderId);

	Offer changeStatus(Long offerId, Status accepted);


}
