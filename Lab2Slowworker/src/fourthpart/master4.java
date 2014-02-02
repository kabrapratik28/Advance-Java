package fourthpart;

import java.util.Vector;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import thirdpart.slowworker3;

public class master4 {

	/**
	 * @param args
	 */
	int a, counter = 0;

	public int incrementar() {
		counter = counter + 1;
		return counter;
	}

	public int masterwork() {
		System.out.println("Master doing counting");
		a = 10;
		while (a < 20) {
			a = a + 1;
			try {
				System.out.println("Master" + String.valueOf(a));
				Thread.sleep(10);
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
		ExecutorService ex = Executors.newFixedThreadPool(5);
		Vector vec = new Vector(5);
		final master4 m4 = new master4();
	

		int k = 0;
		while (k < 5) {
			Future<Object> fut = ex.submit(new Callable<Object>() {
				public Object call() throws Exception {
					slowworker4 s4 = new slowworker4();
					int tempo = s4.workworker(m4.incrementar());
					return tempo;
				}
			});
			vec.addElement(fut);
			k = k + 1;
		}
		
		m4.masterwork();
		
		try {
			k = 0;
			while (k < 5) {
				Future ftemp = (Future) vec.get(k);
				System.out.println("Excutor rturned value : "
						+ String.valueOf(ftemp.get()));
				k = k + 1;
			}

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("InterruptedException");
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			System.out.println("ExecutionException");
		}
		System.out.println("DONE ... ");
		long end = System.currentTimeMillis();

		System.out.println("Total time require : "
				+ String.valueOf((end - begin) / 1000.0));
	}

}
