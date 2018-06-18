package ar.edu.unlam.tallerweb1.controllers;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	
	/**
	 * Direcciona al formulario para crear una nueva oferta con el modelo correspondiente
	 * @return ModelAndView
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView newOffer(HttpServletRequest request) {
		User userSession = loginService.getSession(request);
		ModelMap modelMap = new ModelMap();
		modelMap.put("userSession", userSession);
		Offer newOffer = new Offer();
		modelMap.addAttribute("offer", newOffer);
		return new ModelAndView("offerForm",modelMap);
	}
	
	/**
	 * Se guarda la nueva oferta
	 */
	@RequestMapping(method = RequestMethod.POST)
	public void saveOffer(@ModelAttribute Offer offer) {
		offerService.save(offer);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ModelAndView editOffer(@PathVariable Long id, HttpServletRequest request) {
		User userSession = loginService.getSession(request);
		ModelMap modelMap = new ModelMap();
		modelMap.put("userSession", userSession);
		modelMap.addAttribute("offers",offerService.findOneOfferById(id));
		return new ModelAndView("offerForm",modelMap);
	}
	
	@RequestMapping(value = "/order/{id}", method = RequestMethod.GET)
	public ModelAndView makeOrderOffer(@PathVariable Long id, HttpServletRequest request) {
		User userSession = loginService.getSession(request);
		ModelMap modelMap = new ModelMap();
		modelMap.put("userSession", userSession);
		ItemOrder order = itemOrderService.changeStatus(id, Status.OFFERED);
		modelMap.addAttribute("order", order);
		return new ModelAndView("success",modelMap);
	}
	
}
