package fifthpart;

import java.util.concurrent.Callable;

public class middlelayerbetween_ms_task implements Callable{
	
	private completionlistner listner ; 
	int slowworkernumber ; 
	public middlelayerbetween_ms_task(int k)
	{
		slowworkernumber = k ; 
	}
	
	public Object call() throws Exception {
		// TODO Auto-generated method stub
		int onecounter = new slowworker5().workworker(slowworkernumber);
		
		listner.workdone(onecounter) ; 
		
		return null;
	}

	public void addlistner (completionlistner c1)
	{
		this.listner = c1 ; 
	}
	
}
