package ar.edu.unlam.tallerweb1.services.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.ItemOrderDao;
import ar.edu.unlam.tallerweb1.dao.OfferDao;
import ar.edu.unlam.tallerweb1.dto.OfferDTO;
import ar.edu.unlam.tallerweb1.model.ItemOrder;
import ar.edu.unlam.tallerweb1.model.Offer;
import ar.edu.unlam.tallerweb1.model.Status;
import ar.edu.unlam.tallerweb1.model.User;
import ar.edu.unlam.tallerweb1.services.OfferService;

@Service
@Transactional
public class OfferServiceImpl implements OfferService {

	@Inject
	private OfferDao offerDao;
	
	@Inject
	private ItemOrderDao itemOrderDao;
	
	@Override
	public List<OfferDTO> getAllOffers() {
		return offerDao.getAllOffers();
	}

	@Override
	public List<OfferDTO> getAllOffersByStatus(Status status) {
		return offerDao.getAllOffersByStatus(status);
	}

	@Override
	public void save(Offer offer) {
		offerDao.save(offer);
	}

	@Override
	public Offer findOneOfferById(Long id) {
		return offerDao.findOneOfferById(id);
	}

	@Override
	@Transactional
	public Offer newOffer(Long orderId, User userSession) {
		ItemOrder itemOrder = itemOrderDao.findOneItemOrderById(orderId);
		if (itemOrder == null) {
			return null;
		}
		Offer offer = new Offer();
		offer.setItemOrder(itemOrder);
		offer.setVoyager(userSession);
		offer.setStatus(Status.OFFERED);
		offerDao.save(offer);
		return offer;
	}

	@Override
	public List<Offer> findAllMyOfferedOrders(Long id) {
		return offerDao.findAllMyOfferedOrders(id);
	}

	@Override
	public Offer cancelOffer(Long offerId, User userSession) {
		Offer offer = offerDao.findOneOfferById(offerId);
		offer.setStatus(Status.CANCELLED);
		return offer;
	}

	@Override
	public List<ItemOrder> findAllByVoyagerId(Long id, Status status) {
		return offerDao.findAllByVoyagerId(id, status);
	}

	@Override
	public List<ItemOrder> findAllActiveOffersByVoyagerId(Long id) {
		return offerDao.findAllActiveOffersByVoyagerId(id);
	}

	@Override
	@Transactional
	public void cancelAllOffersExceptCurrent(Long offerId, Long orderId) {
		List <Offer> offers = offerDao.findAllOffersByItemOrderExceptCurrent(offerId, orderId);
		for (Offer offer : offers) {
			offer.setStatus(Status.CANCELLED);
		}
	}

	@Override
	@Transactional
	public Offer changeStatus(Long offerId, Status status) {
		Offer offer = offerDao.findOneOfferById(offerId);
		offer.setStatus(status);
		return offer;
	}

}
