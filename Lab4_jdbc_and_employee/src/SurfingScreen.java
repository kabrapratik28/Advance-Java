import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SurfingScreen {
	String empid, cu_number_string;
	int current, count , total_emp_in_database;
	

	employee e1 ;
	databaseconnection d1; 

	JFrame frame_display;
	JPanel panel_total_dis;
	JPanel panel_id;
	JPanel panel_name;
	JPanel panel_surname;
	JPanel panel_srt_yr;
	JPanel panel_DOB;
	JPanel panel_button;

	
	JButton NEXT_BUTTON ;
	JButton PRE_BUTTON ;
	JButton FAST_NEXT_BUTTON ;
	JButton FAST_PRE_BUTTON ;
	JButton CHANGE_BUTTON ; 
	JButton CLOSE_BUTTON ; 

	JLabel job_id ;           
	JLabel name_e ;			
	JLabel sur_e ;		
	JLabel srt_yr;
	JLabel DOB ;
	
	
	JTextField job_idf ; 
	JTextField name_ef ;
	JTextField  sur_ef ;
	JTextField  srt_yrf;
	JTextField  DOBf ;
	
	
	public SurfingScreen(String host , String port) {
		count = 0 ; 
		e1 = new employee();
		d1 =   new databaseconnection(host, port) ; 
		DisplayIntialization();
		total_emp_in_database = d1.size_of_data() ;
		System.out.println(total_emp_in_database);
	}

	
	
	
	public void DisplayIntialization() {
		frame_display = new JFrame("Employee Information");
		panel_total_dis = new JPanel();
		panel_id = new JPanel();
		panel_name = new JPanel();
		panel_surname = new JPanel();
		panel_srt_yr = new JPanel();
		panel_DOB = new JPanel();
		panel_button = new JPanel();
		
		job_id = new JLabel("ID : ");            // DONT PUT HERE 
		name_e = new JLabel("Name : ");			//OTHER CLASSES ASSESS GLOBAL
		sur_e = new JLabel("Surname : ");		// SO DEFINE OUTSIDE
		srt_yr = new JLabel("Start Year : ");
		DOB = new JLabel("Date of Birth : ");

		
		name_ef = new JTextField(30);
		sur_ef = new JTextField(30);
		srt_yrf = new JTextField(30);
		DOBf = new JTextField(30) ; 
		
		
		
		NEXT_BUTTON = new JButton(">");
		PRE_BUTTON = new JButton("<");
		FAST_NEXT_BUTTON = new JButton(">>");
		FAST_PRE_BUTTON = new JButton("<<");
		CHANGE_BUTTON = new JButton("Change");
		CLOSE_BUTTON = new JButton("Close") ; 
		
		panel_id.add(job_id);
		
		panel_name.add(name_e);
		panel_name.add(name_ef);
		
		panel_surname.add(sur_e);
		panel_surname.add(sur_ef );
		
		panel_srt_yr.add(srt_yr);
		panel_srt_yr.add(srt_yrf);
		
		panel_DOB.add(DOB);
		panel_DOB.add(DOBf);
		
		panel_button.add(NEXT_BUTTON);
		panel_button.add(PRE_BUTTON);
		panel_button.add(FAST_NEXT_BUTTON);
		panel_button.add(FAST_PRE_BUTTON);
		panel_button.add(CHANGE_BUTTON);
		panel_button.add(CLOSE_BUTTON);
		
		frame_display.add(panel_total_dis);
		frame_display.add(panel_id);
		frame_display.add(panel_name);
		frame_display.add(panel_surname);
		frame_display.add(panel_srt_yr);
		frame_display.add(panel_DOB);
		frame_display.add(panel_button);
		
		frame_display.setSize(1000, 300);
		frame_display.setLayout(new GridLayout(7, 1));
		
		setter(1);  //default on screen first
		
		frame_display.setVisible(true);

		NEXT_BUTTON.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// TODO Auto-generated method stub
				count = count + 1;
				if (count > total_emp_in_database) {
					count = 1;
				}
				setter(count);

			}
		});
		
		PRE_BUTTON.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				count = count - 1;
				if (count < 1) {
					count = total_emp_in_database;
				}
				setter(count);
			}
		});
		
		FAST_NEXT_BUTTON.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				count = count + 5;
				if (count > total_emp_in_database) {
					count = 1;
				}
				setter(count);
			}
		});
		
		FAST_PRE_BUTTON.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				count = count - 5;
				if (count < 1) {
					count = total_emp_in_database;
				}
				setter(count);
			}
		});

		
		CHANGE_BUTTON.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				employee e4 = new employee();
				e4.Job_id = count ; 
				e4.Name = name_ef.getText() ; 
				e4.Surname = sur_ef.getText();
				e4.Start_year = srt_yrf.getText();
				e4.DOB = DOBf.getText();
				d1.changeemployeedata(e4) ; 
				// popup box in java
				JOptionPane.showMessageDialog(CHANGE_BUTTON, "Successful");
			}
		});
		
		CLOSE_BUTTON.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				d1.closedatabaseconnection() ; 
				frame_display.setVisible(false) ; 
				System.exit(0);
			}
		});
		
		
		
		
	}

	public void setter(int counter) {
		
		e1 = d1.getemployee(counter) ; 
		
		job_id.setText("ID : "+String.valueOf(counter)) ; 
		name_ef.setText(e1.Name);
		sur_ef.setText(e1.Surname);
		srt_yrf.setText(e1.Start_year);
		DOBf.setText( e1.DOB);

	}


}
