package ar.edu.unlam.tallerweb1;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations.Mock;
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
public class ItemOrderServiceTest {
	
	@Inject
	private ItemOrderService itemOrderService;
	
	@Test
	//@Transactional @Rollback(true)
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

}