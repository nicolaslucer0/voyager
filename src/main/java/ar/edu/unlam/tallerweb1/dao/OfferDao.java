package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.dto.OfferDTO;
import ar.edu.unlam.tallerweb1.model.ItemOrder;
import ar.edu.unlam.tallerweb1.model.Offer;
import ar.edu.unlam.tallerweb1.model.Status;
import ar.edu.unlam.tallerweb1.model.StatusVoyage;

public interface OfferDao {

	List<OfferDTO> getAllOffers();

	List<OfferDTO> getAllOffersByStatus(Status status);

	void save(Offer offer);

	Offer findOneOfferById(Long id);

	List<Offer> findAllMyOfferedOrders(Long id);

	List<ItemOrder> findAllByVoyagerId(Long id, Status status);

	List<ItemOrder> findAllActiveOffersByVoyagerId(Long id);

	List<Offer> findAllOffersByItemOrderExceptCurrent(Long offerId, Long itemOrderId);

	Offer findOneOfferByOrderIdAndUserAndStatus(Long id, Long user, StatusVoyage status);

}
