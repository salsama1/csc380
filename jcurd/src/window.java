import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class window {

	private JFrame frame;
	private JTextField txtOrdernum;
	private JTextField txtOrdertime;
	private JTextField txtItem;
	private JTextField txtAmount;
	private JTable table;
	private JTextField txtxOrderS;
	private JComboBox comboPhone;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window window = new window();
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
	public window() {
		initialize();
		connect();
		table_load();
		load_data();
	}
	/*
	PreparedStatement pst;
	Connection con;
	ResultSet rs;
	
	public void connect(){
	 try {
	 Class.forName("com.mysql.cj.jdbc.Driver");
	 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/coffe",
	 "root", "");
	 Statement statement = con.createStatement();
	 ResultSet resultSet = statement.executeQuery("select * from designation");
	 int code;
	 String title;
	 while (resultSet.next()) {
	 code = resultSet.getInt("code");
	 title = resultSet.getString("title").trim();
	 System.out.println("Code : " + code + " Title : " + title);
	 }
	 resultSet.close();
	 statement.close();
	 con.close();
	 }
	 catch (Exception exception) {
	 System.out.println(exception);
	 } 
	}*/
	
	 Connection con;
	 PreparedStatement pst;
	 ResultSet rs;
	 private JTextField txtNewON;

	
	public void connect(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/coffe_manage_new",
	 "root", "");
				
		}
		
		catch(ClassNotFoundException ex){
			System.out.print("d");
			
		}
		catch(SQLException ex) {
			System.out.print("s");

			
		}
		
	}
	
	public void table_load() {
		try {
			pst = con.prepareStatement("SELECT * FROM coffe_manage_new.order");
			rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		}
		
		
		catch(SQLException ex) {
			
		}
	}
	
	public void load_data() {
		String tmp = null;
		try {
            String sql="SELECT * FROM customer";
            pst=con.prepareStatement(sql);
            rs = pst.executeQuery(sql);
            while(rs.next()){
               comboPhone.addItem(rs.getString("customer_phone"));
               tmp = (String) comboPhone.getSelectedItem();
            }
            //pst.close();
            //rs.close();
        }catch(Exception e) {
             e.printStackTrace();
        }
	}
	
	
		 

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 621, 624);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("coffee Shop");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 30));
		lblNewLabel.setBounds(10, 11, 194, 99);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "add a new order", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(20, 104, 338, 293);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("order number");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(29, 33, 92, 26);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Ordertime");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(29, 86, 77, 26);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("item");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(29, 138, 77, 26);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("amount");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_3.setBounds(29, 190, 77, 26);
		panel.add(lblNewLabel_1_3);
		
		txtOrdernum = new JTextField();
		txtOrdernum.setBounds(156, 38, 96, 20);
		panel.add(txtOrdernum);
		txtOrdernum.setColumns(10);
		
		txtOrdertime = new JTextField();
		txtOrdertime.setBounds(156, 91, 96, 20);
		panel.add(txtOrdertime);
		txtOrdertime.setColumns(10);
		
		txtItem = new JTextField();
		txtItem.setBounds(156, 143, 96, 20);
		panel.add(txtItem);
		txtItem.setColumns(10);
		
		txtAmount = new JTextField();
		txtAmount.setBounds(156, 195, 96, 20);
		panel.add(txtAmount);
		txtAmount.setColumns(10);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("customer_phone");
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_3_1.setBounds(10, 227, 118, 38);
		panel.add(lblNewLabel_1_3_1);
		
		comboPhone = new JComboBox();
		comboPhone.setBounds(188, 237, 30, 22);
		panel.add(comboPhone);
		
		JButton btnNewButton = new JButton("add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String Ordernum, Ordertime, Item, amount ;
				
				Ordernum = txtOrdernum.getText();
				Ordertime = txtOrdertime.getText();
				Item = txtItem.getText();
				amount = txtAmount.getText();
				
				try {
					pst = con.prepareStatement("INSERT INTO `coffe_manage_new`.`order`(`Ordernum`,`Ordertime`,`Item`,`amount`,`customer_customer_phone`) VALUES(?, ?, ?, ?, ?) ");
					pst.setString(1, Ordernum);
					pst.setString(2, Ordertime);
					pst.setString(3, Item);
					pst.setString(4, amount);
					String value = comboPhone.getSelectedItem().toString();
					pst.setString(5, value);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "added sucssefly");
					table_load();
					txtOrdernum.setText("");
					txtOrdertime.setText("");
					txtItem.setText("");
					txtAmount.setText("");
		            //txtcustomer_phone.setText("");
					txtOrdernum.requestFocus();					

				}catch(SQLException ex) {
					ex.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(30, 408, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(385, 103, 168, 293);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "search", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(20, 463, 338, 54);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1_4 = new JLabel("order number");
		lblNewLabel_1_4.setBounds(28, 17, 92, 26);
		panel_1.add(lblNewLabel_1_4);
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		txtxOrderS = new JTextField();
		txtxOrderS.setColumns(10);
		txtxOrderS.setBounds(173, 22, 96, 20);
		panel_1.add(txtxOrderS);
		
		JButton btnUpdate = new JButton("update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String Ordernum, Ordertime, Item, amount, OldON ;
				
				Ordernum = txtOrdernum.getText();
				Ordertime = txtOrdertime.getText();
				Item = txtItem.getText();
				amount = txtAmount.getText();
				OldON = txtNewON.getText();

				
				try {
					pst = con.prepareStatement("UPDATE `coffe_manage_new`.`order` SET `Ordernum` = ?, `Ordertime` = ?, `Item` = ?, `amount` = ?, `customer_customer_phone` = ? WHERE `Ordernum` = ? ");
					pst.setString(1, Ordernum);
					pst.setString(2, Ordertime);
					pst.setString(3, Item);
					pst.setString(4, amount);
					String value = comboPhone.getSelectedItem().toString();
					pst.setString(5, value);
					pst.setString(6, OldON);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "updated sucssefly");
					table_load();
					txtOrdernum.setText("");
					txtOrdertime.setText("");
					txtItem.setText("");
					txtAmount.setText("");
		            //txtcustomer_phone.setText("");
					txtOrdernum.requestFocus();					

				}catch(SQLException ex) {
					ex.printStackTrace();
				}
				
			}
		});
		btnUpdate.setBounds(372, 426, 89, 23);
		frame.getContentPane().add(btnUpdate);
		
		JButton btnDelete = new JButton("delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Ordernum;
				
				Ordernum = txtOrdernum.getText();
				
				try {
					pst = con.prepareStatement("DELETE FROM `coffe_manage_new`.`order`WHERE Ordernum =?");
					pst.setString(1, Ordernum);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "deleted sucssefly");
					table_load();
					txtOrdernum.setText("");
					txtOrdertime.setText("");
					txtItem.setText("");
					txtAmount.setText("");
		            //txtcustomer_phone.setText("");
					txtOrdernum.requestFocus();					

				}catch(SQLException ex) {
					ex.printStackTrace();
				}
			}
		});
		btnDelete.setBounds(471, 426, 89, 23);
		frame.getContentPane().add(btnDelete);
		
		JButton btnNewButton_1 = new JButton("next");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				second s = new second();
				s.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(129, 408, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_1_5 = new JLabel("old_order number");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_5.setBounds(385, 463, 129, 26);
		frame.getContentPane().add(lblNewLabel_1_5);
		
		txtNewON = new JTextField();
		txtNewON.setColumns(10);
		txtNewON.setBounds(395, 497, 96, 20);
		frame.getContentPane().add(txtNewON);
	}
}
