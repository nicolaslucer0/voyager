package ar.edu.unlam.tallerweb1.controllers;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mercadopago.MP;

import ar.edu.unlam.tallerweb1.dto.mercadolibre.MLItem;
import ar.edu.unlam.tallerweb1.model.Item;
import ar.edu.unlam.tallerweb1.model.ItemOrder;
import ar.edu.unlam.tallerweb1.model.Offer;
import ar.edu.unlam.tallerweb1.model.Status;
import ar.edu.unlam.tallerweb1.model.StatusVoyage;
import ar.edu.unlam.tallerweb1.model.User;
import ar.edu.unlam.tallerweb1.services.ItemOrderService;
import ar.edu.unlam.tallerweb1.services.LoginService;
import ar.edu.unlam.tallerweb1.services.MercadoLibreService;
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
	
	@Inject
	private MercadoLibreService mercadolibreService;

	public void setItemOrderService(ItemOrderService itemOrderServiceMock) {
		this.itemOrderService = itemOrderServiceMock;
	}

	public void setLoginService(LoginService loginServiceMock) {
		this.loginService = loginServiceMock;
	}

	public void setOfferService(OfferService offerServiceMock) {
		this.offerService = offerServiceMock;
	}

	public void setMercadolibreService(MercadoLibreService mercadolibreServiceMock) {
		this.mercadolibreService = mercadolibreServiceMock;
	}

	/**
	 * Listado de pedidos con estado ALL y que no pertenezcan al usuario en cuestion (Si es que est� loggeado)
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
		return new ModelAndView("myItemOrders", modelMap);
	}

	/**
	 * Se utiliza para el boton "guardar" del formuario.
	 * @param itemOrder: Recibe el pedido entero que viene del formulario 
	 * @return ModelAndView: La pagina JSP de exito o error depende si se guard� o no con un mensaje para poner el el JSP.
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView saveItemOrder(@ModelAttribute ItemOrder itemOrder, HttpServletRequest request) {
		User userSession = loginService.getSession(request);
		if (userSession == null)
			return new ModelAndView("redirect:/login");
		ModelMap modelMap = new ModelMap();
		modelMap.put("userSession", userSession);
		itemOrderService.saveNewItemOrder(itemOrder, userSession);
		return new ModelAndView("redirect:/order/myOrders");
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
	 * Mis pedidos nuevos
	 * @param request
	 * @return
	 */
	@RequestMapping (value = "/myOrders")
	public ModelAndView viewItemOrdersByComprador(HttpServletRequest request) {
		User userSession = loginService.getSession(request);
		if (userSession == null)
			return new ModelAndView("redirect:/login");
		ModelMap modelMap = new ModelMap();
		modelMap.put("userSession", userSession);
		if (userSession != null) {
			List <ItemOrder> itemOrders = itemOrderService.findAllByCompradorIdAndStatus(userSession.getId(), Status.NEW);
			modelMap.put("itemOrders", itemOrders.size() != 0 ? itemOrders : null);
		}
		return new ModelAndView("myItemOrders", modelMap);
	}

	@RequestMapping (value = "/cancel/{orderId}")
	public ModelAndView cancelItemOrder(@PathVariable Long orderId, HttpServletRequest request) {
		User userSession = loginService.getSession(request);
		if (userSession == null)
			return new ModelAndView("redirect:/login");
		ModelMap modelMap = new ModelMap();
		modelMap.put("userSession", userSession);
		if (userSession != null) {
			itemOrderService.deleteOrderAndOffers(orderId);
		}
		return new ModelAndView("redirect:/order/myOrders");
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
	 * Nuestros pedidos que alguien ofert�.
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
		List<Offer> offers = offerService.findAllMyOfferedOrders(userSession.getId());
		modelMap.addAttribute("itemOrders", offers.size() != 0 ? offers : null);
		return new ModelAndView("myOfferedOrders",modelMap);
	}
	
	@RequestMapping(value = "/myOrders/getMPLink", method = RequestMethod.GET)
	@ResponseBody
	public String getMPLink(@RequestParam("orderId") Long orderId, @RequestParam("offerId") Long offerId, HttpServletRequest request) throws JSONException, Exception {
		ItemOrder item = this.itemOrderService.findOneItemOrderById(orderId);
		
		String payload = String.format(Locale.US, "{ 'items': [ { 'title': '%s', 'quantity': %d, 'currency_id': 'ARS', 'unit_price': %f, 'id': %d, 'description': '%s', 'picture_url': '%s' } ], 'back_urls': {'success': '%s', 'failure': '%s'}, 'external_reference': %d }", 
				item.getItem().getNombre(),
				item.getItem().getCantidad(),
				item.getPrecioFinal(),
				item.getItem().getId(),
				item.getItem().getDescripcion(),
				item.getItem().getImagen(),
				"http://localhost:8080/voyager/order/payment/MP/" + offerId,
				"http://localhost:8080/voyager/order/payment/MP/error/" + offerId,
				orderId);
		
		MP mp = new MP ("4245217028796417", "yVBJxXMEkFsBl5VWNoztaupN8zVY9SkK");
		JSONObject preference = mp.createPreference(payload);
		String checkoutURL = preference.getJSONObject("response").getString("init_point");
		return checkoutURL;
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
		return new ModelAndView("createItemOrder", modelMap);
	}
	
	@RequestMapping(value = "/MLA/{name}", method = RequestMethod.GET)
	public ModelAndView getItemFromMLA(@PathVariable String name, HttpServletRequest request) {
		User userSession = loginService.getSession(request);
		if (userSession == null)
			return new ModelAndView("redirect:/login");
		ModelMap modelMap = new ModelMap();
		modelMap.put("userSession", userSession);
		
		// Asociar item al form
		Item item = new Item();
		ItemOrder newItemOrder = new ItemOrder();
		if (StringUtils.isNotEmpty(name))
			item.setNombre(name);
		newItemOrder.setItem(item);
		
		modelMap.put("itemOrder", newItemOrder);
		return new ModelAndView("createOrderForm",modelMap);
	}
	
	@RequestMapping(value = "/MLA/search/{itemId}")
	public ModelAndView mercadolibreToVoyager(@PathVariable String itemId, HttpServletRequest request) {
		User userSession = loginService.getSession(request);
		if (userSession == null)
			return new ModelAndView("redirect:/login");
		ModelMap modelMap = new ModelMap();
		modelMap.put("userSession", userSession);
		
		MLItem mlItem = mercadolibreService.getItemDataByItemId(itemId);
		
		Item item = new Item();
		ItemOrder newItemOrder = new ItemOrder();
		
		item.setNombre(mlItem.getTitle());
		item.setImagen(mlItem.getPictures().get(0).getUrl().toString());
		item.setPrecio(mlItem.getPrice() != null ? mlItem.getPrice().divide(new BigDecimal(28),2, RoundingMode.HALF_UP) : mlItem.getPrice());
		item.setUrl(mlItem.getPermalink().toString());
		newItemOrder.setItem(item);
		modelMap.put("itemOrder", newItemOrder);
		return new ModelAndView("createOrderForm",modelMap);
	}
	
	@RequestMapping(value = "/payment/MP/{offerId}", method = RequestMethod.GET)
	public ModelAndView successPayment(@PathVariable Long offerId, HttpServletRequest request) {
		User userSession = loginService.getSession(request);
		if (userSession == null)
			return new ModelAndView("redirect:/login");
		ModelMap modelMap = new ModelMap();
		modelMap.put("userSession", userSession);
		Offer offer = offerService.changeStatus(offerId, Status.PAYED);
		ItemOrder itemOrder = itemOrderService.changeStatus(offer.getItemOrder().getId(), Status.PAYED);
		itemOrderService.setVoyagerToOrder(itemOrder, offer);
		offerService.cancelAllOffersExceptCurrent(offerId, itemOrder.getId());
		modelMap.addAttribute("itemOrder", itemOrder);		
		modelMap.put("itemOrder", itemOrder);
		return new ModelAndView("redirect:/order/payed");
	}
	
	@RequestMapping(value = "/payment/MP/error/{offerId}", method = RequestMethod.GET)
	public ModelAndView errorPayment(@PathVariable Long offerId, HttpServletRequest request) {
		User userSession = loginService.getSession(request);
		if (userSession == null)
			return new ModelAndView("redirect:/login");
		ModelMap modelMap = new ModelMap();
		modelMap.put("userSession", userSession);
		return new ModelAndView("errorPayment", modelMap);
	}
	
	@RequestMapping(value = "/payed", method = RequestMethod.GET)
	public ModelAndView payOrder(HttpServletRequest request) {
		User userSession = loginService.getSession(request);
		if (userSession == null)
			return new ModelAndView("redirect:/login");
		ModelMap modelMap = new ModelMap();
		modelMap.put("userSession", userSession);
		if (userSession != null) {
			List <ItemOrder> itemOrders = itemOrderService.findAllByCompradorIdAndStatus(userSession.getId(), Status.PAYED);
			modelMap.put("itemOrders", itemOrders.size() != 0 ? itemOrders : null);
		}
		return new ModelAndView("myPayments", modelMap);
	}
	
	@RequestMapping(value = "/delivers", method = RequestMethod.GET)
	public ModelAndView ordersToDeliver(HttpServletRequest request) {
		User userSession = loginService.getSession(request);
		if (userSession == null)
			return new ModelAndView("redirect:/login");
		ModelMap modelMap = new ModelMap();
		modelMap.put("userSession", userSession);
		if (userSession != null) {
			List <ItemOrder> itemOrders = itemOrderService.findAllByVoyagerIdAndStatus(userSession.getId(), Status.PAYED);
			modelMap.put("itemOrders", itemOrders.size() != 0 ? itemOrders : null);
		}
		return new ModelAndView("myDelivers", modelMap);
	}
	
	@RequestMapping(value = "/received/{orderId}", method = RequestMethod.GET)
	public ModelAndView ordersToDeliver(@PathVariable Long orderId, HttpServletRequest request) {
		User userSession = loginService.getSession(request);
		if (userSession == null)
			return new ModelAndView("redirect:/login");
		ModelMap modelMap = new ModelMap();
		modelMap.put("userSession", userSession);
		Boolean fin = itemOrderService.receiveProduct(orderId);
		if (fin)
			return new ModelAndView("finished", modelMap);
		return new ModelAndView("redirect:/order/payed");
	}

	@RequestMapping(value = "/change/status/{orderId}/{status}", method = RequestMethod.GET)
	public ModelAndView changeStatusVoyage(@PathVariable Long orderId, @PathVariable String status, HttpServletRequest request) {
		User userSession = loginService.getSession(request);
		if (userSession == null)
			return new ModelAndView("redirect:/login");
		ModelMap modelMap = new ModelMap();
		modelMap.put("userSession", userSession);
		Boolean fin = itemOrderService.changeStatusVoyage(orderId, StatusVoyage.valueOf(status), userSession.getId());
		if (fin)
			return new ModelAndView("finished", modelMap);
		return new ModelAndView("redirect:/order/delivers");
	}
	
	
}
