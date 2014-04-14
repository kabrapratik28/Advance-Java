import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class assignb {
	String classnamev ; 
	JPanel OPEN_PANEL ,FIRST_PANEL,SEC_PANEL; 
	JTextField classname  ;
	JButton OK ; 
	TextArea methodname,conslist,interfacelist,xlist; 
	public void gui()
	{
		final JFrame frame_file = new JFrame("Class name");
		frame_file.setSize(1000, 600);
		frame_file.setLayout(new GridLayout(3, 1));
		OPEN_PANEL = new JPanel();
		FIRST_PANEL = new JPanel();
		SEC_PANEL = new JPanel(); 
		
		classname = new JTextField(25);
		OK = new JButton("OK");
		
		methodname = new TextArea(50,50);
		conslist = new TextArea(50,50);
		interfacelist = new TextArea(50,50); 
		xlist = new TextArea(50,50); 
		
		frame_file.add(OPEN_PANEL);
		frame_file.add(FIRST_PANEL);
		frame_file.add(SEC_PANEL); 
		
		FIRST_PANEL.add(methodname);
		FIRST_PANEL.add(conslist);
		
		SEC_PANEL.add(interfacelist);
		SEC_PANEL.add(xlist);
		
		OPEN_PANEL.add(classname);
		OPEN_PANEL.add(OK);
		
		
		frame_file.setVisible(true);
		
		OK.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				classnamev = classname.getText();	
				setallfields() ; 
			}
		});

		
	}
	
	public void setallfields()
	{
		Class c1 =null; 
		Class[] inter =null; 
		Constructor[] constructors ; 
		interfacelist.setText("");
		conslist.setText("");
		methodname.setText("");
		xlist.setText("");
		try {
			c1 = Class.forName(classnamev) ;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("No class found");
		} 
		
		inter = c1.getInterfaces() ; // interfaces
		for(Class dd : inter)
		{
			interfacelist.append( dd.toString()+"\n") ; 
		}
		
		constructors = c1.getConstructors();
		for(Constructor cc : constructors)
		{
			/*Class[] parameterTypes = cc.getParameterTypes();
			for (Class dk:parameterTypes)
			{
				conslist.append(dk.getName()+" ,");
			}
			conslist.append("\n");*/
			conslist.append(cc.toString()+"\n");
		}
		
		Method[] meth = c1.getMethods() ; 
		for (Method m1 : meth)
		{
			methodname.append(m1.getName()+"\n"); 
		}
		
		
		Field[] fields = c1.getFields();
		for (Field f1 : fields)
		{
			xlist.append(f1.getName()+"\n"); 
		}
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		assignb b1 = new assignb() ; 
		b1.gui();
	}

}
