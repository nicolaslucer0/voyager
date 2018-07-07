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
	public Offer newOffer(Long orderId, User userSession) {
		ItemOrder itemOrder = itemOrderDao.findOneItemOrderById(orderId);
		if (itemOrder == null) {
			return null;
		}
		Offer offer = new Offer();
		offer.setItemOrder(itemOrder);
		offer.setVoyager(userSession);
		offer.setStatus(Status.NEW);
		offerDao.save(offer);
		return offer;
	}

	@Override
	public List<Offer> findAllByCompradorIdAndStatus(Long id) {
		return offerDao.findAllByCompradorIdAndStatus(id);
	}

}
