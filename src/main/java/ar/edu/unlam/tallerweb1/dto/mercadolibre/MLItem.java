package ar.edu.unlam.tallerweb1.dto.mercadolibre;

import java.math.BigDecimal;
import java.net.URL;
import java.util.List;

public class MLItem {

	private String id;
	private String title;
	private BigDecimal price;
	private BigDecimal basePrice;
	private URL permalink;
	private URL thumbnail;
	private List<MLItemPicture> pictures;

	// Hay un monton de campos mas. Mapear a discrecion.

	public static class MLItemPicture {
		private URL url;

		public URL getUrl() {
			return url;
		}

		public void setUrl(URL url) {
			this.url = url;
		}

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(BigDecimal basePrice) {
		this.basePrice = basePrice;
	}

	public URL getPermalink() {
		return permalink;
	}

	public void setPermalink(URL permalink) {
		this.permalink = permalink;
	}

	public URL getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(URL thumbnail) {
		this.thumbnail = thumbnail;
	}

	public List<MLItemPicture> getPictures() {
		return pictures;
	}

	public void setPictures(List<MLItemPicture> pictures) {
		this.pictures = pictures;
	}

	@Override
	public String toString() {
		return String.format("MLItem<%s|%s>", this.id, this.title);
	}
}