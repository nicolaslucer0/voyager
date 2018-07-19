package ar.edu.unlam.tallerweb1.dao;

import java.io.Serializable;
import java.util.List;

import ar.edu.unlam.tallerweb1.model.ItemOrder;
import ar.edu.unlam.tallerweb1.model.Status;
import ar.edu.unlam.tallerweb1.model.StatusVoyage;

public interface ItemOrderDao {

	Serializable save(ItemOrder itemOrder);

	List<ItemOrder> findAllItemOrder();

	ItemOrder findOneItemOrderById(Long id);

	List<ItemOrder> findAllItemOrderByStatus(Status status);

	Boolean update(ItemOrder itemOrder);

	List<ItemOrder> findAllItemOrderByCompradorIdAndStatus(Long id, Status status);

	List<ItemOrder> findAllItemOrderByVoyagerIdAndStatus(Long id, Status status);

	List<ItemOrder> findAllItemOrdersByStatusExceptCurrentUser(Long id, Status status);

	List<ItemOrder> findAllItemOrdersByUser(Long id);

	ItemOrder deleteOrderAndOffers(Long orderId);

	List<ItemOrder> findAllByCompradorIdAndStatusAndStatusVoyage(Long id, Status status, StatusVoyage statusVoyage);

}
