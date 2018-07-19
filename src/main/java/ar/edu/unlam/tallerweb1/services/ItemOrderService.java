package ar.edu.unlam.tallerweb1.services;

import java.io.Serializable;
import java.util.List;

import ar.edu.unlam.tallerweb1.model.ItemOrder;
import ar.edu.unlam.tallerweb1.model.Offer;
import ar.edu.unlam.tallerweb1.model.Status;
import ar.edu.unlam.tallerweb1.model.StatusVoyage;
import ar.edu.unlam.tallerweb1.model.User;

/**
 * Servicio encargado de todas las acciones relativos a las ordenes.
 * De acá se puede guardar, buscar, filtrar y todo lo que tenga que ver con eso, se realiza en este service.
 * @author nicol
 *
 */
public interface ItemOrderService {

	/**
	 * Obtiene la lista de TODOS los items, no importa el estado
	 * Normalmente usado por el administrador
	 * 
	 * @return ArrayList de ItemOrder
	 */
	List<ItemOrder> getAllItemOrders();

	/**
	 * Guarda un objeto de ItemOrder
	 *  
	 * @return Boolean: Se guardo con éxito o no.
	 */
	Boolean save(ItemOrder itemOrder);

	/**
	 * Busca un ItemOrder segun un id que se pasa por parametro.
	 *  
	 * @param id : Long - El id del itemOrder
	 * @return ItemOrder completo.
	 */
	ItemOrder findOneItemOrderById(Long id);

	/**
	 * Obtiene la lista de TODOS los items que tengan un estado determinado pasado por parametro
	 * @param status Estado del item, los estados pueden ser: NEW, OFFER, ACCEPTED, REJECTED, CANCELLED 
	 * 
	 * @return ArrayList de ItemOrder
	 */
	List<ItemOrder> findAllItemOrdersByStatus(Status status);
	List<ItemOrder> findAllByCompradorIdAndStatus(Long id, Status status);
	List<ItemOrder> findAllByVoyagerIdAndStatus(Long id, Status status);
	Boolean updateItemOrder(ItemOrder itemOrder);
	List<ItemOrder> findAllItemOrdersByStatusExceptCurrentUser(Long id, Status status);

	/**
	 * Cambia estado y devuelve el itemOrder
	 * @param id id de pedido (#Long)
	 * @param status Estado (Status)
	 * @return ItemOrder
	 */
	ItemOrder changeStatus(Long id, Status status);

	Serializable saveNewItemOrder(ItemOrder itemOrder, User user);
	//Boolean saveTestItemOrder(ItemOrder itemOrder, User user);

	List<ItemOrder> findAllItemOrdersByUser(Long id);

	void deleteOrderAndOffers(Long orderId);

	void setVoyagerToOrder(ItemOrder itemOrder, Offer offer);


}
