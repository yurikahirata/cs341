package hirata;

public class SalesItem {
	private String name;
	private double price;
	private Integer quantity;
	
	public SalesItem() {
		name = "";
		price = 0.0;
		quantity = 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	public String toString() {
		String priceString = String.format("%.2f", getPrice());
		String quantityString = Integer.toString(getQuantity());
		return String.format("%-14s $%5s %3s\n", toTitle(name), priceString, quantityString);
	}
	
	public String toTitle(String s) {
		String result = "";
		boolean convertNext = true;
		
		for (char c: s.toCharArray()) {
			if (Character.isSpaceChar(c)) {
	            convertNext = true;
	        } else if (convertNext) {
	            c = Character.toTitleCase(c);
	            convertNext = false;
	        } else {
	            c = Character.toLowerCase(c);
	        }
			result += c;
		}
		
		return result;
	}
	
}
