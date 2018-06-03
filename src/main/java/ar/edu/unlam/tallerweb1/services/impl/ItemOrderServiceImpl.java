package ar.edu.unlam.tallerweb1.services.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.ItemOrderDao;
import ar.edu.unlam.tallerweb1.model.ItemOrder;
import ar.edu.unlam.tallerweb1.model.Status;
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
}
