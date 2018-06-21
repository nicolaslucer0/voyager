package ar.edu.unlam.tallerweb1.dao;

import java.io.Serializable;
import java.util.List;

import ar.edu.unlam.tallerweb1.model.ItemOrder;
import ar.edu.unlam.tallerweb1.model.Status;

public interface ItemOrderDao {

	Serializable save(ItemOrder itemOrder);

	List<ItemOrder> getAllItemOrder();

	ItemOrder findOneItemOrderById(Long id);

	List<ItemOrder> getAllItemOrderByStatus(Status status);

	Boolean update(ItemOrder itemOrder);

	List<ItemOrder> getAllItemOrderByCompradorIdAndStatus(Long id, Status status);

	List<ItemOrder> getAllItemOrderByVoyagerIdAndStatus(Long id, Status status);

}
