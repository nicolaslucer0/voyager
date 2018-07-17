package ar.edu.unlam.tallerweb1.dto.mercadolibre.request;

import java.net.URI;

public class ItemRequest extends MLRequest {

    protected String itemId;

    public ItemRequest(String itemId) {
        this.itemId = itemId;
    }

	@Override
	public URI getEndpoint() {
		return URI.create("https://api.mercadolibre.com/items/" + itemId);
    }

}