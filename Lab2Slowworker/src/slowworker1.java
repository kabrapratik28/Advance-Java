
public class slowworker1 {
	public int workworker()
	{
		System.out.println("Slow worker doing addtion");
		int c ,d ; 
		c = 30 ; 
		d = 40 ; 
		c = c + d ; 
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception thrown by worker");
		}
		return c ; 
	}

}
