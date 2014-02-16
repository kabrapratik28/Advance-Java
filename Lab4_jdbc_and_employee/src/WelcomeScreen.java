import java.awt.Button;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class WelcomeScreen {
	
	
	JButton OK  ; 
	JTextField FILE_PATH ;
	JFrame frame_file ; 
	public WelcomeScreen()
	{
		final JFrame frame_file = new JFrame("Employee Managment");
		frame_file.setSize(600, 200);
		frame_file.setLayout(new GridLayout(3, 1));
		JPanel HOST_PANEL = new JPanel();
		JPanel PORT_PANEL = new JPanel();
		JPanel OK_PANEL = new JPanel();
		
		JLabel host = new JLabel("Host") ; 
		final JTextField HOST_PATH = new JTextField(25);
		HOST_PATH.setText("localhost");  // bydefault
		
		JLabel port = new JLabel("Port") ; 
		final JTextField PORT_PATH = new JTextField(25);
		PORT_PATH.setText("3306") ;  //bydefault
		
		JButton OK = new JButton("OK");

		frame_file.add(HOST_PANEL);
		frame_file.add(PORT_PANEL);
		frame_file.add(OK_PANEL);
		
		HOST_PANEL.add(host);
		HOST_PANEL.add(HOST_PATH);
		
		PORT_PANEL.add(port);
		PORT_PANEL.add(PORT_PATH);
		
		OK_PANEL.add(OK);
		
		frame_file.setVisible(true);
		
		OK.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame_file.setVisible(false);
				SurfingScreen sc1 = new SurfingScreen(HOST_PATH.getText(),PORT_PATH.getText()) ; 				
			}
		});
		
		

		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WelcomeScreen wel1 = new WelcomeScreen();
	
	}

}
