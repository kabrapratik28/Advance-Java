package fifthpart;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class master5 implements completionlistner{

	/**
	 * @param args
	 */
	int a ; 
	public int masterwork() {
		System.out.println("Master doing counting");
		a = 10;
		while (a < 20) {
			a = a + 1;
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
	
	public void workdone(int integer1 ){
		
		System.out.println("Counting done by worker : "+String.valueOf(integer1));
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long begin = System.currentTimeMillis();
		master5 m5 =  new master5() ; 
		ExecutorService ex = Executors.newFixedThreadPool(3);
		middlelayerbetween_ms_task mlay = new middlelayerbetween_ms_task(1);
		mlay.addlistner(m5);
		Future f1 = ex.submit(mlay);
		m5.masterwork() ; 
		long end = System.currentTimeMillis();

		System.out.println("Total time require : "+ String.valueOf((end - begin) / 1000.0));
	}

}
