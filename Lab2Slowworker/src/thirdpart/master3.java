package thirdpart;

public class master3 {

	/**
	 * @param args
	 */
	int a;

	public int masterwork() {
		System.out.println("Master doing counting");
		a = 10;
		while (a < 20) {
			a = a + 1 ; 
			try {
				System.out.println("Master" + String.valueOf(a));
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println("Exception thrown by master");
			}

		}
		return a;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long begin = System.currentTimeMillis();
		
		master3 m3 = new master3() ; 
		m3.masterwork() ;
		int k = 0 ; 
		while(k<5)
		{
			slowworker3 s3 = new slowworker3() ; 
			s3.workworker(k);
			k = k +1 ; 
		}
		System.out.println("Done");
		long end = System.currentTimeMillis(); 

		System.out.println("Total time require : "+String.valueOf((end-begin)/1000.0));
	
	}

}
