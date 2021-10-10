package hirata;

public class Main {

	public static void main(String[] args) {
		Dictionary dictionary = new Dictionary();
		
		for (int i = 0; i < args.length; i++) {
			dictionary.insertWordNode(args[i]);
		}
		
		dictionary.displayDictionary();
		System.out.println(dictionary.spellCheck("the"));

	}

}
