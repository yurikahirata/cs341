package hirata;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;

public class Main {

	private JFrame frame;
	private JButton btnChoose;
	private File file;
	private JTextField textFieldHrs;
	private JTextField textFieldOutput;
	private JButton btnPerformLinearRegression;
	private Scanner sc;
	private ArrayList<Double> xData;
	private ArrayList<Double> yData;
	private LinearRegression myRegression;

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
		
		btnChoose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			chooseFile();  //HANDLER FOR EVENT
			}
		});
		
		btnPerformLinearRegression.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			calculateRegression();  //HANDLER FOR EVENT
			}
		});
	}

	private void chooseFile() {
		xData = new ArrayList<Double>();
		yData = new ArrayList<Double>();
	
		
		JFileChooser j = new JFileChooser();
		int result = j.showOpenDialog(null);
		if (result == JFileChooser.APPROVE_OPTION) {
			file = j.getSelectedFile();
			try {
				sc = new Scanner(file);
				while (sc.hasNextLine()) {
					xData.add(sc.nextDouble());
					yData.add(sc.nextDouble());
				}
				
				myRegression = new LinearRegression(xData, yData);
				
			} catch (FileNotFoundException e) {
				textFieldOutput.setText("File not found");
			}
			
		}
		else if (result == JFileChooser.CANCEL_OPTION) // If user cancels while selecting a file
			textFieldOutput.setText("File selection cancelled");
	}
	
	// Method calling calculation of linear regression
	private void calculateRegression() {
		if (xData.isEmpty()) { // If file is not selected
			textFieldOutput.setText("Please select a file");
		} else {
			int var = Integer.parseInt(textFieldHrs.getText());
			int predictedBugs = myRegression.predictForValue(var);
			textFieldOutput.setText("There will be " + predictedBugs + " bugs for " + var + " hours of coding");
		}
		
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		btnChoose = new JButton("Select Data File");
		btnChoose.setBounds(141, 30, 163, 29);
		frame.getContentPane().add(btnChoose);
		
		JLabel lblNewLabel = new JLabel("Hours of coding expected:");
		lblNewLabel.setBounds(69, 87, 180, 16);
		frame.getContentPane().add(lblNewLabel);
		
		textFieldHrs = new JTextField();
		textFieldHrs.setBounds(261, 82, 101, 26);
		frame.getContentPane().add(textFieldHrs);
		textFieldHrs.setColumns(10);
		
		textFieldOutput = new JTextField();
		textFieldOutput.setBounds(41, 209, 362, 26);
		frame.getContentPane().add(textFieldOutput);
		textFieldOutput.setColumns(10);
		
		btnPerformLinearRegression = new JButton("Perform Linear Regression");
		btnPerformLinearRegression.setBounds(127, 148, 194, 29);
		frame.getContentPane().add(btnPerformLinearRegression);
		
		
		
		
		
	}
}
