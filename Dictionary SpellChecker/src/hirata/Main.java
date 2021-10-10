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
			System.out.println("file found");
			grabSort(sc, arrayList);

		} catch (IOException e) {
			System.out.println("File not found");
		}
		finally {
			if (sc != null)
				sc.close();
		}
		
		for (int i = 0; i < arrayList.size(); i++) {
			dictionary.insertWordNode(arrayList.get(i).replaceAll("\\s",""));
		}
		
		dictionary.displayDictionary();
		System.out.println("'You' exists within this dictionary: " + dictionary.spellCheck("you"));
		//dictionary.displayDictionary();
		dictionary.checkWord("your");
		System.out.println();
		dictionary.displayDictionary();

	}
	
	public static void grabSort(Scanner sc, ArrayList<String> arrList) {
		while (sc.hasNext()) {
			arrList.add(sc.next());
		}
	}

}
