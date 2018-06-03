package ar.edu.unlam.tallerweb1.controllers;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.model.Offer;
import ar.edu.unlam.tallerweb1.services.OfferService;

@Controller
@RequestMapping("/offer")
public class OfferController {
	
	@Inject
	private OfferService offerService;
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ModelAndView listOffers() {
		ModelMap offers = new ModelMap();
		offers.addAttribute("offers",offerService.getAllOffers());
		return new ModelAndView("offers",offers);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView newOffer() {
		ModelMap offer = new ModelMap();
		Offer newOffer = new Offer();
		offer.addAttribute("offer", newOffer);
		return new ModelAndView("offerForm",offer);
	}
	
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
}
