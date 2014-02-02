package thirdpart;

public class slowworker3 {
	public int workworker(int sno)
	{
		int c ; 
		System.out.println("Slow worker "+String.valueOf(sno)+"doing counting");
		c = 30;
		while (c < 40) {
			c = c + 1 ; 
			try {
				System.out.println("Slow worker "+String.valueOf(sno)+" doing count" + String.valueOf(c));
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println("Exception thrown by worker");
			}

		}
		return c ; 
	}

}
