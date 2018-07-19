package ar.edu.unlam.tallerweb1;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.controllers.OfferController;
import ar.edu.unlam.tallerweb1.dto.OfferDTO;
import ar.edu.unlam.tallerweb1.model.*;
import ar.edu.unlam.tallerweb1.services.ItemOrderService;
import ar.edu.unlam.tallerweb1.services.LoginService;
import ar.edu.unlam.tallerweb1.services.OfferService;


public class OfferControllerTest {

	
	/**
	 * Action: listOffers
	 * Resultado Buscado: ModelAndView.getViewName() = "itemOrders";
	 */
	@Test
	public void listOffers(){
		ModelAndView vistaBuscada = new ModelAndView("offers");
		HttpServletRequest request = mock(HttpServletRequest.class);
		LoginService loginService = mock(LoginService.class);
		OfferService offerService = mock(OfferService.class);
		User userMock = new User();		
		List<OfferDTO> listOffers = new ArrayList<>();
		
		OfferController offerController = new OfferController();
		offerController.setLoginService(loginService);
		offerController.setOfferService(offerService);
		when(loginService.getSession(request)).thenReturn(userMock);
		when(offerService.getAllOffersByStatus(Status.NEW)).thenReturn(listOffers);
		ModelAndView vistaObtenida = offerController.listOffers(request);
		assertThat(vistaObtenida.getViewName()).isEqualTo(vistaBuscada.getViewName());
	}
	/**
	 * Action: makeOrderOffer
	 * Resultado Buscado: ModelAndView.getViewName() = "success";
	 */
	@Test
	public void makeOrderOffer(){
		ModelAndView vistaBuscada = new ModelAndView("redirect:/offer/myOffers");
		HttpServletRequest request = mock(HttpServletRequest.class);
		LoginService loginService = mock(LoginService.class);
		ItemOrderService itemOrderService = mock(ItemOrderService.class);
		OfferService offerService = mock(OfferService.class);
		User userMock = new User();
		
		
		OfferController offerController = new OfferController();
		offerController.setLoginService(loginService);
		offerController.setItemOrderService(itemOrderService);
		offerController.setOfferService(offerService);
		when(loginService.getSession(request)).thenReturn(userMock);
		ModelAndView vistaObtenida = offerController.makeOrderOffer(new Long(1),request);
		assertThat(vistaObtenida.getViewName()).isEqualTo(vistaBuscada.getViewName());
	}
	/**
	 * Action: acceptOffer
	 * Resultado Buscado: ModelAndView.getViewName() = "success";
	 */
	@Test
	public void acceptOffer(){
		ModelAndView vistaBuscada = new ModelAndView("redirect:/order/myOffers");
		HttpServletRequest request = mock(HttpServletRequest.class);
		LoginService loginService = mock(LoginService.class);
		ItemOrderService itemOrderService = mock(ItemOrderService.class);
		OfferService offerService = mock(OfferService.class);
		ItemOrder itemOrderMock = mock(ItemOrder.class);
		Offer offerMock = mock(Offer.class);
		User userMock = new User();
		//User userMock = mock(User.class);
		Long offerIdMock = new Long(1);
		Long orderIdMock = new Long(1); 
		
		OfferController offerController = new OfferController();
		offerController.setLoginService(loginService);
		offerController.setOfferService(offerService);
		offerController.setItemOrderService(itemOrderService);
		when(loginService.getSession(request)).thenReturn(userMock);
		when(itemOrderService.findOneItemOrderById(orderIdMock)).thenReturn(itemOrderMock);
		when(offerService.findOneOfferById(offerIdMock)).thenReturn(offerMock);
		when(itemOrderService.changeStatus(orderIdMock, Status.ACCEPTED)).thenReturn(itemOrderMock);
		when(offerService.changeStatus(offerIdMock, Status.ACCEPTED)).thenReturn(offerMock);
		ModelAndView vistaObtenida = offerController.acceptOffer(offerIdMock,orderIdMock, request);
		assertThat(vistaObtenida.getViewName()).isEqualTo(vistaBuscada.getViewName());
	}
	/**
	 * Action: viewItemOrdersByComprador
	 * Resultado Buscado: ModelAndView.getViewName() = "myOffers";
	 */
	@Test
	public void viewItemOrdersByComprador(){
		ModelAndView vistaBuscada = new ModelAndView("myOffers");
		HttpServletRequest request = mock(HttpServletRequest.class);
		LoginService loginService = mock(LoginService.class);
		OfferService offerService = mock(OfferService.class);
		User userMock = new User();
		List<ItemOrder> listitemOrders = new ArrayList<>();
		
		
		OfferController offerController = new OfferController();
		offerController.setLoginService(loginService);
		offerController.setOfferService(offerService);
		when(loginService.getSession(request)).thenReturn(userMock);
		when(offerService.findAllActiveOffersByVoyagerId(new Long(1))).thenReturn(listitemOrders);
		ModelAndView vistaObtenida = offerController.viewItemOrdersByComprador(request);
		assertThat(vistaObtenida.getViewName()).isEqualTo(vistaBuscada.getViewName());
	}
	/**
	 * Action: viewItemOrdersByComprador
	 * Resultado Buscado: ModelAndView.getViewName() = "success";
	 */
	@Test
	public void cancelOffer(){
		ModelAndView vistaBuscada = new ModelAndView("redirect:/offer/myOffers");
		HttpServletRequest request = mock(HttpServletRequest.class);
		LoginService loginService = mock(LoginService.class);
		OfferService offerService = mock(OfferService.class);
		User userMock = new User();
		Offer offerMock = mock(Offer.class);
		Long offerIdMock = new Long(1);
		
		
		OfferController offerController = new OfferController();
		offerController.setLoginService(loginService);
		offerController.setOfferService(offerService);
		when(loginService.getSession(request)).thenReturn(userMock);
		when(offerService.cancelOffer(offerIdMock, userMock)).thenReturn(offerMock);
		ModelAndView vistaObtenida = offerController.cancelOffer(new Long(1),request);
		assertThat(vistaObtenida.getViewName()).isEqualTo(vistaBuscada.getViewName());
	}
}