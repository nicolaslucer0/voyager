package ar.edu.unlam.tallerweb1.controllers;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.dto.OfferDTO;
import ar.edu.unlam.tallerweb1.model.ItemOrder;
import ar.edu.unlam.tallerweb1.model.Offer;
import ar.edu.unlam.tallerweb1.model.Status;
import ar.edu.unlam.tallerweb1.model.User;
import ar.edu.unlam.tallerweb1.services.ItemOrderService;
import ar.edu.unlam.tallerweb1.services.LoginService;
import ar.edu.unlam.tallerweb1.services.OfferService;

@Controller
@RequestMapping("/offer")
public class OfferController {
	
	@Inject
	private OfferService offerService;
	
	@Inject
	private ItemOrderService itemOrderService;
	
	@Inject
	private LoginService loginService;
	

	public void setOfferService(OfferService offerService) {
		this.offerService = offerService;
	}

	public void setItemOrderService(ItemOrderService itemOrderService) {
		this.itemOrderService = itemOrderService;
	}

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	/**
	 * Listar todas las ofertas con estado NEW
	 * @return
	 */
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ModelAndView listOffers(HttpServletRequest request) {
		User userSession = loginService.getSession(request);
		ModelMap modelMap = new ModelMap();
		modelMap.put("userSession", userSession);
		List<OfferDTO> offers = offerService.getAllOffersByStatus(Status.NEW);
		modelMap.addAttribute("offers", offers.size() == 0 ? offers : null);
		return new ModelAndView("offers",modelMap);
	}
	
	@RequestMapping(value = "/order/{orderId}", method = RequestMethod.GET)
	public ModelAndView makeOrderOffer(@PathVariable Long orderId, HttpServletRequest request) {
		User userSession = loginService.getSession(request);
		if (userSession == null)
			return new ModelAndView("redirect:/login");
		ModelMap modelMap = new ModelMap();
		modelMap.put("userSession", userSession);
		Offer offer = offerService.newOffer(orderId, userSession);
		modelMap.addAttribute("order", offer);
			return new ModelAndView("redirect:/offer/myOffers");
	}
	
	@RequestMapping(value = "/{offerId}/accept/order/{orderId}", method = RequestMethod.GET)
	public ModelAndView acceptOffer(@PathVariable Long offerId, @PathVariable Long orderId, HttpServletRequest request) {
		User userSession = loginService.getSession(request);
		if (userSession == null)
			return new ModelAndView("redirect:/login");
		ModelMap modelMap = new ModelMap();
		modelMap.put("userSession", userSession);
		 itemOrderService.findOneItemOrderById(orderId);
		 offerService.findOneOfferById(offerId);
		ItemOrder itemOrder = itemOrderService.changeStatus(orderId, Status.ACCEPTED);
		Offer offer = offerService.changeStatus(offerId, Status.ACCEPTED);
		itemOrderService.setVoyagerToOrder(itemOrder, offer);
		offerService.cancelAllOffersExceptCurrent(offerId, orderId);
		modelMap.addAttribute("itemOrder", itemOrder);
		return new ModelAndView("payment",modelMap);
	}

	@RequestMapping (value = "/myOffers", method = RequestMethod.GET)
	public ModelAndView viewItemOrdersByComprador(HttpServletRequest request) {
		User userSession = loginService.getSession(request);
		if (userSession == null)
			return new ModelAndView("redirect:/login");
		ModelMap modelMap = new ModelMap();
		modelMap.put("userSession", userSession);
		if (userSession != null) {
			List <ItemOrder> itemOrders = offerService.findAllActiveOffersByVoyagerId(userSession.getId());
			modelMap.put("myOffers", itemOrders.size() != 0 ? itemOrders : null);
		}
		return new ModelAndView("myOffers", modelMap);
	}
	
	@RequestMapping(value = "/cancel/{offerId}", method = RequestMethod.GET)
	public ModelAndView cancelOffer(@PathVariable Long offerId, HttpServletRequest request) {
		User userSession = loginService.getSession(request);
		if (userSession == null)
			return new ModelAndView("redirect:/login");
		ModelMap modelMap = new ModelMap();
		modelMap.put("userSession", userSession);
		Offer offer = offerService.cancelOffer(offerId, userSession);
		modelMap.addAttribute("order", offer);
			return new ModelAndView("redirect:/offer/myOffers");
	}
	
	
}
