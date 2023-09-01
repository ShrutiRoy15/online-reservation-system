package railway;

import java.awt.EventQueue;
import java.sql.Connection;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.Font;


public class Addtrain {

	private JFrame frmTrains;
	private JTextField tname;
	private JTextField tno;
	private JTextField tsource;
	private JTextField tdestination;
	private final JButton editbtn = new JButton("EDIT");
	DefaultTableModel model;
	private JTable table;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Addtrain window = new Addtrain();
					window.frmTrains.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws SQLException 
	 */
	public Addtrain() throws SQLException {
		initialize();
		Connect();
		Train_Details();
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
		
	
	
	
	public void Train_Details()
	{
		try {
			pst=con.prepareStatement("select * from traindetails");
		
			
		rs=pst.executeQuery();
		ResultSetMetaData rsd = rs.getMetaData();
		int c=rsd.getColumnCount();
		DefaultTableModel d=(DefaultTableModel)table.getModel();
		d.setRowCount(0);
		while(rs.next())
		{
			Vector v= new Vector();
			for(int i=1;i<c;i++)
			{
				v.add(rs.getString("tno1"));
				v.add(rs.getString("tname"));
				v.add(rs.getString("tsrc"));
				v.add(rs.getString("tdst"));
				
			}
			d.addRow(v);
		}
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTrains = new JFrame();
		frmTrains.getContentPane().setBackground(new Color(47, 79, 79));
		frmTrains.setTitle("TRAINS");
		frmTrains.setBounds(350, 200, 844, 405);
		frmTrains.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTrains.getContentPane().setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_1.setBackground(new Color(245, 222, 179));
		panel_1.setBounds(35, 83, 228, 170);
		
		frmTrains.getContentPane().add(panel_1);
		
		JLabel lname = new JLabel("TRAIN NAME:-");
		lname.setBounds(30,20,70,50);
		panel_1.add(lname);
		
		tname = new JTextField();
		panel_1.add(tname);
		tname.setColumns(10);
		
		JLabel lno = new JLabel("TRAIN No:-");
		panel_1.add(lno);
		
		tno = new JTextField();
		panel_1.add(tno);
		tno.setColumns(10);
		
		
		JLabel lsource = new JLabel("SOURCE:-");
		panel_1.add(lsource);
		
		tsource = new JTextField();
		panel_1.add(tsource);
		tsource.setColumns(10);
		
		
		
		JLabel ldestination = new JLabel("DESTINATION:-");
		panel_1.add(ldestination);
		
		tdestination = new JTextField();
		panel_1.add(tdestination);
		tdestination.setColumns(10);
		
		JLabel lprice = new JLabel("PRICE:-");
		panel_1.add(lprice);
		
		 final JTextField tprice = new JTextField();
		panel_1.add(tprice);
		tprice.setColumns(10);
		
				
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollPane.setBounds(309, 70, 509, 274);
		frmTrains.getContentPane().add(scrollPane);
		
		table = new JTable();
		model = new DefaultTableModel();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int i = table.getSelectedRow();
				tname.setText(model.getValueAt(i, 1).toString());
				tno.setText(model.getValueAt(i, 0).toString());
				tdestination.setText(model.getValueAt(i, 3).toString());
				tsource.setText(model.getValueAt(i, 2).toString());
				//tprice.setText(model.getValueAt(i, 5).toString());
			}
		});
		table.setBackground(new Color(255, 228, 225));
		
		 Object[] column= {"train no.","train name","Source","destination"};
		 final Object[] row=new Object[4];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		
		JButton addtrn = new JButton("ADD");
		addtrn.setBackground(new Color(143, 188, 143));
		addtrn.setBounds(12, 318, 69, 26);
		frmTrains.getContentPane().add(addtrn);
		
		
		addtrn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tname.getText().equals("")|| tno.getText().equals("")|| tdestination.getText().equals("")|| tsource.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null,"Please complete the fields...","error", JOptionPane.WARNING_MESSAGE);
				}
				else {
				row[0]=tno.getText();
				row[1]=tname.getText();
				row[3]=tdestination.getText();
				row[2]=tsource.getText();
				tprice.getText();
				
				String tno1=tno.getText();
				String tname1=tname.getText();
				String tdestination1=tdestination.getText();
				String tsource1=tsource.getText();
				
				
				try {
				
				pst= con.prepareStatement("insert into traindetails(tno1,tname,tsrc,tdst)values(?,?,?,?)");
				pst.setString(1, tno1);
				pst.setString(2, tname1);
				pst.setString(3, tsource1);
				pst.setString(4, tdestination1);
				int k=pst.executeUpdate();
				
				if(k==1)
					JOptionPane.showMessageDialog(null,"RECORD ADDED",null, JOptionPane.INFORMATION_MESSAGE);
				else
					JOptionPane.showMessageDialog(null,"RECORD FAILED",null, JOptionPane.INFORMATION_MESSAGE);
				model.addRow(row);
				
				tname.setText("");
				tno.setText("");
				tdestination.setText("");
				tsource.setText("");
				tprice.setText("");
				tno.requestFocus();
				}catch(SQLException ex) {
					Logger.getLogger(Addtrain.class.getName()).log(Level.SEVERE, null, ex);
					
					
				}
				
				
				
				
				JOptionPane.showMessageDialog(null,"Saved Successfully...",null, JOptionPane.INFORMATION_MESSAGE);
				
				}
				
				
			}
			
			
		});
		
		
		
		JButton cancelbtn = new JButton("DELETE");
		cancelbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 int i = table.getSelectedRow();
			        if (i >= 0) {
			            try {
			                String selectedTrainNo = model.getValueAt(i, 0).toString();
			                // Delete the record from the database
			                pst = con.prepareStatement("DELETE FROM traindetails WHERE tno1 = ?");
			                pst.setString(1, selectedTrainNo);
			                int rowsDeleted = pst.executeUpdate();
			                if (rowsDeleted > 0) {
			                    model.removeRow(i);
			                    JOptionPane.showMessageDialog(null, "Train details canceled and deleted successfully.",
			                            null, JOptionPane.INFORMATION_MESSAGE);
			                } else {
			                    JOptionPane.showMessageDialog(null, "Failed to delete train details from the database.",
			                            null, JOptionPane.ERROR_MESSAGE);
			                }
			            } catch (SQLException ex) {
			                Logger.getLogger(Addtrain.class.getName()).log(Level.SEVERE, null, ex);
			            }
			        } else {
			            JOptionPane.showMessageDialog(null, "Select a row to cancel.", null, JOptionPane.INFORMATION_MESSAGE);
			        }
			    }
			});
		
		cancelbtn.setBackground(new Color(240, 128, 128));
		cancelbtn.setBounds(180, 318, 83, 26);
		frmTrains.getContentPane().add(cancelbtn);
		
		
		
		

		editbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				if(i>=0) {
				model.setValueAt(tname.getText(), i, 1);
				model.setValueAt(tno.getText(), i, 0);
				model.setValueAt(tdestination.getText(), i, 3);
				model.setValueAt(tsource.getText(), i, 2);
				
				JOptionPane.showMessageDialog(null,"Update Successfully.....",null, JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(null,"Please add a train first",null, JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		editbtn.setBounds(93, 318, 69, 26);
		frmTrains.getContentPane().add(editbtn);
		editbtn.setBackground(new Color(230, 230, 250));
		
		JLabel lblNewLabel = new JLabel("ADD TRAIN");
		lblNewLabel.setFont(new Font("Algerian", Font.BOLD, 20));
		lblNewLabel.setForeground(new Color(255, 240, 245));
		lblNewLabel.setBounds(297, 12, 228, 26);
		frmTrains.getContentPane().add(lblNewLabel);
		
		
		
	}
}
