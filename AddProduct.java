import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.ImageIcon;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class AddProduct {

	private DefaultTableModel model;
	Connection con;

	public JFrame frame;
	private JTextField textField1;
	private JTextField textField2;
	private JLabel lblQuantity;
	private JLabel lblPrice;
	private JTextField textField4;
	private JTable table;
	private JTextField textField3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddProduct window = new AddProduct();
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
	public AddProduct() throws InstantiationException, IllegalAccessException, SQLException {
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

	public TableModel fillData() {
		DefaultTableModel model1 = new DefaultTableModel(
				new String[] { "Product Id", "Product Name", "Product Quantity", "Product Price" }, 0);
		// String sql1 = "SELECT * FROM storemanagement.member";
		Statement ps;
		try {

			ps = con.createStatement();
			ResultSet rs1 = ps.executeQuery("SELECT * FROM storemanagement.product");

			while (rs1.next()) {
				String ProductId = rs1.getString(1);
				String ProductName = rs1.getString(2);
				String ProductQuantity = rs1.getString(3);
				String ProductPrice = rs1.getString(4);

				model1.addRow(new Object[] { ProductId, ProductName, ProductQuantity, ProductPrice });
			}

		
			table.setModel(model1);

		} catch (Exception e) {
			// TODO: handle exception
		}
		return model1;

		// table.setModel(model);

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Store Management System");
		frame.getContentPane().setBackground(new Color(95, 158, 160));
		frame.setBounds(100, 100, 908, 860);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		textField1 = new JTextField();
		textField1.setBounds(202, 122, 89, 24);
		frame.getContentPane().add(textField1);

		JLabel lblProductId = new JLabel();
		lblProductId.setForeground(Color.BLACK);
		lblProductId.setIcon(new ImageIcon(
				"C:\\Users\\Deepansh\\eclipse-workspace\\A00268737-Online Store Management Project\\src\\default package\\billnumber.png"));
		lblProductId.setText("Product ID");
		lblProductId.setHorizontalAlignment(SwingConstants.CENTER);
		lblProductId.setFont(new Font("Lucida Bright", Font.BOLD | Font.ITALIC, 16));
		lblProductId.setBounds(42, 108, 175, 48);
		frame.getContentPane().add(lblProductId);

		JLabel lblProductName = new JLabel(new ImageIcon(
				"C:\\Users\\Deepansh\\eclipse-workspace\\A00268737-Online Store Management Project\\src\\default package\\medicine.png"));
		lblProductName.setForeground(Color.BLACK);
		lblProductName.setText("Product Name");
		lblProductName.setHorizontalAlignment(SwingConstants.CENTER);
		lblProductName.setFont(new Font("Lucida Bright", Font.BOLD | Font.ITALIC, 16));
		lblProductName.setBounds(393, 108, 219, 48);
		frame.getContentPane().add(lblProductName);

		textField2 = new JTextField();
		textField2.setBounds(603, 122, 159, 24);
		frame.getContentPane().add(textField2);

		lblQuantity = new JLabel();
		lblQuantity.setForeground(Color.BLACK);
		lblQuantity.setIcon(new ImageIcon(
				"C:\\Users\\Deepansh\\eclipse-workspace\\A00268737-Online Store Management Project\\src\\default package\\quantity.png"));
		lblQuantity.setText("Quantity");
		lblQuantity.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuantity.setFont(new Font("Lucida Bright", Font.BOLD | Font.ITALIC, 16));
		lblQuantity.setBounds(57, 233, 132, 40);
		frame.getContentPane().add(lblQuantity);

		lblPrice = new JLabel();
		lblPrice.setForeground(Color.BLACK);
		lblPrice.setIcon(new ImageIcon(
				"C:\\Users\\Deepansh\\eclipse-workspace\\A00268737-Online Store Management Project\\src\\default package\\currency-icon.png"));
		lblPrice.setText("Price");
		lblPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrice.setFont(new Font("Lucida Bright", Font.BOLD | Font.ITALIC, 16));
		lblPrice.setBounds(447, 230, 132, 46);
		frame.getContentPane().add(lblPrice);

		textField4 = new JTextField();
		textField4.setBounds(603, 245, 159, 24);
		frame.getContentPane().add(textField4);

		JButton button1 = new JButton();
		button1.setForeground(new Color(51, 0, 0));
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				PreparedStatement st;
				ResultSet rs;

				String pid = textField1.getText();
				String pname = textField2.getText();
				String quantity = textField3.getText();
				String price = textField4.getText();

				String sql = "Insert into storemanagement.product (product_id,product_name,product_quantity,product_price) VALUES (?,?,?,?)";

				try {

					st = con.prepareStatement(sql);
					st.setString(1, pid);
					st.setString(2, pname);
					st.setString(3, quantity);
					st.setString(4, price);

					st.executeUpdate();
					st.close();
					JOptionPane.showInputDialog(this, "product Inserted");

				} catch (Exception e1) {
					JOptionPane.showInputDialog(this, "fail to add product details");
					e1.printStackTrace();
				} finally {
					fillData();
				}

			}
		});
		button1.setText("Add");
		button1.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		button1.setBounds(53, 348, 108, 38);
		frame.getContentPane().add(button1);

		JButton button2 = new JButton();
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int id = Integer.parseInt(textField1.getText());
				String name = textField2.getText();
				String quantity = textField3.getText();
				int price = Integer.parseInt(textField4.getText());

				String sql = "update storemanagement.product set product_name=? , product_quantity=? , product_price=? where product_id = ?";

				try {

					PreparedStatement st = con.prepareStatement(sql);
					// System.out.println(st);

					st.setString(1, name);
					st.setString(2, quantity);
					st.setInt(3, price);
					st.setInt(4, id);

					st.executeUpdate();
					// System.out.println(st);
					st.close();
					JOptionPane.showInputDialog(this, "Data Updated");

				} catch (Exception e1) {
					JOptionPane.showInputDialog(this, "fail to update the  product details ");
					e1.printStackTrace();
				} finally {
					fillData();
				}

			}
		});
		button2.setForeground(new Color(51, 0, 0));
		button2.setText("Update");
		button2.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		button2.setBounds(250, 348, 108, 38);
		frame.getContentPane().add(button2);

		JButton button3 = new JButton();
		button3.setForeground(new Color(51, 0, 0));
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int id = Integer.parseInt(textField1.getText());

				try (

						CallableStatement statement = con.prepareCall("{call DeleteProduct(?)}");) {

					statement.setInt(1, id);

					statement.execute();
					statement.close();

					JOptionPane.showInputDialog(this, "Product deleted");

				} catch (Exception e1) {
					JOptionPane.showInputDialog(this, "fail to delete the  product ");
					e1.printStackTrace();
				} finally {
					fillData();
				}

//				int id = Integer.parseInt(textField1.getText());
//
////				Statement st = null;
////				ResultSet rs;
//				try (
//
//						CallableStatement statement = con.prepareCall("{call DeleteProduct(?)}");) {
//
//					statement.setInt(1, id);
//
//					statement.execute();
//					statement.close();
//
//					JOptionPane.showInputDialog(this, "Product deleted");
//
//				} catch (Exception e1) {
//					JOptionPane.showInputDialog(this, "fail to delete the  product ");
//					e1.printStackTrace();
//				} finally {
//					fillData();
//				}

			}
		});
		button3.setText("Delete");
		button3.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		button3.setBounds(422, 348, 103, 38);
		frame.getContentPane().add(button3);

		JButton button4 = new JButton();
		button4.setForeground(new Color(51, 0, 0));
		button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				fillData();
//				String sql1 = " SELECT * FROM storemanagement.product";
//				PreparedStatement ps;
//				try {
//
//					ps = con.prepareStatement(sql1);
//					ResultSet rs1 = ps.executeQuery();
//
//					String Product_Id = "";
//					String Product_Name = "";
//					String Product_Quantity = "";
//					String Product_Price = "";
//
//					Product_Id = rs1.getString("product_id");
//					Product_Name = rs1.getString("product_name");
//					Product_Quantity = rs1.getString("product_quantity");
//					Product_Price = rs1.getString("product_price");
//
//					model.addRow(new Object[] { Product_Id, Product_Name, Product_Quantity, Product_Price });
//
//				} catch (SQLException e1) {
//
//					e1.printStackTrace();
//				}

			}
		});
		button4.setText("Show");
		button4.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		button4.setBounds(575, 348, 103, 38);
		frame.getContentPane().add(button4);

		JButton button5 = new JButton();
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
		button5.setBounds(723, 348, 103, 38);
		frame.getContentPane().add(button5);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(57, 520, 825, 218);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setBackground(Color.yellow);

		textField3 = new JTextField();
		textField3.setBounds(199, 245, 159, 24);
		frame.getContentPane().add(textField3);

		JButton button = new JButton();
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				MainPage mp = new MainPage();

				mp.frame.setVisible(true);
			}
		});
		button.setText("Back");
		button.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		button.setBounds(10, 26, 89, 24);
		frame.getContentPane().add(button);

		JButton btnExportTableTo = new JButton();
		btnExportTableTo.setIcon(new ImageIcon(
				"C:\\Users\\Deepansh\\eclipse-workspace\\A00268737-Online Store Management Project\\src\\default package\\printer.png"));
		btnExportTableTo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					int n = ExportProducts.exportproduct();
					if (n == 1) {
						JOptionPane.showInputDialog(this, "Data exported to the  csv file");
					} else {
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
		btnExportTableTo.setText("Export  Table to CSV");
		btnExportTableTo.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		btnExportTableTo.setBounds(603, 451, 240, 40);
		frame.getContentPane().add(btnExportTableTo);

		JLabel lblStoreManagementSystem = new JLabel("STORE MANAGEMENT SYSTEM");
		lblStoreManagementSystem.setIcon(new ImageIcon(
				"C:\\Users\\Deepansh\\eclipse-workspace\\A00268737-Online Store Management Project\\src\\default package\\placeorder.png"));
		lblStoreManagementSystem.setForeground(new Color(204, 51, 0));
		lblStoreManagementSystem.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblStoreManagementSystem.setBackground(Color.WHITE);
		lblStoreManagementSystem.setBounds(202, 11, 516, 42);
		frame.getContentPane().add(lblStoreManagementSystem);

		JButton button_2 = new JButton();
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				LoginFrame lf = new LoginFrame();
				lf.setVisible(true);
			}
		});
		button_2.setText("Logout");
		button_2.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		button_2.setBounds(765, 25, 117, 27);
		frame.getContentPane().add(button_2);
		
		JButton btnExportSumCsv = new JButton();
		btnExportSumCsv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int n = ExportTotalProduct.exportTotal();
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
		btnExportSumCsv.setIcon(new ImageIcon("C:\\Users\\Deepansh\\eclipse-workspace\\A00268737-Online Store Management Project\\src\\default package\\printer.png"));
		btnExportSumCsv.setText("Export Total Product Price to CSV");
		btnExportSumCsv.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		btnExportSumCsv.setBounds(126, 451, 343, 40);
		frame.getContentPane().add(btnExportSumCsv);
	}
}
