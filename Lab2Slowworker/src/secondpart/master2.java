package secondpart;

import java.util.concurrent.Callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class master2 {

	/**
	 * @param args
	 */
	int a;

	public int masterwork() {
		System.out.println("Master doing counting");
		a = 10;
		while (a < 15) {
			a = a + 1 ; 
			try {
				System.out.println("Master" + String.valueOf(a));
				Thread.sleep(1000);
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
		ExecutorService ex = Executors.newFixedThreadPool(4);
		Future<Object> fut = ex.submit(new Callable<Object>() {
			public Object call() throws Exception{
				int k = new slowworker2().workworker() ; 
				return k ; 
			}
		});
		
		master2 m2 =  new master2() ; 
		m2.masterwork() ; 
		try {
			System.out.println("Excutor rturned value : "+String.valueOf(fut.get())) ;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("InterruptedException");
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			System.out.println("ExecutionException");
		} 
		System.out.println("DONE ... ");
		long end = System.currentTimeMillis(); 

		System.out.println("Total time require : "+String.valueOf((end-begin)/1000.0));
	}

}
