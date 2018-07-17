package ar.edu.unlam.tallerweb1.services;

import ar.edu.unlam.tallerweb1.dto.mercadolibre.MLItem;

public interface MercadoLibreService {

	/**
	 * Obtiene un {@link MLItem} de MercadoLibre en base a su id.
	 * Arrojara una excepcion en caso de que el item no haya podido
	 * ser hallado.
	 * 
	 * @param itemId ID de MercadoLibre del item a buscar. Tienen un formato
	 * similar a 'MLA684928268'.
	 * @return
	 */
    public MLItem getItemDataByItemId(String itemId);
}