package ar.edu.unlam.tallerweb1.services;

import ar.edu.unlam.tallerweb1.model.User;

// Interface que define los metodos del Servicio de Usuarios.
public interface LoginService {

	User consultarUsuario(User usuario);
}
