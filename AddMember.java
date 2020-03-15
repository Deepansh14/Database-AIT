import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.mysql.cj.xdevapi.Table;



import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import java.awt.SystemColor;
import java.awt.Color;

public class AddMember {

	private DefaultTableModel model;
	Connection con;
	
	

	public JFrame frame;
	private JTextField textField1;
	private JLabel label_1;
	private JTextField textField2;
	private JLabel label_3;
	private JTextField textField3;
	private JLabel label_4;
	private JTextField textField4;
	private JButton button5;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton btnBack;
	private JButton button;
	private JLabel label_2;
	private JButton btnLogout;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddMember window = new AddMember();
					window.frame.setVisible(true);
			
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @return 
	 * 
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws SQLException
	 */
	
	
	public AddMember() throws InstantiationException, IllegalAccessException, SQLException {
		initialize();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/storemanagement?verifyServerCertificate=false&useSSL=true";

			// Connect to DB using DB URL, Username and password
			con = DriverManager.getConnection(url, "root", "root");

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}

	}
	public TableModel fillData()
	{
		DefaultTableModel model1 = new DefaultTableModel(new String[] { "Member Id", "Name", "Email", "Contact" },0);
	//	String sql1 = "SELECT * FROM storemanagement.member";
		Statement ps;
		try {

			ps = con.createStatement();
			ResultSet rs1 = ps.executeQuery("SELECT * FROM storemanagement.member");




			while(rs1.next()) {
				String MemberId = rs1.getString(1);
				String Name = rs1.getString(2);
				String Email = rs1.getString(3);
				String Contact = rs1.getString(4);
				
				model1.addRow(new  Object [] {MemberId,Name,Email,Contact});
				}
				
				
				
				
table.setModel(model1);
		
		}catch (Exception e) {
				// TODO: handle exception
			}
		return model1;
			
			//table.setModel(model);
	
		}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(95, 158, 160));
		frame.setBounds(100, 100, 972, 860);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		ImageIcon icon = new ImageIcon("manuname.png");
		JLabel label = new JLabel(new ImageIcon(
				"C:\\Users\\Deepansh\\eclipse-workspace\\A00268737-Online Store Management Project\\src\\default package\\manuname.png"));
		label.setForeground(Color.BLACK);
		label.setText("Member Name:");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Lucida Bright", Font.BOLD | Font.ITALIC, 16));
		label.setBounds(390, 101, 219, 48);
		frame.getContentPane().add(label);

		textField1 = new JTextField();
		textField1.setBounds(619, 115, 159, 24);
		frame.getContentPane().add(textField1);

		label_1 = new JLabel();
		label_1.setForeground(Color.BLACK);
		label_1.setIcon(new ImageIcon(
				"C:\\Users\\Deepansh\\eclipse-workspace\\A00268737-Online Store Management Project\\src\\default package\\billnumber.png"));
		label_1.setText("Member ID:");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Lucida Bright", Font.BOLD | Font.ITALIC, 16));
		label_1.setBounds(53, 101, 175, 48);
		frame.getContentPane().add(label_1);

		textField2 = new JTextField();
		textField2.setBounds(264, 115, 89, 24);
		frame.getContentPane().add(textField2);

		label_3 = new JLabel();
		label_3.setForeground(Color.BLACK);
		label_3.setIcon(new ImageIcon(
				"C:\\Users\\Deepansh\\eclipse-workspace\\A00268737-Online Store Management Project\\src\\default package\\email'.png"));
		label_3.setText("Email ID:");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("Lucida Bright", Font.BOLD | Font.ITALIC, 16));
		label_3.setBounds(53, 203, 132, 40);
		frame.getContentPane().add(label_3);

		textField3 = new JTextField();
		textField3.setBounds(264, 213, 159, 24);
		frame.getContentPane().add(textField3);

		label_4 = new JLabel();
		label_4.setForeground(Color.BLACK);
		label_4.setIcon(new ImageIcon(
				"C:\\Users\\Deepansh\\eclipse-workspace\\A00268737-Online Store Management Project\\src\\default package\\mobile.png"));
		label_4.setText("Contact");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("Lucida Bright", Font.BOLD | Font.ITALIC, 16));
		label_4.setBounds(462, 200, 132, 46);
		frame.getContentPane().add(label_4);

		textField4 = new JTextField();
		textField4.setBounds(619, 213, 159, 24);
		frame.getContentPane().add(textField4);

		JButton button1 = new JButton();
		button1.setForeground(new Color(51, 0, 0));
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				PreparedStatement st;
				ResultSet rs;

				String id = textField2.getText();
				String name = textField1.getText();
				String email = textField3.getText();
				String mobile = textField4.getText();

				String sql = "Insert into storemanagement.member (member_id,name,email,contact) VALUES (?,?,?,?)";

				try {

					st = con.prepareStatement(sql);
					st.setString(1, id);
					st.setString(2, name);
					st.setString(3, email);
					st.setString(4, mobile);

					st.executeUpdate();
					st.close();
					JOptionPane.showInputDialog(this, "Member Inserted");

				} catch (Exception e1) {
					JOptionPane.showInputDialog(this, "fail to add members details");
					e1.printStackTrace();
				}finally {
					fillData();
				}

			}
		});
		button1.setText("Add");
		button1.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		button1.setBounds(35, 328, 108, 38);
		frame.getContentPane().add(button1);

		JButton button2 = new JButton();
		button2.setForeground(new Color(51, 0, 0));
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//	 st;
				//ResultSet rs;
				
				int id = Integer.parseInt(textField2.getText());
				String name = textField1.getText();
				String email = textField3.getText();
				int contact = Integer.parseInt(textField4.getText());
				
				String sql = "update storemanagement.member set name=? , email=? , contact=? where member_id = ?";

				//String sql=""
				try {
					
							
					PreparedStatement st = con.prepareStatement(sql);
					//System.out.println(st);
			
				st.setString(1,name);
				st.setString(2,email);
			st.setInt(3,contact);
			st.setInt(4,id);
					
					st.executeUpdate();
					//System.out.println(st);
					st.close();
					JOptionPane.showInputDialog(this, "Member Updated");

				} catch (Exception e1) {
					JOptionPane.showInputDialog(this, "fail to update the  members ");
					e1.printStackTrace();
				}finally {
					fillData();
				}
				
				
				
				

			}
		});
		button2.setText("Update");
		button2.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		button2.setBounds(222, 328, 108, 38);
		frame.getContentPane().add(button2);

		JButton button3 = new JButton();
		button3.setForeground(new Color(51, 0, 0));
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			
			//	ResultSet rs;

				int id = Integer.parseInt(textField2.getText());
				
			
			 try(
			 
	            CallableStatement statement = con.prepareCall("{call DeleteMember(?)}");
	        ) {
	 
	            statement.setInt(1, id);
	 
	            statement.execute();
	            statement.close();
	 
	           
					JOptionPane.showInputDialog(this, "Data deleted");

				} catch (Exception e1) {
					JOptionPane.showInputDialog(this, "fail to delete the  members ");
					e1.printStackTrace();
				}finally {
					fillData();
				}

			}
		});
		button3.setText("Delete");
		button3.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		button3.setBounds(424, 328, 103, 38);
		frame.getContentPane().add(button3);

		button5 = new JButton();
		button5.setForeground(new Color(51, 0, 0));
		button5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				textField1.setText("");
				textField2.setText("");
				textField3.setText("");
				textField4.setText("");

			}
		});
		button5.setText("Reset");
		button5.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		button5.setBounds(774, 328, 103, 38);
		frame.getContentPane().add(button5);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(75, 507, 855, 217);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		//table.setModel();
		scrollPane.setViewportView(table);
		table.setBackground(Color.yellow);
		//model = (DefaultTableModel) table.getModel();

		JButton button4 = new JButton();
		button4.setForeground(new Color(51, 0, 0));
		button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					fillData();


			}
		});
		button4.setText("Show");
		button4.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		button4.setBounds(607, 328, 103, 38);
		frame.getContentPane().add(button4);

		btnBack = new JButton();
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				MainPage mp = new MainPage();
				mp.frame.setVisible(true);
				
				

			}
		});
		btnBack.setText("Back");
		btnBack.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		btnBack.setBounds(10, 26, 89, 27);
		frame.getContentPane().add(btnBack);

		button = new JButton();
		button.setIcon(new ImageIcon("C:\\Users\\Deepansh\\eclipse-workspace\\A00268737-Online Store Management Project\\src\\default package\\printer.png"));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					int n = ExportMember.exportmember();
					if(n==1)
					{
						JOptionPane.showInputDialog(this, "Data exported to the  csv file");
					}
					else
					{
						JOptionPane.showInputDialog(this, "Error in exporting the csv file");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			
				
			}
		});
		button.setText("Export to CSV");
		button.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		button.setBounds(382, 428, 201, 40);
		frame.getContentPane().add(button);

		label_2 = new JLabel("STORE MANAGEMENT SYSTEM");
		label_2.setIcon(new ImageIcon("C:\\Users\\Deepansh\\eclipse-workspace\\A00268737-Online Store Management Project\\src\\default package\\placeorder.png"));
		label_2.setForeground(new Color(204, 51, 0));
		label_2.setFont(new Font("Tahoma", Font.BOLD, 30));
		label_2.setBackground(Color.WHITE);
		label_2.setBounds(222, 11, 520, 42);
		frame.getContentPane().add(label_2);

		btnLogout = new JButton();
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			frame.dispose();
				LoginFrame lf = new LoginFrame();
				lf.setVisible(true);
				
				
			}
		});
		btnLogout.setText("Logout");
		btnLogout.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		btnLogout.setBounds(817, 26, 113, 27);
		frame.getContentPane().add(btnLogout);
	}
}
