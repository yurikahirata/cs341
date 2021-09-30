package hirata;

import java.util.ArrayList;

public class SalesSlip {
	ArrayList<SalesItem> saleList;
	
	public SalesSlip () {
		saleList = new ArrayList<SalesItem>();
	}
	
	public void addSalesItem(SalesItem s) {
		saleList.add(s);
	}
	
	public String computeTotalSales() {
		double sum = 0;
		for (SalesItem item: saleList) {
			sum += (item.getPrice() * item.getQuantity());
		}
		return sum + "";
	}
	
	public String toString() {
		String result = "";
		for (SalesItem item: saleList) {
			result += item.toString();
		}
		return result;
	}
}
