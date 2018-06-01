package ar.edu.unlam.tallerweb1.controllers;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.model.User;
import ar.edu.unlam.tallerweb1.services.LoginService;

@Controller
public class LoginController {

	@Inject
	private LoginService servicioLogin;

	@RequestMapping("/login")
	public ModelAndView irALogin() {

		ModelMap modelo = new ModelMap();
		User user = new User();
		modelo.put("user", user);
		return new ModelAndView("login", modelo);
	}

	@RequestMapping(path = "/validar-login", method = RequestMethod.POST)
	public ModelAndView validarLogin(@ModelAttribute("user") User usuario, HttpServletRequest request) {
		ModelMap model = new ModelMap();

		User usuarioBuscado = servicioLogin.consultarUsuario(usuario);
		if (usuarioBuscado != null) {
			request.getSession().setAttribute("ROL", usuarioBuscado.getRol());
			return new ModelAndView("redirect:/home");
		} else {
			model.put("error", "Usuario o clave incorrecta");
		}
		return new ModelAndView("login", model);
	}

	@RequestMapping(path = "/signup", method = RequestMethod.GET)
	public ModelAndView signUp() {
		ModelMap modelo = new ModelMap();
		User user = new User();
		modelo.put("user", user);
		return new ModelAndView("signup", modelo);
	}
	
	@RequestMapping(path = "/signup", method = RequestMethod.POST)
	public ModelAndView signUpConfirm() {
		ModelMap modelo = new ModelMap();
		User user = new User();
		modelo.put("user", user);
		return new ModelAndView("signup", modelo);
	}

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public ModelAndView inicio() {
		return new ModelAndView("index");
	}
}
