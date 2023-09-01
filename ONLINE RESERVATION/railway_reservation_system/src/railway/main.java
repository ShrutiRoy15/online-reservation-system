package railway;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Color;

public class main {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main window = new main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(210, 180, 140));
		frame.getContentPane().setForeground(new Color(210, 180, 140));
		frame.setBounds(550, 200, 401, 284);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton add = new JButton("ADD TRAIN");
		add.setBackground(new Color(255, 240, 245));
		add.setFont(new Font("Tahoma", Font.BOLD, 12));
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Addtrain obj2=new Addtrain();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Addtrain.main(null);
			}
		});
		add.setBounds(48, 108, 105, 48);
		frame.getContentPane().add(add);
		
		JButton reserv = new JButton("RESERVATION");
		reserv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				booking obj3=new booking();
				booking.main(null);
				
			}
		});
		reserv.setBackground(new Color(255, 240, 245));
		reserv.setFont(new Font("Tahoma", Font.BOLD, 12));
		reserv.setBounds(206, 108, 131, 48);
		frame.getContentPane().add(reserv);
		
		JLabel Label1 = new JLabel("RAILWAY RESERVATION SYSTEM");
		Label1.setFont(new Font("Verdana", Font.BOLD, 15));
		Label1.setBounds(48, 43, 325, 35);
		frame.getContentPane().add(Label1);
	}

	

}
