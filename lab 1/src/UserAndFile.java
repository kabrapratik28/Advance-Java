import java.awt.FlowLayout;
import java.awt.GridLayout;

import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
public class UserAndFile {
static int count = 0 ; 
static int total_no; 
static String empid ; 
static  ArrayList<employee> emp_array1 ; 
static String to_no ;
static JLabel now_up_total ;
static  JLabel job_id ;
static  JLabel name_e  ; 
static  JLabel sur_e ; 
static  JLabel srt_yr ;
static  JLabel DOB ; 
static  JButton NEXT_BUTTON  ;
static  JButton PRE_BUTTON  ;
static JButton FAST_NEXT_BUTTON ; 
static JButton FAST_PRE_BUTTON ; 
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		final JFrame frame_file = new JFrame("Employee Managment");
        //Display the window.
        frame_file.setSize(600, 200);
        frame_file.setLayout(new GridLayout(2, 1)) ; 
        JPanel OPEN_PANEL = new JPanel();
        JPanel OK_PANEL = new JPanel() ; 
        
        final JButton CHOOSE_BROWSE = new JButton("BROWSE") ; 
        final JTextField FILE_PATH = new JTextField(25);
        final JButton OK = new JButton("OK");
        
        frame_file.add(OPEN_PANEL);
        frame_file.add(OK_PANEL);
        OPEN_PANEL.add(FILE_PATH);
        OPEN_PANEL.add(CHOOSE_BROWSE);
        OK_PANEL.add(OK) ; 
        frame_file.setVisible(true);
        
        // Action Listner using ananymous class
        OK.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			frame_file.setVisible(false);
			final JFrame frame_display = new JFrame("Employee Information");
			JPanel panel_total_dis = new JPanel() ; 
			JPanel panel_id = new JPanel() ; 
			JPanel panel_name = new JPanel() ; 
			JPanel panel_surname = new JPanel() ; 
			JPanel panel_srt_yr = new JPanel() ; 
			JPanel panel_DOB = new JPanel() ; 
			JPanel panel_button = new JPanel() ; 
			
			emp_array1 = new ArrayList<employee>();
			emp_array1 = filereader(FILE_PATH.getText()) ; 
			total_no = emp_array1.size();
			employee e2 ; 
			e2 = emp_array1.get(0) ; 
			to_no = Integer.toString(total_no-1);
			final JLabel now_up_total = new JLabel("0 / "+to_no) ;
			empid = Integer.toString(e2.Job_id);
			final JLabel job_id = new JLabel("ID : "+empid);
			final JLabel name_e = new JLabel("Name : "+e2.Name) ; 
			final JLabel sur_e = new JLabel("Surname : "+e2.Surname) ; 
			final JLabel srt_yr = new JLabel("Start Year : "+e2.Start_year);
			final JLabel DOB = new JLabel("Date of Birth : "+e2.DOB); 
			JButton NEXT_BUTTON = new JButton(">") ;
			JButton PRE_BUTTON = new JButton("<") ;
			JButton FAST_NEXT_BUTTON = new JButton(">>") ;
			JButton FAST_PRE_BUTTON = new JButton("<<") ;
			panel_total_dis.add(now_up_total) ; 
			panel_id.add(job_id) ; 
			panel_name.add(name_e) ;
			panel_surname.add(sur_e) ; 
			panel_srt_yr.add(srt_yr) ; 
			panel_DOB.add(DOB) ; 
			panel_button.add(NEXT_BUTTON)  ; 
			panel_button.add(PRE_BUTTON);
			panel_button.add(FAST_NEXT_BUTTON)  ; 
			panel_button.add(FAST_PRE_BUTTON);
			frame_display.add(panel_total_dis);
			frame_display.add(panel_id);
			frame_display.add(panel_name);
			frame_display.add(panel_surname);
			frame_display.add(panel_srt_yr);
			frame_display.add(panel_DOB);
			frame_display.add(panel_button);
			frame_display.setSize(1000, 300);
			frame_display.setLayout(new GridLayout(7,1));
			frame_display.setVisible(true);
			

			FAST_NEXT_BUTTON.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					count = count +5 ;
					if (count > emp_array1.size()-1)
					{
						count = 0 ; 
					} 
					employee e2 ; 
					e2 = emp_array1.get(count) ; 
					total_no = emp_array1.size();
					to_no = Integer.toString(total_no-1);
					String cu_number_string ;
					cu_number_string = Integer.toString(count);
					empid = Integer.toString(e2.Job_id);
					now_up_total.setText(cu_number_string+"/ "+to_no) ;
				    job_id.setText("ID : "+empid);
					name_e.setText ("Name : "+e2.Name) ; 
					sur_e.setText("Surname : "+e2.Surname) ; 
					srt_yr.setText("Start Year : "+e2.Start_year);
					DOB.setText("Date of Birth : "+e2.DOB); 
				}
			});
			
			FAST_PRE_BUTTON.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					count = count -5  ;
					if (count < 0 )
					{
						count = emp_array1.size()-1 ; 
					} 
					employee e2 ; 
					e2 = emp_array1.get(count) ; 
					total_no = emp_array1.size();
					to_no = Integer.toString(total_no-1);
					String cu_number_string ;
					cu_number_string = Integer.toString(count);
					empid = Integer.toString(e2.Job_id);
					now_up_total.setText(cu_number_string+"/ "+to_no) ;
				    job_id.setText("ID : "+empid);
					name_e.setText ("Name : "+e2.Name) ; 
					sur_e.setText("Surname : "+e2.Surname) ; 
					srt_yr.setText("Start Year : "+e2.Start_year);
					DOB.setText("Date of Birth : "+e2.DOB); 
				}
			});
			NEXT_BUTTON.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					count = count +1 ;
					if (count > emp_array1.size()-1)
					{
						count = 0 ; 
					} 
					employee e2 ; 
					e2 = emp_array1.get(count) ; 
					total_no = emp_array1.size();
					to_no = Integer.toString(total_no-1);
					String cu_number_string ;
					cu_number_string = Integer.toString(count);
					empid = Integer.toString(e2.Job_id);
					now_up_total.setText(cu_number_string+"/ "+to_no) ;
				    job_id.setText("ID : "+empid);
					name_e.setText ("Name : "+e2.Name) ; 
					sur_e.setText("Surname : "+e2.Surname) ; 
					srt_yr.setText("Start Year : "+e2.Start_year);
					DOB.setText("Date of Birth : "+e2.DOB); 
				}
			});
			
			PRE_BUTTON.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					count = count -1 ;
					if (count < 0 )
					{
						count = emp_array1.size()-1 ; 
					} 
					employee e2 ; 
					e2 = emp_array1.get(count) ; 
					total_no = emp_array1.size();
					to_no = Integer.toString(total_no-1);
					String cu_number_string ;
					cu_number_string = Integer.toString(count);
					empid = Integer.toString(e2.Job_id);
					now_up_total.setText(cu_number_string+"/ "+to_no) ;
				    job_id.setText("ID : "+empid);
					name_e.setText ("Name : "+e2.Name) ; 
					sur_e.setText("Surname : "+e2.Surname) ; 
					srt_yr.setText("Start Year : "+e2.Start_year);
					DOB.setText("Date of Birth : "+e2.DOB); 
				}
			});
			
			}		
		});
        
       
        
        CHOOSE_BROWSE.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFileChooser filechoose = new JFileChooser();
				int value = filechoose.showOpenDialog(null);
				if (value == JFileChooser.APPROVE_OPTION )
				{
					FILE_PATH.setText(filechoose.getSelectedFile().getAbsolutePath())	;
				}
			}
		}) ; 

	}
	
public static ArrayList<employee> filereader(String filepath)
	{
	     ArrayList<employee> emp_array = new ArrayList<employee>();
	     //employee e1 = new employee() ;
	     //e1.Name = "Pratik" ; 
	     //emp_array.add(e1);
	
	     try {
			BufferedReader buffer_reader = new BufferedReader(new FileReader(filepath));
			String record ; 
			while ((record = buffer_reader.readLine())!= null)
			{
				String[] parts = record.split(";;") ; 
				employee e1 = new employee() ;
				int id = Integer.parseInt(parts[0]); 
				e1.Job_id = id;
				e1.Name = parts[1] ; 
				e1.Surname = parts[2] ; 
				e1.Start_year = parts[3];
				e1.DOB = parts[4] ; 
				emp_array.add(e1);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("File has problem.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("IO Exception.");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception caught!!!");
		}
	     
	     
	     
	     return emp_array ; 
	}


}

