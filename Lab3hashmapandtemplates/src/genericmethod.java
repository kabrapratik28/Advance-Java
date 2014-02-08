import java.nio.charset.Charset;
import java.util.ArrayList;


public class genericmethod {
	
public <E> void printarray(ArrayList<E> arraylis){
	for (E oneelement: arraylis){
		System.out.println(oneelement);
	}
}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		genericmethod g1 = new genericmethod() ; 
		ArrayList<Integer> in = new ArrayList<Integer>() ; 
		in.add(1);
		in.add(2);
		in.add(5);
		in.add(11) ; 
		g1.printarray(in) ; 
		
		ArrayList<Character> in2 = new ArrayList<Character>() ; 
		in2.add('j');
		in2.add('k');
		in2.add('p');
		in2.add('s') ; 
		g1.printarray(in2) ;
		
		ArrayList<String> in3 = new ArrayList<String>() ; 
		in3.add("pratik");
		in3.add("jyoti");
		in3.add("shrikant");
		in3.add("pratiksha") ; 
		g1.printarray(in3) ;
		
		
	}

}
