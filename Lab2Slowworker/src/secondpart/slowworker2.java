package secondpart;

public class slowworker2 {
	public int workworker()
	{
		int c ; 
		System.out.println("Slow worker doing counting");
		c = 30;
		while (c < 40) {
			c = c + 1 ; 
			try {
				System.out.println("Slow worker " + String.valueOf(c));
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println("Exception thrown by worker");
			}

		}
		return c ; 
	}

}
