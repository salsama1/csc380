import java.awt.EventQueue;

import javax.swing.JFrame;


	import java.sql.*;


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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

	public class the{

		private JFrame frame;
		private JTextField txtOrdernum;
		private JTextField txtOrdertime;
		private JTextField txtItem;
		private JTextField txtAmount;
		private JComboBox comboPhone;
		private JComboBox cmbEmployeessn;
		private JComboBox cmbOrdernum;
		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						the the = new the();
						the.frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}

		/**
		 * Create the application.
		 */
		public the() {
			initialize();
			connect();
			table_load();
			load_data();
			table_prepare_load();
			table_order_load();
		}

		 Connection con;
		 PreparedStatement pst;
		 ResultSet rs;
		 private JTextField txtNewON;
		 private JTextField txtPhone;
		 private JTextField txtName;
		 private JTextField txtAge;
		 private JTextField txtSex;
		 private JTable tbOrder;
		 private JTable tblPrepare;
		 private JTable tableOnum;


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
				tbOrder.setModel(DbUtils.resultSetToTableModel(rs));
			}


			catch(SQLException ex) {

			}
			}
		
		public void table_order_load() {
			try {
				String id= txtPhone.getText();

				pst = con.prepareStatement("SELECT Ordernum FROM coffe_manage_new.order WHERE customer_customer_phone =?");
				pst.setString(1, id);


				rs = pst.executeQuery();
				tableOnum.setModel(DbUtils.resultSetToTableModel(rs));
			}


			catch(SQLException ex) {

			}
			}
		
		public void table_prepare_load() {
			try {
				pst = con.prepareStatement("SELECT * FROM `coffe_manage_new`.`prepare`");

				rs = pst.executeQuery();
				tblPrepare.setModel(DbUtils.resultSetToTableModel(rs));

			}

			catch(SQLException ex) {

			}
		}

		public void load_data() {
			String tmp = null;
			try {
	            String sql="SELECT * FROM coffe_manage_new.customer";
	            pst=con.prepareStatement(sql);
	            rs = pst.executeQuery(sql);
	            while(rs.next()){
	               comboPhone.addItem(rs.getString("customer_phone"));
	               tmp = (String) comboPhone.getSelectedItem();

	            }
	            String sqlEmployee="SELECT * FROM coffe_manage_new.empolyee";
	            pst=con.prepareStatement(sqlEmployee);
	            rs = pst.executeQuery(sqlEmployee);
	            while(rs.next()){
	            	cmbEmployeessn.addItem(rs.getString("ssn"));
	               tmp = (String) cmbEmployeessn.getSelectedItem();

	            }
	            String sqlOrder="SELECT * FROM coffe_manage_new.order";
	            pst=con.prepareStatement(sqlOrder);
	            rs = pst.executeQuery(sqlOrder);
	            while(rs.next()){
	            	cmbOrdernum.addItem(rs.getString("Ordernum"));
	               tmp = (String) cmbOrdernum.getSelectedItem();  
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
			frame.setBounds(100, 100, 1489, 798);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);

			JLabel lblNewLabel = new JLabel("coffee Shop");
			lblNewLabel.setFont(new Font("Arial", Font.BOLD, 30));
			lblNewLabel.setBounds(10, -14, 194, 99);
			frame.getContentPane().add(lblNewLabel);

			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "add a new order", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(10, 59, 338, 293);
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
			comboPhone.setBounds(156, 238, 96, 20);
			panel.add(comboPhone);
			JPanel panel_4 = new JPanel();
			panel_4.setBorder(new TitledBorder(null, "prepare order", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_4.setBounds(10, 417, 312, 283);
			frame.getContentPane().add(panel_4);
			panel_4.setLayout(null);



			JLabel lblNewLabel_3 = new JLabel("employee");
			lblNewLabel_3.setBounds(39, 51, 79, 14);
			panel_4.add(lblNewLabel_3);

			JLabel lblNewLabel_3_1 = new JLabel("order");
			lblNewLabel_3_1.setBounds(39, 119, 79, 14);
			panel_4.add(lblNewLabel_3_1);

			JButton btnNewButton_2 = new JButton("add");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String Ordernum,ssn ;

					Ordernum = cmbOrdernum.getSelectedItem().toString();
					ssn =cmbEmployeessn.getSelectedItem().toString();

					try {
						pst = con.prepareStatement("INSERT INTO `coffe_manage_new`.`prepare`(`order_Ordernum`,`empolyee_ssn`)VALUES(?,?) ");

						Ordernum = cmbOrdernum.getSelectedItem().toString();
						ssn =cmbEmployeessn.getSelectedItem().toString();

						pst.setString(1,Ordernum);
						pst.setString(2, ssn);
						pst.executeUpdate();
						JOptionPane.showMessageDialog(null, "added sucssefly");
						table_prepare_load();
						/*txtOrdernum.setText("");
						txtOrdertime.setText("");
						txtItem.setText("");
						txtAmount.setText("");
			            //txtcustomer_phone.setText("");
						txtOrdernum.requestFocus();	*/				

					}catch(SQLException ex) {
						ex.printStackTrace();
					}

				}


			});
			btnNewButton_2.setBounds(103, 213, 89, 23);
			panel_4.add(btnNewButton_2);

			cmbEmployeessn = new JComboBox();
			cmbEmployeessn.setBounds(121, 47, 110, 22);
			panel_4.add(cmbEmployeessn);

			cmbOrdernum = new JComboBox();
			cmbOrdernum.setBounds(121, 115, 110, 22);
			panel_4.add(cmbOrdernum);

			JButton btnNewButton = new JButton("add");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					String Ordernum, Ordertime, Item, amount ;

					Ordernum = txtOrdernum.getText();
					Ordertime = txtOrdertime.getText();
					Item = txtItem.getText();
					amount = txtAmount.getText();

					try {
						pst = con.prepareStatement("INSERT INTO `coffe_manage_new`.`order`(`Ordernum`,`Ordertime`,`Item`,`amount`,`customer_customer_phone`)VALUES(?,?,?,?,?)");
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
			btnNewButton.setBounds(20, 363, 89, 23);
			frame.getContentPane().add(btnNewButton);

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
						pst = con.prepareStatement("UPDATE `coffe_manage_new`.`order` SET `Ordernum` = ?, `Ordertime` = ?, `Item` = ?, `amount` = ?, `customer_customer_phone` = ? WHERE `Ordernum` = ?");
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
			btnUpdate.setBounds(119, 363, 89, 23);
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
			btnDelete.setBounds(218, 363, 89, 23);
			frame.getContentPane().add(btnDelete);

			JLabel lblNewLabel_1_5 = new JLabel("old_order number");
			lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblNewLabel_1_5.setBounds(343, 359, 129, 26);
			frame.getContentPane().add(lblNewLabel_1_5);

			txtNewON = new JTextField();
			txtNewON.setColumns(10);
			txtNewON.setBounds(482, 364, 96, 20);
			frame.getContentPane().add(txtNewON);

			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new TitledBorder(null, "Search", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_1.setBounds(656, 347, 281, 59);
			frame.getContentPane().add(panel_1);
			panel_1.setLayout(null);

			JLabel lblNewLabel_1_1_1 = new JLabel("customer phone");
			lblNewLabel_1_1_1.setBounds(30, 20, 117, 19);
			lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
			panel_1.add(lblNewLabel_1_1_1);

			txtPhone = new JTextField();
			txtPhone.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					try {
						String id= txtPhone.getText();

						pst =con.prepareStatement("SELECT name,age,sex FROM coffe_manage_new.customer WHERE customer_phone =?");
						pst.setString(1, id);
						ResultSet rs =pst.executeQuery();

						if(rs.next()==true)
						{

							String name=rs.getString(1);
							String age=rs.getString(2);
							String sex=rs.getString(3);


							txtName.setText(name);
							txtAge.setText(age);
							txtSex.setText(sex);
							table_order_load();


						}
						else {
							txtName.setText("");
							txtAge.setText("");
							txtSex.setText("");


						}
					}catch(SQLException ex) {
						ex.printStackTrace();
					}

				}
			});
			txtPhone.setBounds(157, 21, 86, 20);
			txtPhone.setColumns(10);
			panel_1.add(txtPhone);

			JPanel panel_2 = new JPanel();
			panel_2.setBorder(new TitledBorder(null, "customer information", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_2.setBounds(641, 417, 290, 283);
			frame.getContentPane().add(panel_2);
			panel_2.setLayout(null);

			txtName = new JTextField();
			txtName.setBounds(118, 49, 86, 20);
			panel_2.add(txtName);
			txtName.setColumns(10);

			txtAge = new JTextField();
			txtAge.setBounds(118, 124, 86, 20);
			panel_2.add(txtAge);
			txtAge.setColumns(10);

			txtSex = new JTextField();
			txtSex.setColumns(10);
			txtSex.setBounds(118, 196, 86, 20);
			panel_2.add(txtSex);

			JLabel lblNewLabel_2 = new JLabel("Name");
			lblNewLabel_2.setBounds(24, 52, 46, 14);
			panel_2.add(lblNewLabel_2);

			JLabel lblNewLabel_2_1 = new JLabel("age");
			lblNewLabel_2_1.setBounds(24, 127, 46, 14);
			panel_2.add(lblNewLabel_2_1);

			JLabel lblNewLabel_2_2 = new JLabel("sex");
			lblNewLabel_2_2.setBounds(24, 199, 46, 14);
			panel_2.add(lblNewLabel_2_2);

			JPanel panel_3 = new JPanel();
			panel_3.setBorder(new TitledBorder(null, "Order details", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_3.setBounds(368, 59, 290, 297);
			frame.getContentPane().add(panel_3);
			panel_3.setLayout(null);

			tbOrder = new JTable();
			tbOrder.setBounds(10, 11, 270, 275);
			panel_3.add(tbOrder);

			JPanel panel_5 = new JPanel();
			panel_5.setBorder(new TitledBorder(null, "prepare details", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_5.setBounds(332, 417, 281, 283);
			frame.getContentPane().add(panel_5);
			panel_5.setLayout(null);
			
						tblPrepare = new JTable();
						tblPrepare.setBounds(10, 22, 261, 261);
						panel_5.add(tblPrepare);
						
						JPanel panel_6 = new JPanel();
						panel_6.setLayout(null);
						panel_6.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Order Number", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
						panel_6.setBounds(941, 417, 281, 283);
						frame.getContentPane().add(panel_6);
						
						tableOnum = new JTable();
						tableOnum.setBounds(10, 22, 261, 261);
						panel_6.add(tableOnum);

		}
	}