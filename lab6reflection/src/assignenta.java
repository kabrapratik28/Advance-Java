import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class assignenta {

	/**
	 * @param args
	 */
	
	Class c1; 
	Class[] parameterlist ; 
	Constructor constructor ; 
	Constructor[] constructors ; 
	

	public void gui()
	{
		final JFrame frame_file = new JFrame("Class name");
		frame_file.setSize(600, 200);
		frame_file.setLayout(new GridLayout(2, 1));
		JPanel OPEN_PANEL = new JPanel();
		JPanel OK_PANEL = new JPanel();
		final JTextField classname = new JTextField(25);
		JButton OK = new JButton("OK");
		frame_file.add(OPEN_PANEL);
		frame_file.add(OK_PANEL);
		OPEN_PANEL.add(classname);
		OK_PANEL.add(OK);
		
		frame_file.setVisible(true);
		
		OK.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame_file.setVisible(false);
				classgetting(classname.getText()) ; 	
			}
		});
		
		
	}
	public void classgetting(String classname)
	{
		try {
			c1 = Class.forName(classname);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Sorry , Class not found ");
		}
		
		constructors = c1.getConstructors() ; 
		
		for (Constructor cs: constructors)
		{
			System.out.println(cs);
		}
		
		try {
			constructor = c1.getConstructor(new Class[]{String.class});
			Employee myObject = (Employee) constructor.newInstance("Pratik");
			System.out.println(myObject.rollc);
			
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			System.out.println("No method");
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			System.out.println("Security exception");
		}catch(Exception e)
		{
			System.out.println("Object creation may be a problem");
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		assignenta a1 = new assignenta();
		a1.gui();
	}

}
