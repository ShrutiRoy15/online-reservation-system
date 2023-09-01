package railway;

import java.awt.Checkbox;
import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.awt.SystemColor;
import java.awt.Color;

public class Login extends JFrame {

	private JFrame frame;
	public JTextField getname;
	public JTextField getmobile;
	public JPasswordField getpass;
	 private ButtonGroup gengp;
	protected Object tpassword;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.inactiveCaption);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\shrit\\OneDrive\\Pictures\\Saved Pictures\\download.png"));
		frame.setBounds(500, 100, 471, 478);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel welcome = new JLabel("Welcome to railway login");
		welcome.setFont(new Font("Stencil", Font.PLAIN, 18));
		welcome.setBounds(106, 10, 290, 89);
		frame.getContentPane().add(welcome);
		
		JLabel name = new JLabel("NAME:");
		name.setFont(new Font("Tahoma", Font.PLAIN, 17));
		name.setBounds(23, 101, 84, 29);
		frame.getContentPane().add(name);
		
		JLabel mobile = new JLabel("MOBILE:-");
		mobile.setFont(new Font("Tahoma", Font.PLAIN, 16));
		mobile.setBounds(23, 169, 84, 29);
		frame.getContentPane().add(mobile);
		
		JLabel password = new JLabel("PASSWORD:-");
		password.setFont(new Font("Tahoma", Font.PLAIN, 16));
		password.setBounds(10, 237, 118, 21);
		frame.getContentPane().add(password);
		
		final JCheckBox terms = new JCheckBox("accept terms and conditions");
		terms.setFont(new Font("Tahoma", Font.PLAIN, 13));
		terms.setBounds(52, 395, 227, 21);
		frame.getContentPane().add(terms);
		
		gengp = new ButtonGroup();
		
		getname = new JTextField();
		getname.setBounds(175, 109, 187, 19);
		frame.getContentPane().add(getname);
		getname.setColumns(10);
		
		getmobile = new JTextField();
		getmobile.setBounds(175, 176, 187, 19);
		frame.getContentPane().add(getmobile);
		getmobile.setColumns(10);
		
		getpass = new JPasswordField();
		getpass.setBounds(175, 240, 187, 19);
		frame.getContentPane().add(getpass);
		getpass.setColumns(10);
		
		final JButton login = new JButton("LOGIN");
		login.setBackground(new Color(255, 228, 196));
		login.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				registration re = new registration();
				
				if(e.getSource()==login) {
					if(terms.isSelected()==false)
						JOptionPane.showMessageDialog(login,"Accept terms and condition",null, JOptionPane.WARNING_MESSAGE);
					else {
				if(getname.getText().equals("") && getmobile.getText().equals("") && getpass.getText().equals("")) {
					JOptionPane.showMessageDialog(login,"Please fill the fields",null, JOptionPane.WARNING_MESSAGE);
					getname.setText(null);
					getmobile.setText(null);
					getpass.setText(null);
					
				}
				else if(getname.getText().equals("Shruti") && getmobile.getText().equals("8340601671") && getpass.getText().equals("1234") )
				{
					getname.setText(null);
					getmobile.setText(null);
					getpass.setText(null);
					new main();
					main.main(null);
					
					
					} 
				
				else
						JOptionPane.showMessageDialog(login,"user not found",null, JOptionPane.WARNING_MESSAGE);
			} 
					
					
				}		
			}

			
					
		}); 
		login.setFont(new Font("Tahoma", Font.BOLD, 16));
		login.setBounds(35, 313, 104, 29);
		frame.getContentPane().add(login);
		
		JButton reset = new JButton("RESET");
		reset.setBackground(new Color(255, 228, 196));
		reset.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				getname.setText("");
				getmobile.setText("");
				getpass.setText("");
			}
		});
		reset.setFont(new Font("Tahoma", Font.BOLD, 16));
		reset.setBounds(220, 316, 92, 23);
		frame.getContentPane().add(reset);
	}

	
}
