package ar.edu.unlam.tallerweb1.controllers;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.model.Item;
import ar.edu.unlam.tallerweb1.model.ItemOrder;
import ar.edu.unlam.tallerweb1.model.Offer;
import ar.edu.unlam.tallerweb1.model.Status;
import ar.edu.unlam.tallerweb1.model.User;
import ar.edu.unlam.tallerweb1.services.ItemOrderService;
import ar.edu.unlam.tallerweb1.services.LoginService;
import ar.edu.unlam.tallerweb1.services.OfferService;

@Controller
@RequestMapping("/order")
public class ItemOrderController {

	@Inject
	private ItemOrderService itemOrderService;

	@Inject
	private LoginService loginService;

	@Inject
	private OfferService offerService;

	/**
	 * Listado de pedidos con estado ALL y que no pertenezcan al usuario en cuestion (Si es que está loggeado)
	 * @return ModelAndView : La pagina JSP que muestra el listado y el objeto lista de orderItem.
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listNewItemOrders(HttpServletRequest request) {
		User userSession = loginService.getSession(request);
		ModelMap modelMap = new ModelMap();
		modelMap.put("userSession", userSession);
		if (userSession == null) {
			List<ItemOrder> itemOrders = itemOrderService.findAllItemOrdersByStatus(Status.NEW);
			modelMap.put("itemOrders", itemOrders.size() != 0 ? itemOrders : null );	
		} else {
			List<ItemOrder> itemOrders = itemOrderService.findAllItemOrdersByStatusExceptCurrentUser(userSession.getId(), Status.NEW);
			modelMap.put("itemOrders", itemOrders.size() != 0 ? itemOrders : null );	
		}
		return new ModelAndView("itemOrders", modelMap);
	}
	
	@RequestMapping(value= "/all", method = RequestMethod.GET)
	public ModelAndView listAllItemOrders(HttpServletRequest request) {
		User userSession = loginService.getSession(request);
		if (userSession == null)
			return new ModelAndView("redirect:/login");		
		ModelMap modelMap = new ModelMap();
		modelMap.put("userSession", userSession);
		List<ItemOrder> itemOrders = itemOrderService.findAllByCompradorIdAndStatus(userSession.getId(), Status.ALL);
		modelMap.put("itemOrders", itemOrders.size() != 0 ? itemOrders : null );	
		return new ModelAndView("itemOrders", modelMap);
	}

	/**
	 * Este action, se utiliza cuando se quiere ir a la pagina de "Crear un nuevo pedido"
	 * @return ModelAndView: La pagina JSP que muestra el formulario de nuevo y el item dentro de order.
	 */
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public ModelAndView newItemOrder(HttpServletRequest request) {
		User userSession = loginService.getSession(request);
		if (userSession == null)
			return new ModelAndView("redirect:/login");
		ModelMap modelMap = new ModelMap();
		modelMap.put("userSession", userSession);;
		Item item = new Item();
		ItemOrder newItemOrder = new ItemOrder();
		newItemOrder.setItem(item);
		modelMap.put("itemOrder", newItemOrder);
			return new ModelAndView("createItemOrder", modelMap);
	}

	/**
	 * Se utiliza para el boton "guardar" del formuario.
	 * @param itemOrder: Recibe el pedido entero que viene del formulario 
	 * @return ModelAndView: La pagina JSP de exito o error depende si se guardó o no con un mensaje para poner el el JSP.
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView saveItemOrder(@ModelAttribute ItemOrder itemOrder, HttpServletRequest request) {
		User userSession = loginService.getSession(request);
		if (userSession == null)
			return new ModelAndView("redirect:/login");
		ModelMap modelMap = new ModelMap();
		modelMap.put("userSession", userSession);
		itemOrderService.saveNewItemOrder(itemOrder, userSession);
		modelMap.put("message1", "Pedido generado con éxito.");
		return new ModelAndView("successOrder", modelMap);
	}

	/**
	 * Es llamado desde el boton "editar pedido", directamente le llega el id del client side.
	 * @param id: Numero de pedido
	 * @return ModelAndView: La pagina JSP del formulario (el mismo de nuevo item) pero con los campos completados.
	 * NOTA: El boton guardar, lleva otra vez al controller de guardar.
	 */
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editItemOrder(@PathVariable Long id, HttpServletRequest request) {
		User userSession = (User) loginService.getSession(request);
		if (userSession == null)
			return new ModelAndView("redirect:/login");
		ModelMap modelMap = new ModelMap();
		modelMap.put("userSession", userSession);
		modelMap.addAttribute("itemOrders", itemOrderService.findOneItemOrderById(id));
		return new ModelAndView("itemOrderForm", modelMap);
	}
	
	/**
	 * Ver detalles del pedido
	 * @param id del pedido
	 * @return
	 */
	@RequestMapping (value = "/{id}", method = RequestMethod.GET)
	public ModelAndView viewItemOrderDetails(@PathVariable Long id, HttpServletRequest request) {
		User userSession = loginService.getSession(request);
		ModelMap modelMap = new ModelMap();
		modelMap.put("userSession", userSession);
		modelMap.addAttribute("itemOrders", itemOrderService.findOneItemOrderById(id));
		return new ModelAndView("itemOrderDetail", modelMap);
	}
	
	/**
	 * Mis pedidos nuevos
	 * @param request
	 * @return
	 */
	@RequestMapping (value = "/myOrders", method = RequestMethod.GET)
	public ModelAndView viewItemOrdersByComprador(HttpServletRequest request) {
		User userSession = loginService.getSession(request);
		if (userSession == null)
			return new ModelAndView("redirect:/login");
		ModelMap modelMap = new ModelMap();
		modelMap.put("userSession", userSession);
		if (userSession != null) {
			List <ItemOrder> itemOrders = itemOrderService.findAllByCompradorIdAndStatus(userSession.getId(), Status.NEW);
			modelMap.put("itemOrders", itemOrders);
		}
		return new ModelAndView("itemOrdersByUser", modelMap);
	}
	
	/**
	 * MIS VIAJES
	 * @param request
	 * @return lista de ordenes with #Status.NEW
	 */
	@RequestMapping (value = "/myVoyages", method = RequestMethod.GET)
	public ModelAndView viewItemOrdersByVoyager(HttpServletRequest request) {
		User userSession = loginService.getSession(request);
		if (userSession == null)
			return new ModelAndView("redirect:/login");
		ModelMap modelMap = new ModelMap();
		modelMap.put("userSession", userSession);
		if (userSession != null) {
			List <ItemOrder> itemOrders = itemOrderService.findAllByVoyagerIdAndStatus(userSession.getId(), Status.NEW);
			modelMap.put("itemOrders", itemOrders.size() != 0 ? itemOrders : null);
		}
		return new ModelAndView("itemOrdersByUser", modelMap);
	}
	
	/**
	 * Nuestros pedidos que alguien ofertó.
	 * @param request
	 * @return Lista de pedidos ya ofertados por alguien
	 */
	@RequestMapping(value = "/myOrders/offered", method = RequestMethod.GET)
	public ModelAndView viewAllOfferedOrders(HttpServletRequest request) {
		User userSession = loginService.getSession(request);
		if (userSession == null)
			return new ModelAndView("redirect:/login");
		ModelMap modelMap = new ModelMap();
		modelMap.put("userSession", userSession);
		List<Offer> offers = offerService.findAllByCompradorIdAndStatus(userSession.getId());
		modelMap.addAttribute("itemOrders", offers);
		return new ModelAndView("myOfferedOrders",modelMap);
	}
	
}
