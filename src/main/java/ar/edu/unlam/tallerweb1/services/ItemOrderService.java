package ar.edu.unlam.tallerweb1.services;

import java.util.List;

import ar.edu.unlam.tallerweb1.model.ItemOrder;
import ar.edu.unlam.tallerweb1.model.Status;

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
	List<ItemOrder> getAllItemOrdersByStatus(Status status);

	Boolean updateItemOrder(ItemOrder itemOrder);

	ItemOrder changeStatus(Long id, Status offered);

}
