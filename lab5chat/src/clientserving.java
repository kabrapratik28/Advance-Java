import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;


public class clientserving extends Thread{
	int  identity;
	Socket socket ; 
	BufferedReader bufferedReader ; 
	String message ; 
	clientserving(Socket socketobj, int identityno)
	{
		socket = socketobj; 
		identity = identityno ; 
		try {
			bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Input reading error");
		}
	}
	
public static boolean my_isInteger(String s) {
	    try { 
	        Integer.parseInt(s); 
	    } catch(NumberFormatException e) { 
	        return false; 
	    }
	    // only got here if we didn't return false
	    return true;
	}

public static void sender_to_all(String msg1){
	
	for ( OutputStream o1:  chatserver.Clients.values()){
		try {
			o1.write(msg1.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Writting is a problem");
		}
	}
}
	
	public void run() {

		while(true)
		{
			try {
				message = bufferedReader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Readline is a problem");
			}
			if(message!=null)
			{	
				if(my_isInteger(message))
				{
					int k = Integer.parseInt(message) ;
					try{
						chatserver.Clients.remove(k);
					}
					catch(Exception e)
					{
						System.out.println("Client removed already or not present");
					}
					sender_to_all("Leaving "+String.valueOf(k)+"\n");
				}
				else
				{
					message = message +"\n" ; 
					sender_to_all(message);
				}
			}
			
		}		
	}
}
