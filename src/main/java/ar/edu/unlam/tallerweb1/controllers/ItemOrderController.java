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
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ModelAndView listNewItemOrders() {
		ModelMap itemOrders = new ModelMap();
		itemOrders.put("itemOrders", itemOrderService.getAllItemOrdersByStatus(Status.NEW));
		return new ModelAndView("itemOrders", itemOrders);
	}

	/**
	 * Este action, se utiliza cuando se quiere ir a la pagina de "Crear un nuevo pedido"
	 * @return ModelAndView: La pagina JSP que muestra el formulario de nuevo y el item dentro de order.
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView newItemOrder() {
		ModelMap itemOrder = new ModelMap();
		Item item = new Item();
		ItemOrder newItemOrder = new ItemOrder();
		newItemOrder.setItem(item);
		itemOrder.addAttribute("itemOrder", newItemOrder);
		return new ModelAndView("itemOrderForm", itemOrder);
	}

	/**
	 * Se utiliza para el boton "guardar" del formuario.
	 * @param itemOrder: Recibe el pedido entero que viene del formulario 
	 * @return ModelAndView: La pagina JSP de exito o error depende si se guard� o no con un mensaje para poner el el JSP.
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView saveItemOrder(@ModelAttribute ItemOrder itemOrder) {
		ModelMap mensajes = new ModelMap();
		String pagina;
		if (itemOrderService.save(itemOrder)) {
			String mensaje = "Order generada con �xito.";
			mensajes.put("mensaje1",mensaje);
			pagina = "exito";
		} else {
			String mensaje = "Error al generar orden, alguno de los datos no fue completado correctamente.";
			mensajes.put("mensaje1",mensaje);
			pagina = "error";
		}
		return new ModelAndView(pagina, mensajes);
	}

	/**
	 * Es llamado desde el boton "editar pedido", directamente le llega el id del client side.
	 * @param id: Numero de pedido
	 * @return ModelAndView: La pagina JSP del formulario (el mismo de nuevo item) pero con los campos completados.
	 * NOTA: El boton guardar, lleva otra vez al controller de guardar.
	 */
	@RequestMapping(value = "/itemOrder/{id}", method = RequestMethod.GET)
	public ModelAndView editItemOrder(@PathVariable Long id) {
		ModelMap itemOrder = new ModelMap();
		itemOrder.addAttribute("itemOrders", itemOrderService.findOneItemOrderById(id));
		return new ModelAndView("itemOrderForm", itemOrder);
	}
}
