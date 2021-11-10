package hirata;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;

public class Main {

	static int LOC = 0; // Variable to hold total lines of code
	
	public static void main(String[] args) {
		File file = new File("/Users/yurikahirata/Desktop/KeywordTest.txt");
		
		Scanner countScan = null; // Scanner for counting keywords
		Scanner methodScan = null; // Scanner for finding methods
		Scanner locScan = null; // Scanner to count total lines of code
		
		try {
			countScan = new Scanner(file);
			methodScan = new Scanner(file);
			locScan = new Scanner(file);
			
			
			countKeywords(countScan);
			
			ArrayList<String> list = createArrayListMCS(methodScan);
			for (int i = 0; i< list.size(); i++) {
				System.out.println(list.get(i));
			}
			
			linesOfCode(locScan);
			
		} catch (FileNotFoundException e){
			
			System.out.println("Error - file not found");
			
		} finally {
			
			if (countScan != null)
				countScan.close();
			
		}
	}
	
		// Method to find methods in the file
		public static ArrayList<String> createArrayListMCS (Scanner fileScan) {
			Stack<String> myStack = new Stack<String>();
			
			String currentCodeLine = "";
			String prevCodeLine = "";
			
			
			ArrayList <String> list = new ArrayList<String>();
			
			while (fileScan.hasNextLine()) {
				currentCodeLine = fileScan.nextLine();
				currentCodeLine = currentCodeLine.trim();
				
				// Is it a code line
				 if (currentCodeLine.length() > 0) {
					 if (!currentCodeLine.equals("{") && !currentCodeLine.equals("}"))
						 prevCodeLine = currentCodeLine;
					 else if (currentCodeLine.equals("{"))
						 myStack.push(prevCodeLine);
					 else
						 list.add(0, myStack.pop());
				 }
			}
			
			return list;
			
		}
	
		// Method to count keywords for control structures
		public static void countKeywords (Scanner fileScan) {
			String [] controlKeywords = {"else if", "if", "else", "switch", "for", "while", "break", "continue"};
			Set <String> controlSet = new HashSet<>(Arrays.asList(controlKeywords));
			
			Map<String, Integer> keywordTreeMap = new TreeMap<>();

			
			while (fileScan.hasNext()) {
				String word = fileScan.next();
				
				if (controlSet.contains(word)) {
					if (!keywordTreeMap.containsKey(word)) {
						keywordTreeMap.put(word, 1);
					} else {
						int value = keywordTreeMap.get(word);
						value ++;
						keywordTreeMap.put(word, value);
					}
				}
			}
			
			keywordTreeMap.forEach((key, value)-> System.out.println(key + "\t" + value));
			System.out.println();

	}
		
		// Method to count lines of code
		public static void linesOfCode (Scanner fileScan) {
			String line = "";
			
			while (fileScan.hasNextLine()) {
				line = fileScan.nextLine();
				
				if (line.contains("/*")) { // If block comment
					do {
						line = fileScan.nextLine();
					} while (!line.contains("*/"));
					line = fileScan.nextLine();
				} else if (line.contains("/") || line.length()==0) { // If comment or empty line
					line = fileScan.nextLine();
				} else {
					LOC++;
				}
			}
			System.out.println("\nTotal lines of code: " + LOC);
		}
		

}
