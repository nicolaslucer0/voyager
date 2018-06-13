package ar.edu.unlam.tallerweb1.controllers;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.model.Item;
import ar.edu.unlam.tallerweb1.model.ItemOrder;
import ar.edu.unlam.tallerweb1.model.Status;
import ar.edu.unlam.tallerweb1.services.ItemOrderService;

@Controller
@RequestMapping("/order")
public class ItemOrderController {

	@Inject
	private ItemOrderService itemOrderService;
	
	/**
	 * Listado de pedidos con estado NEW
	 * @return ModelAndView : La pagina JSP que muestra el listado y el objeto lista de orderItem.
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listNewItemOrders() {
		ModelMap itemOrders = new ModelMap();
		String mensaje = " ";
		if(itemOrderService.getAllItemOrdersByStatus(Status.NEW).size()==0){	
			mensaje = "<div class='alert alert-danger' role='alert'>No hay solicitudes de compradores de momento, vuelva mas tarde.</div>";
			itemOrders.put("mensajeError", mensaje);			
		}else{
			itemOrders.put("itemOrders", itemOrderService.getAllItemOrdersByStatus(Status.NEW));			
		}
		
		return new ModelAndView("itemOrders", itemOrders);
	}

	/**
	 * Este action, se utiliza cuando se quiere ir a la pagina de "Crear un nuevo pedido"
	 * @return ModelAndView: La pagina JSP que muestra el formulario de nuevo y el item dentro de order.
	 */
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public ModelAndView newItemOrder() {
		ModelMap itemOrder = new ModelMap();
		Item item = new Item();
		ItemOrder newItemOrder = new ItemOrder();
		newItemOrder.setItem(item);
		itemOrder.put("itemOrder", newItemOrder);
		return new ModelAndView("createItemOrder", itemOrder);
	}

	/**
	 * Se utiliza para el boton "guardar" del formuario.
	 * @param itemOrder: Recibe el pedido entero que viene del formulario 
	 * @return ModelAndView: La pagina JSP de exito o error depende si se guard� o no con un mensaje para poner el el JSP.
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView saveItemOrder(@ModelAttribute ItemOrder itemOrder) {
		ModelMap messagesMap = new ModelMap();
		String pagina;
		itemOrder.setStatus(Status.NEW);
		if (itemOrderService.save(itemOrder)) {
			String message = "Pedido generado con �xito.";
			messagesMap .put("mensaje1",message);
			pagina = "successOrder";
		} else {
			String message = "Error al generar orden, alguno de los datos no fue completado correctamente.";
			messagesMap .put("mensaje1",message);
			pagina = "errorOrder";
		}
		return new ModelAndView(pagina, messagesMap);
	}

	/**
	 * Es llamado desde el boton "editar pedido", directamente le llega el id del client side.
	 * @param id: Numero de pedido
	 * @return ModelAndView: La pagina JSP del formulario (el mismo de nuevo item) pero con los campos completados.
	 * NOTA: El boton guardar, lleva otra vez al controller de guardar.
	 */
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editItemOrder(@PathVariable Long id) {
		ModelMap itemOrder = new ModelMap();
		itemOrder.addAttribute("itemOrders", itemOrderService.findOneItemOrderById(id));
		return new ModelAndView("itemOrderForm", itemOrder);
	}
	
	/**
	 * Ver detalles del pedido
	 * @param id del pedido
	 * @return
	 */
	@RequestMapping (value = "/{id}", method = RequestMethod.GET)
	public ModelAndView viewItemOrderDetails(@PathVariable Long id) {
		ModelMap itemOrder = new ModelMap();
		itemOrder.addAttribute("itemOrders", itemOrderService.findOneItemOrderById(id));
		return new ModelAndView("itemOrderDetail", itemOrder);
	} 
}
