package ar.edu.unlam.tallerweb1;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.math.BigDecimal;
import java.util.*;

import javax.servlet.http.HttpServletRequest;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.controllers.*;
import ar.edu.unlam.tallerweb1.model.*;
import ar.edu.unlam.tallerweb1.services.*;


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
		User userMock = new User();		
		
		OfferController offerController = new OfferController();
		offerController.setLoginService(loginService);
		when(loginService.getSession(request)).thenReturn(userMock);
		ModelAndView vistaObtenida = offerController.listOffers(request);
		assertThat(vistaObtenida.getViewName()).isEqualTo(vistaBuscada.getViewName());
	}
	/**
	 * Action: makeOrderOffer
	 * Resultado Buscado: ModelAndView.getViewName() = "success";
	 */
	@Test
	public void makeOrderOffer(){
		ModelAndView vistaBuscada = new ModelAndView("success");
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
		ModelAndView vistaBuscada = new ModelAndView("success");
		HttpServletRequest request = mock(HttpServletRequest.class);
		LoginService loginService = mock(LoginService.class);
		User userMock = new User();		
		
		OfferController offerController = new OfferController();
		offerController.setLoginService(loginService);
		when(loginService.getSession(request)).thenReturn(userMock);
		ModelAndView vistaObtenida = offerController.acceptOffer(new Long(1),request);
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
		User userMock = new User();
		
		
		OfferController offerController = new OfferController();
		offerController.setLoginService(loginService);
		when(loginService.getSession(request)).thenReturn(userMock);
		ModelAndView vistaObtenida = offerController.viewItemOrdersByComprador(request);
		assertThat(vistaObtenida.getViewName()).isEqualTo(vistaBuscada.getViewName());
	}
	/**
	 * Action: viewItemOrdersByComprador
	 * Resultado Buscado: ModelAndView.getViewName() = "success";
	 */
	@Test
	public void cancelOffer(){
		ModelAndView vistaBuscada = new ModelAndView("success");
		HttpServletRequest request = mock(HttpServletRequest.class);
		LoginService loginService = mock(LoginService.class);
		User userMock = new User();
		
		
		OfferController offerController = new OfferController();
		offerController.setLoginService(loginService);
		when(loginService.getSession(request)).thenReturn(userMock);
		ModelAndView vistaObtenida = offerController.cancelOffer(new Long(1),request);
		assertThat(vistaObtenida.getViewName()).isEqualTo(vistaBuscada.getViewName());
	}
}