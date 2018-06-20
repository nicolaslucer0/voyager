package ar.edu.unlam.tallerweb1.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.dao.ItemOrderDao;
import ar.edu.unlam.tallerweb1.model.ItemOrder;
import ar.edu.unlam.tallerweb1.model.Status;

@Repository
public class ItemOrderDaoImpl implements ItemOrderDao {
	
	@Inject
    private SessionFactory sessionFactory;
	
	@Override
	public Serializable save(ItemOrder itemOrder) {
		Serializable id = sessionFactory.getCurrentSession().save(itemOrder);
		return id;
		}

	@SuppressWarnings("unchecked")
	@Override
	public List<ItemOrder> getAllItemOrder() {
			return sessionFactory.getCurrentSession().createCriteria(ItemOrder.class).list();
	}

	@Override
	public ItemOrder findOneItemOrderById(Long id) {
		return (ItemOrder) sessionFactory.getCurrentSession().createCriteria(ItemOrder.class)
				.add(Restrictions.eq("id", id))
				.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ItemOrder> getAllItemOrderByStatus(Status status) {
		return sessionFactory.getCurrentSession().createCriteria(ItemOrder.class)
				.add(Restrictions.eq("status", status))
				.list();
	}

	@Override
	public Boolean update(ItemOrder itemOrder) {
		 sessionFactory.getCurrentSession().update(itemOrder);
		 return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ItemOrder> getAllItemOrderByCompradorIdAndStatus(Long id) {
		return sessionFactory.getCurrentSession().createCriteria(ItemOrder.class)
				.add(Restrictions.eq("comprador.id", id))
				.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ItemOrder> getAllItemOrderByVoyagerIdAndStatus(Long id) {
		return sessionFactory.getCurrentSession().createCriteria(ItemOrder.class)
				.add(Restrictions.eq("voyager.id", id))
				.list();
	}

}
