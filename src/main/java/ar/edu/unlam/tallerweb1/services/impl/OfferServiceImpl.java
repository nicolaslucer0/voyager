package ar.edu.unlam.tallerweb1.services.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.OfferDao;
import ar.edu.unlam.tallerweb1.dto.OfferDTO;
import ar.edu.unlam.tallerweb1.model.Offer;
import ar.edu.unlam.tallerweb1.model.Status;
import ar.edu.unlam.tallerweb1.services.OfferService;

@Service
@Transactional
public class OfferServiceImpl implements OfferService {

	@Inject
	private OfferDao offerDao;
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

	
}
