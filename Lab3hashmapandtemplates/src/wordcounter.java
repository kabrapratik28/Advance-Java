import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;


public class wordcounter {
	String input;
	ArrayList<String> wordsinline;
	HashMap<String, Integer> hm;
	public wordcounter() {
		wordsinline = new ArrayList<String>();
		hm = new HashMap<String, Integer>();
	}

	public String linetakerfromuser() {
		Scanner scanner = new Scanner(new InputStreamReader(System.in));
		input = scanner.nextLine();
		return input;
	}

	public void tokenscounter() {
		for (String line : wordsinline) {
			String[] partsofline = line.split("\\s+");
			for (String wordone : partsofline) {
				boolean value = hm.containsKey(wordone);
				if (value) {
					hm.put(wordone, hm.get(wordone) + 1);
				} else {
					// No such key
					hm.put(wordone, 1);
				}
			}
		}
	}

	public void sentense_adder() {
		wordsinline.add(input);
	}
public void printhashmap(){
	Set<String> keys = hm.keySet();  
	for (String key : keys) {  
	    System.out.println(key + "=" + hm.get(key)); 
	}  
}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input1 = "", current = "-1";
		wordcounter w1 = new wordcounter();
		while (true) {
			input1 = w1.linetakerfromuser();
			if (!input1.equals(current)) {
				w1.sentense_adder();
			} else {
				break;
			}
		}
		w1.tokenscounter() ; 
		w1.printhashmap() ; 
	}

}
