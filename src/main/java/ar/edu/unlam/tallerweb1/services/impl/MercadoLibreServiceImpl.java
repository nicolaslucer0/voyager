package ar.edu.unlam.tallerweb1.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import ar.edu.unlam.tallerweb1.dto.mercadolibre.MLItem;
import ar.edu.unlam.tallerweb1.dto.mercadolibre.request.ItemRequest;
import ar.edu.unlam.tallerweb1.dto.mercadolibre.request.MLRequest;
import ar.edu.unlam.tallerweb1.services.MercadoLibreService;

@Service
public class MercadoLibreServiceImpl implements MercadoLibreService {

    public MLItem getItemDataByItemId(String itemId) {
        return hit(new ItemRequest(itemId), MLItem.class);
    }

    protected <T> T hit(MLRequest request, Class<T> responseType) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(request.getEndpoint(), responseType);
    }

}