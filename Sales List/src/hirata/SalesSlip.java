package hirata;

import java.util.ArrayList;

public class SalesSlip {
	ArrayList<SalesItem> saleList;
	
	public SalesSlip () {
		saleList = new ArrayList<SalesItem>();
	}
	
	public void addSalesItem(String item, String price, String quantity) {
		SalesItem newItem = new SalesItem();
		newItem.setName(item);
		newItem.setPrice(Double.parseDouble(price));
		newItem.setQuantity(Integer.parseInt(quantity));
		
		saleList.add(newItem);
	}
	
	public String computeTotalSales() {
		double sum = 0;
		for (SalesItem item: saleList) {
			sum += (item.getPrice() * item.getQuantity());
		}
		return String.format("%.2f", sum);
	}
	
	public String toString() {
		String result = "";
		for (SalesItem item: saleList) {
			result += item.toString();
		}
		return result;
	}
}
