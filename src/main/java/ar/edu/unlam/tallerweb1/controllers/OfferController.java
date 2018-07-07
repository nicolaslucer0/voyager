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

	/**
	 * Listar todas las ofertas con estado NEW
	 * @return
	 */
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ModelAndView listOffers(HttpServletRequest request) {
		User userSession = loginService.getSession(request);
		ModelMap modelMap = new ModelMap();
		modelMap.put("userSession", userSession);
		modelMap.addAttribute("offers",offerService.getAllOffersByStatus(Status.NEW));
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
			return new ModelAndView("success",modelMap);
	}

	@RequestMapping (value = "/myOffers", method = RequestMethod.GET)
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
		return new ModelAndView("myOffers", modelMap);
	}
	
}
