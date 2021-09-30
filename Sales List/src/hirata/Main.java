package hirata;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Main {

	private JFrame frame;
	private JTextField txtFieldItem;
	private JTextField txtFieldCost;
	private JTextField txtFieldQuantity;
	private JButton btnAddItem;
	private JTextArea textArea;
	private SalesSlip salesSlip = new SalesSlip();
	private JLabel lblTotalSales;
	private JTextField txtFieldTotal;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
		
		btnAddItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			addItem();  //HANDLER FOR EVENT
			}
		});
	}
	
	public void addItem() {
		salesSlip.addSalesItem(txtFieldItem.getText(), txtFieldCost.getText(), txtFieldQuantity.getText());
		textArea.setText(salesSlip.toString());
		txtFieldTotal.setText(salesSlip.computeTotalSales());
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblItem = new JLabel("Item:");
		lblItem.setBounds(83, 19, 61, 16);
		frame.getContentPane().add(lblItem);
		
		JLabel lblCost = new JLabel("Cost: $");
		lblCost.setBounds(83, 47, 61, 16);
		frame.getContentPane().add(lblCost);
		
		JLabel lblQuantity = new JLabel("Quantity:");
		lblQuantity.setBounds(83, 75, 61, 16);
		frame.getContentPane().add(lblQuantity);
		
		txtFieldItem = new JTextField();
		txtFieldItem.setBounds(224, 14, 130, 26);
		frame.getContentPane().add(txtFieldItem);
		txtFieldItem.setColumns(10);
		
		txtFieldCost = new JTextField();
		txtFieldCost.setBounds(224, 42, 130, 26);
		frame.getContentPane().add(txtFieldCost);
		txtFieldCost.setColumns(10);
		
		txtFieldQuantity = new JTextField();
		txtFieldQuantity.setBounds(224, 70, 130, 26);
		frame.getContentPane().add(txtFieldQuantity);
		txtFieldQuantity.setColumns(10);
		
		btnAddItem = new JButton("Add Item To Sales List");
		btnAddItem.setBounds(132, 103, 182, 29);
		frame.getContentPane().add(btnAddItem);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(93, 144, 262, 77);
		frame.getContentPane().add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		lblTotalSales = new JLabel("Total Sales: $");
		lblTotalSales.setBounds(83, 236, 92, 16);
		frame.getContentPane().add(lblTotalSales);
		
		txtFieldTotal = new JTextField();
		txtFieldTotal.setBounds(224, 233, 130, 26);
		frame.getContentPane().add(txtFieldTotal);
		txtFieldTotal.setColumns(10);
	}
}
