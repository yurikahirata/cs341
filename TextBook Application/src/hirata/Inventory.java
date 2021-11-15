package hirata;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Inventory implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static ArrayList<TextBook> bookList;

	public Inventory() {
		bookList = new ArrayList<TextBook>();
	}

	public Inventory (Object object) {
		bookList = (ArrayList<TextBook>) object;
	}

	// Method to add textbook
	public void addTextBook(String sku, String title, double price, Integer quantity) {
		TextBook book = new TextBook(sku, title, price, quantity);
		bookList.add(book);
	}

	// Method to delete a textbook with sku
	public String deleteTextBook(String sku) {
		// Checking if book with given sku exists
		TextBook temp = bookList.parallelStream().filter(book -> sku.equals(book.getSku())).findFirst().orElse(null);
		if (temp != null) {
			bookList.remove(temp);
			return "";
		} else {
			return "Book with given SKU not found.";
		}


	}

	// Method to display a textbook with a given sku
	public String displayBook(String sku) {
		try { // Checking if book with given sku exists
			TextBook temp = bookList.parallelStream().filter(book -> sku.equals(book.getSku())).findFirst().orElse(null);
			String result = "Title: " + temp.getTitle() + "\tSKU: " + temp.getSku() + "\tPrice: $" + temp.getPrice() + "\tQuantity: " + temp.getQuantity() + "\n";
			return result;
		} catch (Exception e) {
			return "Book with given SKU not found";
		}

	}

	// Method to display inventory
	public String displayInventory() {
		String result = "";
		if (bookList.size() > 0) { // If inventory is not empty
			for (int i = 0; i < bookList.size() ; i++) {
				TextBook temp = bookList.get(i);
				result += "Title: " + temp.getTitle() + "\tSKU: " + temp.getSku() + "\tPrice: $" + temp.getPrice() + "\tQuantity: " + temp.getQuantity() + "\n";
			}
		} else { // If empty inventory
			result += "Empty inventory";
		}
		return result;
	}
	
	public void serialize() {
		try {
	         FileOutputStream fileOut = new FileOutputStream(new File ("/Users/yurikahirata/Desktop/CS_341_01/inventoryObject.ser"));
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(bookList);
	         out.close();
	         fileOut.close();
	      } catch (Exception e) {
	         e.printStackTrace();
	         
	      }
	}
}
