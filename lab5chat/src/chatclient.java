import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class chatclient {

	/**
	 * @param args
	 */

	JButton OK;
	JLabel host, port;
	JFrame frame_client_start;
	JTextField HOST_PATH, PORT_PATH;
	JPanel HOST_PANEL, PORT_PANEL, OK_PANEL;
	Socket clientSocket;
	OutputStream outputStream = null;
	static BufferedReader bufferedReader = null;
	String to_send;
	static String to_recieve;

	public void Start_client() {
		frame_client_start = new JFrame("Client Start");
		frame_client_start.setSize(600, 200);
		frame_client_start.setLayout(new GridLayout(3, 1));

		JPanel HOST_PANEL = new JPanel();
		JPanel PORT_PANEL = new JPanel();
		JPanel OK_PANEL = new JPanel();

		host = new JLabel("Host");
		HOST_PATH = new JTextField(25);
		HOST_PATH.setText("localhost"); // bydefault

		JLabel port = new JLabel("Port");
		PORT_PATH = new JTextField(25);
		PORT_PATH.setText("3000"); // bydefault

		OK = new JButton("OK");

		frame_client_start.add(HOST_PANEL);
		frame_client_start.add(PORT_PANEL);
		frame_client_start.add(OK_PANEL);

		HOST_PANEL.add(host);
		HOST_PANEL.add(HOST_PATH);

		PORT_PANEL.add(port);
		PORT_PANEL.add(PORT_PATH);

		OK_PANEL.add(OK);

		frame_client_start.setVisible(true);

		OK.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame_client_start.setVisible(false);
				client_running();
			}
		});

	}

	static JTextArea ALL_Messages;
	JTextField MY_Message;
	JButton Send,Close_all;
	JScrollPane scroller;
	JFrame frame_chatting;
	JPanel ALL_MESS_PANEL, SEND_PANEL ,Close_panel;

	public void client_running() {
		
		ALL_Messages = new JTextArea(5, 20);
		ALL_Messages.setEditable(false);
		scroller = new JScrollPane(ALL_Messages);
		MY_Message = new JTextField(20);
		Send = new JButton("Send");
		Close_all = new JButton("Close") ; 
		frame_chatting = new JFrame("Chat");
		frame_chatting.setSize(400, 200);
		frame_chatting.setLayout(new GridLayout(3, 1));

		ALL_MESS_PANEL = new JPanel();
		SEND_PANEL = new JPanel();
		Close_panel = new JPanel() ;
		
		ALL_MESS_PANEL.add(scroller);
		SEND_PANEL.add(MY_Message);
		SEND_PANEL.add(Send);
		Close_panel.add(Close_all);
		
		frame_chatting.add(ALL_MESS_PANEL);
		frame_chatting.add(SEND_PANEL);
		frame_chatting.add(Close_panel);
		
		frame_chatting.setVisible(true);
		
		try {
			clientSocket = new Socket(HOST_PATH.getText(),
					Integer.parseInt(PORT_PATH.getText()));
			bufferedReader = new BufferedReader(new InputStreamReader(
					clientSocket.getInputStream()));
			outputStream = clientSocket.getOutputStream();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			System.out.println("Client connection problem");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Client connection problem IOexception");
		}
		
		
		Send.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				to_send = MY_Message.getText() + "\n";
				try {
					outputStream.write(to_send.getBytes());
					MY_Message.setText("");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					System.out.println("Writting is problem");
				}
			}
		});
		
		Close_all.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					frame_chatting.setVisible(false);
					bufferedReader.close() ; 
					outputStream.close();
					clientSocket.close() ; 
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					System.out.println("Clossing resources problem");
				}
			}
		});
		

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		chatclient chc1 = new chatclient();
		chc1.Start_client();
		while (true) {
			try {
				
				to_recieve = bufferedReader.readLine();
				if (to_recieve != null) {
					to_recieve = to_recieve + "\n" ; 
					ALL_Messages.append(to_recieve);
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				System.out.println("Buffered reader problem in client reading");
			}

		}
		
	}

}
