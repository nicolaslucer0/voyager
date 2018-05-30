package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.model.User;

// Interface que define los metodos del DAO de Usuarios.
public interface UsuarioDao {
	
	User consultarUsuario (User usuario);
}
