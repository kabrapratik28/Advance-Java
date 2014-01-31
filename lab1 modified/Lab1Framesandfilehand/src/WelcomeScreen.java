import java.awt.Button;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
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
		frame_file.setLayout(new GridLayout(2, 1));
		JPanel OPEN_PANEL = new JPanel();
		JPanel OK_PANEL = new JPanel();
		JButton CHOOSE_BROWSE = new JButton("BROWSE");
		final JTextField FILE_PATH = new JTextField(25);
		JButton OK = new JButton("OK");
		frame_file.add(OPEN_PANEL);
		frame_file.add(OK_PANEL);
		OPEN_PANEL.add(FILE_PATH);
		OPEN_PANEL.add(CHOOSE_BROWSE);
		OK_PANEL.add(OK);
		
		frame_file.setVisible(true);
		
		OK.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame_file.setVisible(false);
				SurfingScreen sc1 = new SurfingScreen(FILE_PATH.getText()) ; 				
			}
		});
		
		
		CHOOSE_BROWSE.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFileChooser filechoose = new JFileChooser();
				int value = filechoose.showOpenDialog(null);
				if (value == JFileChooser.APPROVE_OPTION) {
					FILE_PATH.setText(filechoose.getSelectedFile()
							.getAbsolutePath());
				}
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
