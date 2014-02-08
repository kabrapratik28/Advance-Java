import java.util.ArrayList;


public class Box<T> {

	/**
	 * @param args
	 */
	
	ArrayList<T>  a   ; 
	public Box(){
		a = new ArrayList<T>(10); 
	}
	public void adder(T e){
		a.add(e) ; 
	}
	public T valgiver(int position)
	{
		T local = a.get(position); 
		return local ; 
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Box<Integer> b1 = new Box<Integer>() ;
		b1.adder(2);
		b1.adder(100); 
		b1.adder(193); 
		b1.adder(55) ;
		System.out.println(b1.valgiver(2));
		
		Box<String> b3 = new Box<String>() ;
		b3.adder("Pratik");
		b3.adder("Kabara"); 
		b3.adder("Pratiksha"); 
		b3.adder("J S") ;
		System.out.println(b3.valgiver(1));
		
	}

}
