package ar.edu.unlam.tallerweb1.dao.impl;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.dao.OfferDao;
import ar.edu.unlam.tallerweb1.dto.OfferDTO;
import ar.edu.unlam.tallerweb1.model.ItemOrder;
import ar.edu.unlam.tallerweb1.model.Offer;
import ar.edu.unlam.tallerweb1.model.Status;

@Repository
public class OfferDaoImpl implements OfferDao {

	@Inject
    private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<OfferDTO> getAllOffers() {
		return sessionFactory.getCurrentSession().createCriteria(Offer.class).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OfferDTO> getAllOffersByStatus(Status status) {
		return sessionFactory.getCurrentSession().createCriteria(Offer.class)
				.add(Restrictions.eq("status", status.toString()))
				.list();
	}

	@Override
	public void save(Offer offer) {
		sessionFactory.getCurrentSession().save(offer);
	}

	@Override
	public Offer findOneOfferById(Long id) {
		return (Offer) sessionFactory.getCurrentSession().createCriteria(Offer.class)
				.add(Restrictions.eq("id", id)).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Offer> findAllByCompradorIdAndStatus(Long id) {
		return  sessionFactory.getCurrentSession().createCriteria(Offer.class)
				.createAlias("itemOrder", "itemOrderFound")
				.createAlias("itemOrderFound.comprador", "compradorBuscado")
				.add(Restrictions.eq("compradorBuscado.id", id)).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ItemOrder> findAllByVoyagerId(Long id, Status status) {
		return sessionFactory.getCurrentSession().createCriteria(Offer.class)
				.createAlias("Voyager", "voyager")
				.add(Restrictions.eq("voyager.id", id))
				.add(Restrictions.eq("status", status))
				.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ItemOrder> findAllActiveOffersByVoyagerId(Long id) {
		return sessionFactory.getCurrentSession().createCriteria(Offer.class)
				.createAlias("Voyager", "voyager")
				.add(Restrictions.eq("voyager.id", id))
				.add(Restrictions.ne("status", Status.CANCELLED))
				.list();
	}


}
