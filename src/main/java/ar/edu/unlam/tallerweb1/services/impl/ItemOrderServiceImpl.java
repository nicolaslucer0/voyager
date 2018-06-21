package ar.edu.unlam.tallerweb1.services.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.ItemOrderDao;
import ar.edu.unlam.tallerweb1.model.ItemOrder;
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
		return itemOrderDao.getAllItemOrder();
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
	public List<ItemOrder> getAllItemOrdersByStatus(Status status) {
		return itemOrderDao.getAllItemOrderByStatus(status);
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
		return itemOrderDao.getAllItemOrderByCompradorIdAndStatus(id, status);
	}

	@Override
	public List<ItemOrder> findAllByVoyagerIdAndStatus(Long id, Status status) {
		return itemOrderDao.getAllItemOrderByVoyagerIdAndStatus(id, status);
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

}
