package ar.edu.unlam.tallerweb1;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.controllers.ItemOrderController;
import ar.edu.unlam.tallerweb1.dto.mercadolibre.MLItem;
import ar.edu.unlam.tallerweb1.dto.mercadolibre.MLItem.MLItemPicture;
import ar.edu.unlam.tallerweb1.model.Item;
import ar.edu.unlam.tallerweb1.model.ItemOrder;
import ar.edu.unlam.tallerweb1.model.Rol;
import ar.edu.unlam.tallerweb1.model.Status;
import ar.edu.unlam.tallerweb1.model.User;
import ar.edu.unlam.tallerweb1.services.ItemOrderService;
import ar.edu.unlam.tallerweb1.services.LoginService;
import ar.edu.unlam.tallerweb1.services.MercadoLibreService;
import ar.edu.unlam.tallerweb1.services.impl.*;


@SuppressWarnings("unused")
public class ItemOrderTest{
	
	@Inject
	private ItemOrderService itemOrderService;

	/*
	
	@Test
	@Transactional @Rollback(true)
	public void crearUnItemOrderYQueDevuelvaElIdGenerado(){
		//ItemOrderServiceImpl itemOrderService = new ItemOrderServiceImpl();
		//HttpServletRequest request = mock(HttpServletRequest.class);
		//LoginService loginService = mock(LoginServiceImpl.class);
		
		User user = new User();
		user.setId(new Long(1));
		user.setRol(Rol.USER);
		user.setEmail("gonzarosinski@gmail.com");
		user.setPassword("1234");
		user.setName("gonza");
		user.setLastName("peredo");
		//when(loginService.getSession(request)).thenReturn(user);
		
		Item item = new Item();
		item.setNombre("Televisor");
		item.setUrl("https://articulo.mercadolibre.com.ar/MLA-728319230-smart-tv-4k-49-sanyo-lce49su8350-_JM");
		item.setImagen("http://www.islabit.com/wp-content/uploads/2016/05/sony-4k.jpg");
		item.setPrecio(new BigDecimal(750.00));
		item.setCantidad(new Long(1));
		ItemOrder pedidoNuevo = new ItemOrder();
		pedidoNuevo.setItem(item);
		pedidoNuevo.setPaisDestino("Alemania");
		
		Boolean status = itemOrderService.saveTestItemOrder(pedidoNuevo, user);
		//ItemOrder itemBuscado = itemOrderService.findOneItemOrderById(new Long(2));
		//assertThat(pedidoNuevo.getItem().getUrl()).isEqualTo(itemBuscado.getItem().getUrl());
		assertThat(status.booleanValue()).isEqualTo(true);
	}
	*/
	
	/**
	 * Action: listNewItemOrders
	 * Resultado Buscado: ModelAndView.getViewName() = "itemOrders";
	 */
	@Test
	public void listNewItemOrders(){
		ModelAndView vistaBuscada = new ModelAndView("itemOrders");
		HttpServletRequest request = mock(HttpServletRequest.class);
		LoginService loginService = mock(LoginService.class);
		ItemOrderService itemOrderService = mock(ItemOrderService.class);
		User userMock = new User();
		ItemOrder itemOrderMock = new ItemOrder();
		ItemOrderController itemOrderController = new ItemOrderController();
		itemOrderController.setLoginService(loginService);
		itemOrderController.setItemOrderService(itemOrderService);
		when(loginService.getSession(request)).thenReturn(userMock);
		ModelAndView vistaObtenida = itemOrderController.listNewItemOrders(request);
		assertThat(vistaObtenida.getViewName()).isEqualTo(vistaBuscada.getViewName());
	}
	/**
	 * Action: listAllItemOrders
	 * Resultado Buscado: ModelAndView.getViewName() = "myItemOrders";
	 */
	@Test
	public void listAllItemOrders(){
		ModelAndView vistaBuscada = new ModelAndView("myItemOrders");
		HttpServletRequest request = mock(HttpServletRequest.class);
		LoginService loginService = mock(LoginService.class);
		ItemOrderService itemOrderService = mock(ItemOrderService.class);
		User userMock = new User();
		ItemOrder itemOrderMock = new ItemOrder();
		ItemOrderController itemOrderController = new ItemOrderController();
		itemOrderController.setLoginService(loginService);
		itemOrderController.setItemOrderService(itemOrderService);
		when(loginService.getSession(request)).thenReturn(userMock);
		ModelAndView vistaObtenida = itemOrderController.listAllItemOrders(request);
		assertThat(vistaObtenida.getViewName()).isEqualTo(vistaBuscada.getViewName());
	}
	/**
	 * Action: listAllItemOrders
	 * Resultado Buscado: ModelAndView.getViewName() = "redirect:/login";
	 */
	@Test
	public void listAllItemOrders_withoutUserSessionAndRedirectLogin(){
		ModelAndView vistaBuscada = new ModelAndView("redirect:/login");
		HttpServletRequest request = mock(HttpServletRequest.class);
		LoginService loginService = mock(LoginService.class);
		ItemOrderService itemOrderService = mock(ItemOrderService.class);
		ItemOrder itemOrderMock = new ItemOrder();
		ItemOrderController itemOrderController = new ItemOrderController();
		itemOrderController.setLoginService(loginService);
		itemOrderController.setItemOrderService(itemOrderService);
		when(loginService.getSession(request)).thenReturn(null);
		ModelAndView vistaObtenida = itemOrderController.listAllItemOrders(request);
		assertThat(vistaObtenida.getViewName()).isEqualTo(vistaBuscada.getViewName());
	}
	/**
	 * Action: saveItemOrder
	 * Resultado Buscado: ModelAndView.getViewName() = "SuccessOrder";
	 */
	@Test
	public void saveItemOrder(){
		ModelAndView vistaBuscada = new ModelAndView("successOrder");
		HttpServletRequest request = mock(HttpServletRequest.class);
		LoginService loginService = mock(LoginService.class);
		ItemOrderService itemOrderService = mock(ItemOrderService.class);
		User userMock = new User();
		ItemOrder itemOrderMock = new ItemOrder();
		ItemOrderController itemOrderController = new ItemOrderController();
		itemOrderController.setLoginService(loginService);
		itemOrderController.setItemOrderService(itemOrderService);
		when(loginService.getSession(request)).thenReturn(userMock);
		ModelAndView vistaObtenida = itemOrderController.saveItemOrder(itemOrderMock, request);
		assertThat(vistaObtenida.getViewName()).isEqualTo(vistaBuscada.getViewName());
	}	
	/**
	 * Action: editItemOrder
	 * Resultado Buscado: ModelAndView.getViewName() = "itemOrderForm";
	 */	
	@Test
	public void editItemOrder(){
		ModelAndView vistaBuscada = new ModelAndView("itemOrderForm");
		
		HttpServletRequest request = mock(HttpServletRequest.class);
		LoginService loginService = mock(LoginService.class);
		ItemOrderService itemOrderService = mock(ItemOrderService.class);
		User userMock = mock(User.class);
		Long idUsuarioMock = new Long(1);
		
		ItemOrderController itemOrderController = new ItemOrderController();
		itemOrderController.setLoginService(loginService);
		itemOrderController.setItemOrderService(itemOrderService);
		when(loginService.getSession(request)).thenReturn(userMock);
		ModelAndView vistaObtenida = itemOrderController.editItemOrder(idUsuarioMock,request);
		assertThat(vistaObtenida.getViewName()).isEqualTo(vistaBuscada.getViewName());
	}
	/**
	 * Action: viewItemOrdersByComprador
	 * Resultado Buscado: ModelAndView.getViewName() = "myItemOrders";
	 */	
	@Test
	public void viewItemOrdersByComprador(){
		ModelAndView vistaBuscada = new ModelAndView("myItemOrders");
		
		HttpServletRequest request = mock(HttpServletRequest.class);
		LoginService loginService = mock(LoginService.class);
		ItemOrderService itemOrderService = mock(ItemOrderService.class);
		User userMock = mock(User.class);
		
		ItemOrderController itemOrderController = new ItemOrderController();
		itemOrderController.setLoginService(loginService);
		itemOrderController.setItemOrderService(itemOrderService);
		when(loginService.getSession(request)).thenReturn(userMock);
		ModelAndView vistaObtenida = itemOrderController.viewItemOrdersByComprador(request);
		assertThat(vistaObtenida.getViewName()).isEqualTo(vistaBuscada.getViewName());
	}
	/**
	 * Action: cancelItemOrder
	 * Resultado Buscado: ModelAndView.getViewName() = "redirect:/myOrders";
	 */	
	@Test
	public void cancelItemOrder(){
		ModelAndView vistaBuscada = new ModelAndView("redirect:/myOrders");
		
		HttpServletRequest request = mock(HttpServletRequest.class);
		LoginService loginService = mock(LoginService.class);
		ItemOrderService itemOrderService = mock(ItemOrderService.class);
		User userMock = mock(User.class);
		Long idUsuarioMock = new Long(1);
		
		ItemOrderController itemOrderController = new ItemOrderController();
		itemOrderController.setLoginService(loginService);
		itemOrderController.setItemOrderService(itemOrderService);
		when(loginService.getSession(request)).thenReturn(userMock);
		ModelAndView vistaObtenida = itemOrderController.cancelItemOrder(idUsuarioMock,request);
		assertThat(vistaObtenida.getViewName()).isEqualTo(vistaBuscada.getViewName());
	}
	/**
	 * Action: viewItemOrdersByVoyager
	 * Resultado Buscado: ModelAndView.getViewName() = "myOfferedOrders";
	 */	
	@Test
	public void viewItemOrdersByVoyager(){
		ModelAndView vistaBuscada = new ModelAndView("itemOrdersByUser");
		
		HttpServletRequest request = mock(HttpServletRequest.class);
		LoginService loginService = mock(LoginService.class);
		ItemOrderService itemOrderService = mock(ItemOrderService.class);
		User userMock = mock(User.class);
		
		ItemOrderController itemOrderController = new ItemOrderController();
		itemOrderController.setLoginService(loginService);
		itemOrderController.setItemOrderService(itemOrderService);
		when(loginService.getSession(request)).thenReturn(userMock);
		ModelAndView vistaObtenida = itemOrderController.viewItemOrdersByVoyager(request);
		assertThat(vistaObtenida.getViewName()).isEqualTo(vistaBuscada.getViewName());
	}
	/**
	 * Action: newItemOrder
	 * Resultado Buscado: ModelAndView.getViewName() = "myOfferedOrders";
	 */	
	@Test
	public void newItemOrder(){
		ModelAndView vistaBuscada = new ModelAndView("createItemOrder");
		
		HttpServletRequest request = mock(HttpServletRequest.class);
		LoginService loginService = mock(LoginService.class);
		ItemOrderService itemOrderService = mock(ItemOrderService.class);
		User userMock = mock(User.class);
		
		ItemOrderController itemOrderController = new ItemOrderController();
		itemOrderController.setLoginService(loginService);
		itemOrderController.setItemOrderService(itemOrderService);
		when(loginService.getSession(request)).thenReturn(userMock);
		ModelAndView vistaObtenida = itemOrderController.newItemOrder(request);
		assertThat(vistaObtenida.getViewName()).isEqualTo(vistaBuscada.getViewName());
	}
	/**
	 * Action: getItemFromMLA
	 * Resultado Buscado: ModelAndView.getViewName() = "myOfferedOrders";
	 */	
	@Test
	public void getItemFromMLA(){
		ModelAndView vistaBuscada = new ModelAndView("createOrderForm");
		
		HttpServletRequest request = mock(HttpServletRequest.class);
		LoginService loginService = mock(LoginService.class);
		ItemOrderService itemOrderService = mock(ItemOrderService.class);
		User userMock = mock(User.class);
		String itemML = "Auriculares";
		
		ItemOrderController itemOrderController = new ItemOrderController();
		itemOrderController.setLoginService(loginService);
		itemOrderController.setItemOrderService(itemOrderService);
		when(loginService.getSession(request)).thenReturn(userMock);
		ModelAndView vistaObtenida = itemOrderController.getItemFromMLA(itemML,request);
		assertThat(vistaObtenida.getViewName()).isEqualTo(vistaBuscada.getViewName());
	}
	/**
	 * Action: mercadolibreToVoyager
	 * Resultado Buscado: ModelAndView.getViewName() = "myOfferedOrders";
	 * @throws MalformedURLException 
	 */	
	@Test
	public void mercadolibreToVoyager() throws MalformedURLException{
		ModelAndView vistaBuscada = new ModelAndView("createOrderForm");
		
		HttpServletRequest request = mock(HttpServletRequest.class);
		LoginService loginServiceMock = mock(LoginService.class);
		ItemOrderService itemOrderServiceMock = mock(ItemOrderService.class);
		MercadoLibreService mercadolibreServiceMock = mock(MercadoLibreService.class);
		User userMock = mock(User.class);
		MLItem mlItemMock = mock(MLItem.class);
		MLItemPicture mlItemPictureMock = mock(MLItemPicture.class);
		String itemId = "Auriculares";
		List<MLItemPicture> listItemPictureMock= new ArrayList<>();
		listItemPictureMock.add(mlItemPictureMock);
		mlItemMock.setPictures(listItemPictureMock);
		
		ItemOrderController itemOrderController = new ItemOrderController();
		itemOrderController.setLoginService(loginServiceMock);
		itemOrderController.setItemOrderService(itemOrderServiceMock);
		itemOrderController.setMercadolibreService(mercadolibreServiceMock);
		when(loginServiceMock.getSession(request)).thenReturn(userMock);
		when(mercadolibreServiceMock.getItemDataByItemId(anyString())).thenReturn(mlItemMock);
		when(mlItemMock.getTitle()).thenReturn("Titulo");
		when(mlItemMock.getPictures()).thenReturn(listItemPictureMock);
		when(mlItemPictureMock.getUrl()).thenReturn(new URL("http://localhost/"));
		when(mlItemMock.toString()).thenReturn("toString");
		when(mlItemMock.getPrice()).thenReturn(new BigDecimal(100));
		when(mlItemMock.getPermalink()).thenReturn(new URL("http://localhost/"));
		ModelAndView vistaObtenida = itemOrderController.mercadolibreToVoyager(itemId,request);
		assertThat(vistaObtenida.getViewName()).isEqualTo(vistaBuscada.getViewName());
	}
}
