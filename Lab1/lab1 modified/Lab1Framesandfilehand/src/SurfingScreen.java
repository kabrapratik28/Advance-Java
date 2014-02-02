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
import javax.swing.JPanel;

public class SurfingScreen {
	String empid, cu_number_string;
	int current, count, total_no;
	employee e2;
	ArrayList<employee> emp_array1;
	String to_no;

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
		
	JLabel now_up_total = new JLabel("");
	JLabel job_id = new JLabel("ID : ");           
	JLabel name_e = new JLabel("Name : ");			
	JLabel sur_e = new JLabel("Surname : ");		
	JLabel srt_yr = new JLabel("Start Year : ");
	JLabel DOB = new JLabel("Date of Birth : ");
	
	public SurfingScreen(String filename) {
		count = 0;
		emp_array1 = new ArrayList<employee>();
		emp_array1 = filereader(filename);
		total_no = emp_array1.size();
		to_no = Integer.toString(total_no - 1);
		DisplayIntialization();

	}

	public void DisplayIntialization() {
		JFrame frame_display = new JFrame("Employee Information");
		JPanel panel_total_dis = new JPanel();
		JPanel panel_id = new JPanel();
		JPanel panel_name = new JPanel();
		JPanel panel_surname = new JPanel();
		JPanel panel_srt_yr = new JPanel();
		JPanel panel_DOB = new JPanel();
		JPanel panel_button = new JPanel();
/*		JLabel now_up_total = new JLabel("");
		JLabel job_id = new JLabel("ID : ");            // DONT PUT HERE 
		JLabel name_e = new JLabel("Name : ");			//OTHER CLASSES ASSESS GLOBAL
		JLabel sur_e = new JLabel("Surname : ");		// SO DEFINE OUTSIDE
		JLabel srt_yr = new JLabel("Start Year : ");
		JLabel DOB = new JLabel("Date of Birth : ");
*/
		JButton NEXT_BUTTON = new JButton(">");
		JButton PRE_BUTTON = new JButton("<");
		JButton FAST_NEXT_BUTTON = new JButton(">>");
		JButton FAST_PRE_BUTTON = new JButton("<<");
		panel_total_dis.add(now_up_total);
		panel_id.add(job_id);
		panel_name.add(name_e);
		panel_surname.add(sur_e);
		panel_srt_yr.add(srt_yr);
		panel_DOB.add(DOB);
		panel_button.add(NEXT_BUTTON);
		panel_button.add(PRE_BUTTON);
		panel_button.add(FAST_NEXT_BUTTON);
		panel_button.add(FAST_PRE_BUTTON);
		frame_display.add(panel_total_dis);
		frame_display.add(panel_id);
		frame_display.add(panel_name);
		frame_display.add(panel_surname);
		frame_display.add(panel_srt_yr);
		frame_display.add(panel_DOB);
		frame_display.add(panel_button);
		frame_display.setSize(1000, 300);
		frame_display.setLayout(new GridLayout(7, 1));
		
		setter(0);
		
		frame_display.setVisible(true);

		NEXT_BUTTON.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// TODO Auto-generated method stub
				count = count + 1;
				if (count > emp_array1.size() - 1) {
					count = 0;
				}
				setter(count);

			}
		});
		
		PRE_BUTTON.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				count = count - 1;
				if (count < 0) {
					count = emp_array1.size() - 1;
				}
				setter(count);
			}
		});
		
		FAST_NEXT_BUTTON.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				count = count + 5;
				if (count > emp_array1.size() - 1) {
					count = 0;
				}
				setter(count);
			}
		});
		
		FAST_PRE_BUTTON.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				count = count - 5;
				if (count < 0) {
					count = emp_array1.size() - 1;
				}
				setter(count);
			}
		});

	}

	public void setter(int counter) {

		e2 = emp_array1.get(counter);

		cu_number_string = Integer.toString(count);
		empid = Integer.toString(e2.Job_id);
		now_up_total.setText(cu_number_string + "/ " + to_no);
		job_id.setText("ID : " + empid);
		name_e.setText("Name : " + e2.Name);
		sur_e.setText("Surname : " + e2.Surname);
		srt_yr.setText("Start Year : " + e2.Start_year);
		DOB.setText("Date of Birth : " + e2.DOB);

	}

	public ArrayList<employee> filereader(String filepath) {
		ArrayList<employee> emp_array = new ArrayList<employee>();
		// employee e1 = new employee() ;
		// e1.Name = "Pratik" ;
		// emp_array.add(e1);

		try {
			BufferedReader buffer_reader = new BufferedReader(new FileReader(
					filepath));
			String record;
			while ((record = buffer_reader.readLine()) != null) {
				String[] parts = record.split(";;");
				employee e1 = new employee();
				int id = Integer.parseInt(parts[0]);
				e1.Job_id = id;
				e1.Name = parts[1];
				e1.Surname = parts[2];
				e1.Start_year = parts[3];
				e1.DOB = parts[4];
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

		return emp_array;
	}

}
