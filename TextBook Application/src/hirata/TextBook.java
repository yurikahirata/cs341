package hirata;

public class TextBook {
	private String title;
	private String sku;
	private double price;
	private int quantity;
	
	public TextBook(String s, String textbook, double p, int q) {
		title = textbook;
		sku = s;
		price = p;
		quantity = q;
	}
	
	public String toString() {
		return sku + "\t" + title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getPrice() {
		return price + "";
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getQuantity() {
		return quantity + "";
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
