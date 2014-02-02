
public class master1 {

	/**
	 * @param args
	 */
	int a,b,c,d ; 
	public int masterwork()
	{
		a = 10 ; 
		b = 20 ; 
		System.out.println("Master working calculating addtion");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception thrown by master");
		}
		a = a  + b ;
		return a   ;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long begin = System.currentTimeMillis();
		master1 m1  = new master1();
		slowworker1 s1 = new slowworker1();
		System.out.println(m1.masterwork() + s1.workworker());
		long end = System.currentTimeMillis(); 

		System.out.println("Total time require : "+String.valueOf((end-begin)/1000.0));
	}

}
