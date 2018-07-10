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
	public List<ItemOrder> findAllItemOrder() {
		return sessionFactory.getCurrentSession().createCriteria(ItemOrder.class).list();
	}

	@Override
	public ItemOrder findOneItemOrderById(Long id) {
		return (ItemOrder) sessionFactory.getCurrentSession().createCriteria(ItemOrder.class)
				.add(Restrictions.eq("id", id)).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ItemOrder> findAllItemOrderByStatus(Status status) {
		return sessionFactory.getCurrentSession().createCriteria(ItemOrder.class).add(Restrictions.eq("status", status))
				.list();
	}

	@Override
	public Boolean update(ItemOrder itemOrder) {
		sessionFactory.getCurrentSession().update(itemOrder);
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ItemOrder> findAllItemOrderByCompradorIdAndStatus(Long id, Status status) {
		if (Status.ALL.equals(status)) {
			return sessionFactory.getCurrentSession().createCriteria(ItemOrder.class)
					.add(Restrictions.eq("comprador.id", id))
					.list();
		} else {
			return sessionFactory.getCurrentSession().createCriteria(ItemOrder.class)
				.add(Restrictions.eq("comprador.id", id))
				.add(Restrictions.eq("status", status))
				.list();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ItemOrder> findAllItemOrderByVoyagerIdAndStatus(Long id, Status status) {
		return sessionFactory.getCurrentSession().createCriteria(ItemOrder.class)
				.add(Restrictions.eq("status", status))
				.add(Restrictions.eq("voyager.id", id))
				.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ItemOrder> findAllItemOrdersByStatusExceptCurrentUser(Long id, Status status) {
		if (id != null) {
			if (Status.ALL.equals(status)) {
				return sessionFactory.getCurrentSession().createCriteria(ItemOrder.class)
						.add(Restrictions.ne("comprador.id", id)).list();
			} else {
				return sessionFactory.getCurrentSession().createCriteria(ItemOrder.class)
						.add(Restrictions.eq("status", status)).add(Restrictions.ne("comprador.id", id)).list();
			}
		} else {
			if (Status.ALL.equals(status)) {
				return sessionFactory.getCurrentSession().createCriteria(ItemOrder.class).list();
			} else {
				return sessionFactory.getCurrentSession().createCriteria(ItemOrder.class)
						.add(Restrictions.eq("status", status)).list();
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ItemOrder> findAllItemOrdersByUser(Long id) {
		return sessionFactory.getCurrentSession().createCriteria(ItemOrder.class)
				.add(Restrictions.eq("comprador.id", id)).list();
	}

}
