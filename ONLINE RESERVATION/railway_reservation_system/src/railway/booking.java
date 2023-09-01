package railway;
import java .util.Random;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.UIManager;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;

public class booking {
	Random rand=new Random();
	int r=rand.nextInt(1000000);
	private JFrame frmReservationPage;
	private JFrame frmReservationPage_1;
	private String[] no = {"1","2","3","4","5","6"};
	private String[] board= {"Jasidih","Madhupur","Howrah","Sonarpur","Bhubaneshwar","Ranchi","Jammu Tawi"};
	private String[] destination= {"Jasidih","Madhupur","Howrah","Sonarpur","Bhubaneshwar","Ranchi","Jammu Tawi","Tatanagar Jn"};
	private String dates[]
		     = { "1", "2", "3", "4", "5",
		         "6", "7", "8", "9", "10",
		         "11", "12", "13", "14", "15",
		         "16", "17", "18", "19", "20",
		         "21", "22", "23", "24", "25",
		         "26", "27", "28", "29", "30",
		         "31" };
	private String months[]
		     = { "Jan", "feb", "Mar", "Apr",
		         "May", "Jun", "July", "Aug",
		         "Sep", "Oct", "Nov", "Dec" };
		 private String years[]
		     = { "1995", "1996", "1997", "1998",
		         "1999", "2000", "2001", "2002",
		         "2003", "2004", "2005", "2006",
		         "2007", "2008", "2009", "2010",
		         "2011", "2012", "2013", "2014",
		         "2015", "2016", "2017", "2018",
		         "2019" };
	
	private JTextField trnno;
	private JTextField trnname;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton btnNewButton;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					booking window = new booking();
					window.frmReservationPage_1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	

	/**
	 * Create the application.
	 */
	public booking() {
		initialize();
		try {
			Connect();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	
	
		 
	public void Connect() throws SQLException
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost/railway","root","");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmReservationPage = new JFrame();
		frmReservationPage_1 = new JFrame();
		frmReservationPage_1.getContentPane().setBackground(new Color(216, 191, 216));
		frmReservationPage_1.setBackground(new Color(250, 240, 230));
		frmReservationPage_1.setForeground(new Color(0, 0, 0));
		frmReservationPage_1.setTitle("RESERVATION PAGE");
		frmReservationPage_1.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\shrit\\OneDrive\\Pictures\\Saved Pictures\\download.png"));
		frmReservationPage_1.setBounds(450, 100, 513, 572);
		frmReservationPage_1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmReservationPage_1.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Passenger No.:-");
		lblNewLabel.setBounds(29, 47, 121, 22);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		frmReservationPage_1.getContentPane().add(lblNewLabel);
		
		JLabel lblBoarding = new JLabel("Boarding:-");
		lblBoarding.setBounds(29, 96, 91, 22);
		lblBoarding.setFont(new Font("Tahoma", Font.BOLD, 15));
		frmReservationPage_1.getContentPane().add(lblBoarding);
		
		JLabel lblTrainNo = new JLabel("Train No.:-");
		lblTrainNo.setBounds(29, 198, 91, 22);
		lblTrainNo.setFont(new Font("Tahoma", Font.BOLD, 15));
		frmReservationPage_1.getContentPane().add(lblTrainNo);
		
		JLabel lblTrainName = new JLabel("Train Name:-");
		lblTrainName.setBounds(29, 253, 106, 22);
		lblTrainName.setFont(new Font("Tahoma", Font.BOLD, 15));
		frmReservationPage_1.getContentPane().add(lblTrainName);
		
		JLabel lblPrice = new JLabel("Price:-");
		lblPrice.setBounds(29, 309, 91, 13);
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 15));
		frmReservationPage_1.getContentPane().add(lblPrice);
		
		JLabel lblDate = new JLabel("Date:-");
		lblDate.setBounds(29, 364, 91, 13);
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 15));
		frmReservationPage_1.getContentPane().add(lblDate);
		
		JLabel lblTotal = new JLabel("Total:-");
		lblTotal.setBounds(29, 424, 91, 13);
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 15));
		frmReservationPage_1.getContentPane().add(lblTotal);
		
		JLabel lblDestination = new JLabel("Destination:-");
		lblDestination.setBounds(29, 145, 106, 22);
		lblDestination.setFont(new Font("Tahoma", Font.BOLD, 15));
		frmReservationPage_1.getContentPane().add(lblDestination);
		
		
		JComboBox no1 = new JComboBox(no);
		no1.setBounds(188, 50, 90, 21);
		frmReservationPage_1.getContentPane().add(no1);
		
		 final JComboBox txtsplace = new JComboBox(board);
		
		txtsplace.setBounds(186, 99, 92, 21);
		frmReservationPage_1.getContentPane().add(txtsplace);
		
		final JComboBox destination1 = new JComboBox(destination);
		
		destination1.setBounds(189, 145, 89, 21);
		frmReservationPage_1.getContentPane().add(destination1);
		
		trnno = new JTextField();
		trnno.setBounds(188, 202, 96, 19);
		frmReservationPage_1.getContentPane().add(trnno);
		trnno.setColumns(10);
		
		JButton searchbtn = new JButton("Search");
		searchbtn.setBounds(294, 123, 106, 21);
		searchbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(destination1.getSelectedItem().equals(txtsplace.getSelectedItem()))
					JOptionPane.showMessageDialog(null,"Please select differnt source and destination",null, JOptionPane.WARNING_MESSAGE);
				String splace=txtsplace.getSelectedItem().toString();
				String eplace=destination1.getSelectedItem().toString();
				
				
				try {
					pst=con.prepareStatement("SELECT * FROM traindetails where tsrc=? and tdst=?");
					pst.setString(1, splace);
					pst.setString(2, eplace);
					rs=pst.executeQuery();
					if(rs.next()==true)
					{
						trnno.setText(rs.getString(1));
						trnname.setText(rs.getString(2));
						
					}
					else
						JOptionPane.showMessageDialog(null,"record not found",null, JOptionPane.WARNING_MESSAGE);
				}catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		searchbtn.setBackground(new Color(192, 192, 192));
		searchbtn.setFont(new Font("Tahoma", Font.BOLD, 20));
		frmReservationPage_1.getContentPane().add(searchbtn);
		
		trnname = new JTextField();
		trnname.setBounds(188, 257, 96, 19);
		frmReservationPage_1.getContentPane().add(trnname);
		trnname.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(188, 308, 96, 19);
		frmReservationPage_1.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		final JComboBox comboBox = new JComboBox(dates);
		comboBox.setBounds(189, 364, 42, 21);
		frmReservationPage_1.getContentPane().add(comboBox);
		
		textField_2 = new JTextField();
		textField_2.setBounds(188, 410, 96, 19);
		frmReservationPage_1.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		final JComboBox comboBox_1 = new JComboBox(months);
		comboBox_1.setBounds(241, 362, 43, 21);
		frmReservationPage_1.getContentPane().add(comboBox_1);
		
		final JComboBox comboBox_2 = new JComboBox(years);
		comboBox_2.setBounds(294, 364, 58, 21);
		frmReservationPage_1.getContentPane().add(comboBox_2);
		 btnNewButton = new JButton("Book");
		 btnNewButton.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		if (e.getSource() == btnNewButton) {
			         
		             String data1="\n Train No:-"+trnno.getText() ;
		             String data="\n Train Name:-"+trnname.getText() ;
		            String data2="\n Price"+textField_1.getText();
		           String data3="\n Total Price"+textField_2.getText();
		           String data4="Booking ID:-"+r;				           
		           String data6="Boarding:-"+txtsplace.getSelectedItem().toString();
		           String data7="\nDestination:-"+destination1.getSelectedItem().toString();
		           String data5
	                 = "\n Date Of Journey : "
	                   + (String)comboBox.getSelectedItem()
	                   + "/" + (String)comboBox_1.getSelectedItem()
	                   + "/" + (String)comboBox_2.getSelectedItem()
	                   + "\n";
		           String multi_line=data4+data + data1 + data2 +data3+data5+data6+data7;
					JOptionPane.showMessageDialog(null,"YOUR TICKET HAS BEEN BOOKED\n"+multi_line,null,JOptionPane.PLAIN_MESSAGE, null );

		             
		}

		 	}
		 });
		
		btnNewButton.setBounds(157, 472, 121, 37);
		btnNewButton.setBackground(new Color(255, 192, 203));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		frmReservationPage_1.getContentPane().add(btnNewButton);
		
	}
	
}