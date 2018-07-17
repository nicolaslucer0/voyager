package ar.edu.unlam.tallerweb1;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.controllers.LoginController;
import ar.edu.unlam.tallerweb1.model.User;
import ar.edu.unlam.tallerweb1.services.LoginService;

public class UserSessionTest {

	@Test
	public void loginUser() {
		ModelAndView modelAndViewEsperado = new ModelAndView("redirect:/");

		HttpServletRequest requestMock = mock(HttpServletRequest.class);
		User usuarioMock = mock(User.class);
		HttpSession sessionMock = mock(HttpSession.class);
		LoginService servicioMock = mock(LoginService.class);
		LoginController log = new LoginController();
		log.setLoginService(servicioMock);

		when(requestMock.getSession()).thenReturn(sessionMock);
		when(servicioMock.consultarUsuario(usuarioMock)).thenReturn(usuarioMock);
		
		ModelAndView modelResultado = log.validarLogin(usuarioMock, requestMock);

		assertThat(modelResultado.getViewName()).isEqualTo(modelAndViewEsperado.getViewName());
	}
	
	/**
	 * Test para probar que el registro funciona bien.
	 * 
	 */
	@Test
	public void signUpUser() {
		ModelAndView modelAndViewEsperado = new ModelAndView("redirect:/");

		HttpServletRequest requestMock = mock(HttpServletRequest.class);
		User usuarioMock = mock(User.class);
		HttpSession sessionMock = mock(HttpSession.class);
		LoginService servicioMock = mock(LoginService.class);
		LoginController log = new LoginController();
		log.setLoginService(servicioMock);

		when(requestMock.getSession()).thenReturn(sessionMock);
		when(servicioMock.validEmail(usuarioMock.getEmail())).thenReturn(null);
		
		ModelAndView modelResultado = log.signUpConfirm(usuarioMock, requestMock);

		assertThat(modelResultado.getViewName()).isEqualTo(modelAndViewEsperado.getViewName());
	}

}
