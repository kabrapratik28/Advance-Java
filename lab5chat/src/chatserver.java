import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class chatserver {

	/**
	 * @param args
	 */
	JButton OK;
	JLabel host, port;
	JFrame frame_server_start;
	JTextField HOST_PATH, PORT_PATH;
	JPanel HOST_PANEL, PORT_PANEL, OK_PANEL;
	ServerSocket listener;
	Socket socket;
	int identity=0 ; 
	static HashMap<Integer, OutputStream> Clients ; 
	
	public void Start_server() {
		frame_server_start = new JFrame("Server Start");
		frame_server_start.setSize(600, 200);
		frame_server_start.setLayout(new GridLayout(2, 1));

		// JPanel HOST_PANEL = new JPanel();
		JPanel PORT_PANEL = new JPanel();
		JPanel OK_PANEL = new JPanel();

		// host = new JLabel("Host") ;
		// HOST_PATH = new JTextField(25);
		// HOST_PATH.setText("localhost"); // bydefault

		JLabel port = new JLabel("Port");
		PORT_PATH = new JTextField(25);
		PORT_PATH.setText("3000"); // bydefault

		OK = new JButton("OK");

		// frame_server_start.add(HOST_PANEL);
		frame_server_start.add(PORT_PANEL);
		frame_server_start.add(OK_PANEL);

		// HOST_PANEL.add(host);
		// HOST_PANEL.add(HOST_PATH);

		PORT_PANEL.add(port);
		PORT_PANEL.add(PORT_PATH);

		OK_PANEL.add(OK);

		frame_server_start.setVisible(true);

		OK.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame_server_start.setVisible(false);
				server_running();
			}
		});

	}

	public void server_running() {
		try {
			// hash map objects
			Clients = new HashMap<>(); 
			listener = new ServerSocket(Integer.parseInt(PORT_PATH.getText()));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			System.out.println("Number Format Exception");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("IO exception");
		}

		while (true) {
			try {
				socket = listener.accept();
				clientserving c1 = new clientserving(socket, identity++);
				clientserving.sender_to_all("Joined "+String.valueOf(identity-1)+"chat room\n");
				OutputStream outputStream = socket.getOutputStream() ; 
				outputStream.write(("Welcome "+String.valueOf(identity-1)+"\n").getBytes());
				Clients.put(identity-1, outputStream);
				c1.start();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("IO exception");
			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		chatserver chs1 = new chatserver();
		chs1.Start_server();
	}

}
