package ar.edu.unlam.tallerweb1.services.impl;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.UsuarioDao;
import ar.edu.unlam.tallerweb1.filter.UserSessionRetriever;
import ar.edu.unlam.tallerweb1.model.User;
import ar.edu.unlam.tallerweb1.services.LoginService;

// Implelemtacion del Servicio de usuarios, la anotacion @Service indica a Spring que esta clase es un componente que debe
// ser manejado por el framework, debe indicarse en applicationContext que busque en el paquete ar.edu.unlam.tallerweb1.servicios
// para encontrar esta clase.
// La anotacion @Transactional indica que se debe iniciar una transaccion de base de datos ante la invocacion de cada metodo del servicio,
// dicha transaccion esta asociada al transaction manager definido en el archivo spring-servlet.xml y el mismo asociado al session factory definido
// en hibernateCOntext.xml. De esta manera todos los metodos de cualquier dao invocados dentro de un servicio se ejecutan en la misma transaccion
@Service("servicioLogin")
@Transactional
public class LoginServiceImpl implements LoginService {

	@Inject
	private UsuarioDao userDao;

	@Override
	public User consultarUsuario (User usuario) {
		return userDao.consultarUsuario(usuario);
	}
	
	@Override
	public User validEmail(String email) {
		return userDao.validEmail(email);
	}

	@Override
	public void save(User usuario) {
		userDao.save(usuario);		
	}

	@Override
	public User getSession(HttpServletRequest request) {
		return UserSessionRetriever.getUserFromSession(request);
	}

}
