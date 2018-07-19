package ar.edu.unlam.tallerweb1.services.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.ItemOrderDao;
import ar.edu.unlam.tallerweb1.model.ItemOrder;
import ar.edu.unlam.tallerweb1.model.Offer;
import ar.edu.unlam.tallerweb1.model.Status;
import ar.edu.unlam.tallerweb1.model.User;
import ar.edu.unlam.tallerweb1.services.ItemOrderService;

@Service
@Transactional
public class ItemOrderServiceImpl implements ItemOrderService {

	@Inject
	private ItemOrderDao itemOrderDao;
	
	@Override
	public List<ItemOrder> getAllItemOrders() {
		return itemOrderDao.findAllItemOrder();
	}

	@Override
	public Boolean save(ItemOrder itemOrder) {
		return itemOrderDao.save(itemOrder) != null ? true : false;
	}

	@Override
	public ItemOrder findOneItemOrderById(Long id) {
		return itemOrderDao.findOneItemOrderById(id);
	}

	@Override
	public List<ItemOrder> findAllItemOrdersByStatus(Status status) {
		return itemOrderDao.findAllItemOrderByStatus(status);
	}

	@Override
	public Boolean updateItemOrder(ItemOrder itemOrder) {
		return itemOrderDao.update(itemOrder);
	}

	@Override
	@Transactional
	public ItemOrder changeStatus(Long id, Status status, User user) {
		ItemOrder order = findOneItemOrderById(id);
		if (order != null) {
			order.setStatus(status);
			order.setVoyager(user);
		}
		return order;
	}

	@Override
	@Transactional
	public List<ItemOrder> findAllByCompradorIdAndStatus(Long id, Status status) {
		return itemOrderDao.findAllItemOrderByCompradorIdAndStatus(id, status);
	}

	@Override
	public List<ItemOrder> findAllByVoyagerIdAndStatus(Long id, Status status) {
		return itemOrderDao.findAllItemOrderByVoyagerIdAndStatus(id, status);
	}

	@Override
	public void saveNewItemOrder(ItemOrder itemOrder, User user) {
		itemOrder.setComprador(user);
		itemOrder.setStatus(Status.NEW);
		calcularPrecios(itemOrder);
		itemOrderDao.save(itemOrder);
		
	}

	private void calcularPrecios(ItemOrder itemOrder) {
		itemOrder.setPrecioComisionVoyager(itemOrder.getItem().getPrecio().add(itemOrder.getItem().getPrecio().multiply(new BigDecimal("0.10"))));
		itemOrder.setPrecioFinal(itemOrder.getItem().getPrecio().add((itemOrder.getItem().getPrecio().multiply(new BigDecimal("0.10"))).multiply(new BigDecimal("2"))));
	}

	@Override
	public List<ItemOrder> findAllItemOrdersByStatusExceptCurrentUser(Long id, Status status) {
		return itemOrderDao.findAllItemOrdersByStatusExceptCurrentUser(id, status);
	}

	@Override
	public List<ItemOrder> findAllItemOrdersByUser(Long id) {
		return itemOrderDao.findAllItemOrdersByUser(id);
	}

	@Override
	@Transactional
	public void deleteOrderAndOffers(Long orderId) {
		ItemOrder itemOrder = itemOrderDao.deleteOrderAndOffers(orderId);
		itemOrder.setStatus(Status.CANCELLED);
	}

	@Override
	@Transactional
	public void setVoyagerToOrder(ItemOrder itemOrder, Offer offer) {
		itemOrder.setVoyager(offer.getVoyager());
		itemOrderDao.update(itemOrder);
	}

}
