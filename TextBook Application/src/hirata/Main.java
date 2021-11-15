package hirata;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Main {

	private JFrame frame;
	private JTextField textFieldSKU;
	private JTextField textFieldTitle;
	private JTextField textFieldPrice;
	private JTextField textFieldQuantity;
	private JTextField textFieldSkuDelete;
	private JButton btnAddBook;
	private JButton btnDeleteBook;
	private JButton btnDisplayBook;
	private JButton btnDisplayInventory;
	private Inventory myInventory;
	private JScrollPane scrollPane;
	private JTextArea textArea;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Main() {
		initialize();
		
		
		
		btnAddBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addTextBook();
			}
		});
		
		btnDeleteBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteBook();
			}
		});
		
		btnDisplayBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayBook();
			}
		});
		
		btnDisplayInventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayInventory();
			}
		});
	}
	
	public void addTextBook() {
		myInventory.addTextBook(textFieldSKU.getText(), textFieldTitle.getText(), Double.parseDouble(textFieldPrice.getText()), Integer.parseInt(textFieldQuantity.getText()));
	}
	
	public void displayBook() {
		String skuDisplay = textFieldSkuDelete.getText();
		textArea.setText(myInventory.displayBook(skuDisplay));
	}
	
	public void deleteBook() {
		String skuDelete = textFieldSkuDelete.getText();
		textArea.setText(myInventory.deleteTextBook(skuDelete));
	}
	
	public void displayInventory() {
		textArea.setText(myInventory.displayInventory());
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 442);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowOpened (java.awt.event.WindowEvent windowEvent) {
		    	try {
			         FileInputStream fileIn = new FileInputStream(new File ("/Users/yurikahirata/Desktop/CS_341_01/inventoryObject.ser"));
			         ObjectInputStream in = new ObjectInputStream(fileIn);
			         myInventory = new Inventory(in.readObject());
			         in.close();
			         fileIn.close();
			      } catch (Exception e) {
			         e.printStackTrace();
			         myInventory = new Inventory();
			         return;
			      }
		    }
			
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		        myInventory.serialize();
		    }
		    
		});
		frame.getContentPane().setLayout(null);

	
		
		
		JLabel lblSku = new JLabel("SKU:");
		lblSku.setBounds(26, 27, 40, 16);
		frame.getContentPane().add(lblSku);
		
		textFieldSKU = new JTextField();
		textFieldSKU.setBounds(88, 22, 97, 26);
		frame.getContentPane().add(textFieldSKU);
		textFieldSKU.setColumns(10);
		
		JLabel lblTitle = new JLabel("Title:");
		lblTitle.setBounds(220, 27, 40, 16);
		frame.getContentPane().add(lblTitle);
		
		textFieldTitle = new JTextField();
		textFieldTitle.setBounds(272, 22, 130, 26);
		frame.getContentPane().add(textFieldTitle);
		textFieldTitle.setColumns(10);
		
		JLabel lblPrice = new JLabel("Price: $");
		lblPrice.setBounds(26, 63, 61, 16);
		frame.getContentPane().add(lblPrice);
		
		textFieldPrice = new JTextField();
		textFieldPrice.setBounds(88, 60, 97, 26);
		frame.getContentPane().add(textFieldPrice);
		textFieldPrice.setColumns(10);
		
		JLabel lblQuantity = new JLabel("Quantity:");
		lblQuantity.setBounds(220, 63, 61, 16);
		frame.getContentPane().add(lblQuantity);
		
		textFieldQuantity = new JTextField();
		textFieldQuantity.setBounds(295, 58, 107, 26);
		frame.getContentPane().add(textFieldQuantity);
		textFieldQuantity.setColumns(10);
		
		btnAddBook = new JButton("Add Book");
		btnAddBook.setBounds(155, 96, 117, 29);
		frame.getContentPane().add(btnAddBook);
		
		JLabel lblSku_1 = new JLabel("SKU:");
		lblSku_1.setBounds(145, 137, 40, 16);
		frame.getContentPane().add(lblSku_1);
		
		textFieldSkuDelete = new JTextField();
		textFieldSkuDelete.setBounds(197, 132, 97, 26);
		frame.getContentPane().add(textFieldSkuDelete);
		textFieldSkuDelete.setColumns(10);
		
		btnDeleteBook = new JButton("Delete Book");
		btnDeleteBook.setBounds(91, 165, 117, 29);
		frame.getContentPane().add(btnDeleteBook);
		
		btnDisplayBook = new JButton("Display Book");
		btnDisplayBook.setBounds(220, 165, 117, 29);
		frame.getContentPane().add(btnDisplayBook);
		
		btnDisplayInventory = new JButton("Display Inventory");
		btnDisplayInventory.setBounds(88, 206, 249, 29);
		frame.getContentPane().add(btnDisplayInventory);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(55, 257, 323, 124);
		frame.getContentPane().add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
	}
}
