package ar.edu.unlam.tallerweb1.controllers;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ar.edu.unlam.tallerweb1.dto.OfferDTO;
import ar.edu.unlam.tallerweb1.services.OfferService;

@Controller
@RequestMapping("/oferta")
public class OfferController {
	
	@Inject
	private OfferService ofertaServicio;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<OfferDTO> listarOfertas() {
		return ofertaServicio.getAllOffersAsView();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void crearOferta() {
		
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public void editarOferta() {
		
	}
}
