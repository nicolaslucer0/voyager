package ar.edu.unlam.tallerweb1.controllers;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.model.Rol;
import ar.edu.unlam.tallerweb1.model.User;
import ar.edu.unlam.tallerweb1.services.LoginService;

@Controller
public class LoginController {

	@Inject
	private LoginService loginService;

	/* ############## LOGIN JSP ############### */
	@RequestMapping("/login")
	public ModelAndView irALogin(HttpServletRequest request) {
		User userSession = loginService.getSession(request);
		ModelMap modelo = new ModelMap();
		modelo.put("userSession", userSession);
		User user = new User();
		modelo.put("user", user);
		return new ModelAndView("login", modelo);
	}

	/* ############## LOGIN POST ############### */
	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public ModelAndView validarLogin(@ModelAttribute("user") User usuario, HttpServletRequest request) {
		ModelMap model = new ModelMap();
		User usuarioBuscado = loginService.consultarUsuario(usuario);
		if (usuarioBuscado != null) {
			request.getSession().setAttribute("ROL", usuarioBuscado.getRol());
			request.getSession().setAttribute("USER", usuarioBuscado);
			return new ModelAndView("redirect:/");
		} else {
			model.put("error", "Usuario o clave incorrecta");
		}
		return new ModelAndView("login", model);
	}

	/* ############## SIGNUP JSP ############### */
	@RequestMapping(path = "/signup", method = RequestMethod.GET)
	public ModelAndView signUp(HttpServletRequest request) {
		User userSession = loginService.getSession(request);
		ModelMap modelo = new ModelMap();
		User user = new User();
		modelo.put("userSession", userSession);
		modelo.put("user", user);
		return new ModelAndView("signup", modelo);
	}
	
	/* ############## SIGNUP POST ############### */
	@RequestMapping(path = "/signup", method = RequestMethod.POST)
	public ModelAndView signUpConfirm(@ModelAttribute("user") User usuario, HttpServletRequest request) {
		ModelMap model = new ModelMap();
		User usuarioBuscado = loginService.validEmail(usuario.getEmail());
		if (usuarioBuscado == null) {
			usuario.setRol(Rol.USER);
			loginService.save(usuario);
			return new ModelAndView("redirect:/");
		} else {
			model.put("error", "Email ya existe en nuestras bases de datos.");
		}
		return new ModelAndView("signup", model);
	}
	
	/* ############## LOGOUT ############### */
	@RequestMapping(path = "/logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request) {
		request.getSession().setAttribute("USER", null);
		request.getSession().setAttribute("ROL", null);
		return new ModelAndView("redirect:/");
	}

	
	/* ############## INDEX ############### */
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public ModelAndView inicio(HttpServletRequest request) {
		User userSession = loginService.getSession(request);
		ModelMap model = new ModelMap();
		model.put("userSession", userSession);
		return new ModelAndView("index",model);
	}

	public void setLoginService(LoginService servicioMock) {
		this.loginService = servicioMock;
	}
}
