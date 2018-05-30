package ar.edu.unlam.tallerweb1.services.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.dao.OfferDao;
import ar.edu.unlam.tallerweb1.dto.OfferDTO;
import ar.edu.unlam.tallerweb1.services.OfferService;

@Service
public class OfferServiceImpl implements OfferService {

	@Inject
	private OfferDao offerDao;
	@Override
	public List<OfferDTO> getAllOffers() {
		return offerDao.getAllOffers();
	}

	@Override
	public List<OfferDTO> getAllOffersAsView() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
