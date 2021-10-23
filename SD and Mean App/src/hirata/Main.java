package hirata;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Main {

	private JFrame frame;
	private JTextField textFieldMean;
	private JTextField textFieldSD;
	private JTextField textFieldNote;
	private JButton btnAddFile;
	private JFileChooser j;
	private Scanner sc;
	private File file;
	private LinkedList linkedList;
	
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

		btnAddFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculate();  // Event handler
			}
		});
	}

	// Method to find file, add numbers to LinkedList, and calculate mean and SD
	public void calculate() {
		linkedList = new LinkedList();

		j = new JFileChooser();
		int result = j.showOpenDialog(null);
		if (result == JFileChooser.APPROVE_OPTION) {
			file = j.getSelectedFile();
			try {
				sc = new Scanner(file);
				while (sc.hasNext()) { // Loop to add all numbers to the Linked List
					try {
						linkedList.addNode(sc.nextDouble());
					} catch (InputMismatchException e) { // If a non numeric string is encountered, leave the method
						textFieldNote.setText("Invalid number in file");
						return;
					}
				}
				textFieldMean.setText(linkedList.getMean());
				textFieldSD.setText(linkedList.getSD());
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		else if (result == JFileChooser.CANCEL_OPTION) // If user cancels while selecting a file
			textFieldNote.setText("File selection cancelled");

	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		btnAddFile = new JButton("Add File");
		btnAddFile.setBounds(164, 35, 117, 29);
		frame.getContentPane().add(btnAddFile);

		JLabel lblMean = new JLabel("Mean:");
		lblMean.setBounds(164, 103, 43, 16);
		frame.getContentPane().add(lblMean);

		JLabel lblSD = new JLabel("Standard deviation:");
		lblSD.setBounds(80, 145, 129, 16);
		frame.getContentPane().add(lblSD);

		textFieldMean = new JTextField();
		textFieldMean.setBounds(219, 98, 182, 26);
		frame.getContentPane().add(textFieldMean);
		textFieldMean.setColumns(10);

		textFieldSD = new JTextField();
		textFieldSD.setBounds(221, 140, 180, 26);
		frame.getContentPane().add(textFieldSD);
		textFieldSD.setColumns(10);

		textFieldNote = new JTextField();
		textFieldNote.setBounds(123, 203, 208, 26);
		frame.getContentPane().add(textFieldNote);
		textFieldNote.setColumns(10);
	}
}
