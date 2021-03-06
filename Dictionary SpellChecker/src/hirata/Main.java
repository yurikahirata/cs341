package hirata;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Dictionary dictionary = new Dictionary();
		
		File file = new File("/Users/yurikahirata/Desktop/HW4InputSample.txt");
		Scanner sc = null;
		
		ArrayList<String> arrayList = new ArrayList<String>();
		
		try {
			System.out.println("Looking for file");
			sc = new Scanner(file);
			System.out.println("file found \n");
			grabSort(sc, arrayList);

		} catch (IOException e) {
			System.out.println("File not found \n");
		}
		finally {
			if (sc != null)
				sc.close();
		}
		
		for (int i = 0; i < arrayList.size(); i++) {
			dictionary.insertWordNode(arrayList.get(i).replaceAll("\\s",""));
		}
		
		System.out.println("Displaying the dictionary: ");
		dictionary.displayDictionary();
		System.out.println();
		System.out.println("'You' exists within this dictionary: " + dictionary.spellCheck("you"));
		System.out.println("'Zebra' exists within this dictionary: " + dictionary.spellCheck("zebra") + "\n");
		
		

	}
	
	public static void grabSort(Scanner sc, ArrayList<String> arrList) {
		while (sc.hasNext()) {
			arrList.add(sc.next());
		}
	}

}
