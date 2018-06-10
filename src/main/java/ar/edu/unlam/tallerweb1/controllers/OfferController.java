package ar.edu.unlam.tallerweb1.controllers;

import javax.inject.Inject;

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
import ar.edu.unlam.tallerweb1.services.ItemOrderService;
import ar.edu.unlam.tallerweb1.services.OfferService;

@Controller
@RequestMapping("/offer")
public class OfferController {
	
	@Inject
	private OfferService offerService;
	
	@Inject
	private ItemOrderService itemOrderService;
	/**
	 * Listar todas las ofertas con estado NEW
	 * @return
	 */
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ModelAndView listOffers() {
		ModelMap offers = new ModelMap();
		offers.addAttribute("offers",offerService.getAllOffersByStatus(Status.NEW));
		return new ModelAndView("offers",offers);
	}
	
	/**
	 * Direcciona al formulario para crear una nueva oferta con el modelo correspondiente
	 * @return ModelAndView
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView newOffer() {
		ModelMap offer = new ModelMap();
		Offer newOffer = new Offer();
		offer.addAttribute("offer", newOffer);
		return new ModelAndView("offerForm",offer);
	}
	
	/**
	 * Se guarda la nueva oferta
	 */
	@RequestMapping(method = RequestMethod.POST)
	public void saveOffer(@ModelAttribute Offer offer) {
		offerService.save(offer);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ModelAndView editOffer(@PathVariable Long id) {
		ModelMap offer = new ModelMap();
		offer.addAttribute("offers",offerService.findOneOfferById(id));
		return new ModelAndView("offerForm",offer);
	}
	
	@RequestMapping(value = "/order/{id}", method = RequestMethod.GET)
	public ModelAndView makeOrderOffer(@PathVariable Long id) {
		ModelMap offer = new ModelMap();
		ItemOrder order = itemOrderService.changeStatus(id, Status.OFFERED);
		offer.addAttribute("order", order);
		return new ModelAndView("confirmOffer",offer);
	}
}
