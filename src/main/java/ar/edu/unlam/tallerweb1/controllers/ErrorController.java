package ar.edu.unlam.tallerweb1.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ErrorController {
 
    @RequestMapping(value = "/errors", method = RequestMethod.GET)
    public ModelAndView renderErrorPage(HttpServletRequest httpRequest) {
        ModelMap model = new ModelMap();
        String errorMsg = "";
        int httpErrorCode = getErrorCode(httpRequest);
 
        switch (httpErrorCode) {
            case 400: {
                errorMsg = "Bad Request";
                break;
            }
            case 401: {
                errorMsg = "Alto ahí ! No tiene permiso para ingresar aquí.";
                break;
            }
            case 404: {
                errorMsg = "Ups, no era por aquí... ¿Seguro que es la direccion correcta?";
                break;
            }
            case 500: {
                errorMsg = "Error del servidor... No sos vos, soy yo.";
                break;
            }
        }
        model.put("errorCode", httpErrorCode);
        model.put("errorMsg", errorMsg);
        return new ModelAndView("errorPage", model);
    }
     
    private int getErrorCode(HttpServletRequest httpRequest) {
        return (Integer) httpRequest
          .getAttribute("javax.servlet.error.status_code");
    }
}