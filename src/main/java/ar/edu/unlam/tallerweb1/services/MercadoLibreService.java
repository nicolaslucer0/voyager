package ar.edu.unlam.tallerweb1.services;

import ar.edu.unlam.tallerweb1.dto.mercadolibre.MLItem;

public interface MercadoLibreService {

    public MLItem getItemDataByItemId(String itemId);
}