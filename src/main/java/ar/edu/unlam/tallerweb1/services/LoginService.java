package ar.edu.unlam.tallerweb1.services;

import javax.servlet.http.HttpServletRequest;

import ar.edu.unlam.tallerweb1.model.User;

// Interface que define los metodos del Servicio de Usuarios.
public interface LoginService {

	User consultarUsuario(User usuario);

	void save(User usuario);

	User validEmail(String email);

	User getSession(HttpServletRequest request);

}
