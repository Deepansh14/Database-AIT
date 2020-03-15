
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Base64;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import javax.swing.ImageIcon;

public class Register_Login extends JFrame {

	private JPanel contentPane;
	private JTextField uid;
	private JPasswordField pwd1;
	private JPasswordField reenterpwd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register_Login frame = new Register_Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Register_Login() {
		setTitle("Store Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 894, 620);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(95, 158, 160));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("Re Enter Password");
		lblNewLabel_2.setBounds(224, 305, 168, 23);
		lblNewLabel_2.setFont(new Font("Arial Black", Font.BOLD, 16));
		contentPane.add(lblNewLabel_2);

		uid = new JTextField();
		uid.setBounds(461, 159, 150, 29);
		uid.setFont(new Font("Times New Roman", Font.BOLD, 14));
		uid.setColumns(10);
		contentPane.add(uid);

		pwd1 = new JPasswordField();
		pwd1.setBounds(463, 240, 148, 29);
		pwd1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		contentPane.add(pwd1);

		reenterpwd = new JPasswordField();
		reenterpwd.setBounds(463, 304, 148, 29);
		reenterpwd.setFont(new Font("Times New Roman", Font.BOLD, 14));
		contentPane.add(reenterpwd);

		JButton btnBack = new JButton("Back");
		btnBack.setForeground(Color.RED);
		btnBack.setBounds(226, 444, 148, 37);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginFrame l = new LoginFrame();
				setVisible(false);
				l.setVisible(true);
			}
		});
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 16));
		contentPane.add(btnBack);

		JButton button_1 = new JButton("Register");
		button_1.setForeground(Color.RED);
		button_1.setBounds(463, 444, 148, 37);

		button_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		contentPane.add(button_1);

		JLabel lblType = new JLabel("Type: ");
		lblType.setIcon(new ImageIcon(
				"C:\\Users\\Deepansh\\eclipse-workspace\\A00268737-Online Store Management Project\\src\\default package\\membericon.png"));
		lblType.setBounds(224, 363, 183, 43);
		lblType.setFont(new Font("Arial Black", Font.BOLD, 16));
		contentPane.add(lblType);

		JComboBox combo_type = new JComboBox();
		combo_type.setFont(new Font("Arial Black", Font.BOLD, 15));
		combo_type.setBounds(463, 371, 148, 29);
		combo_type.setModel(new DefaultComboBoxModel(new String[] { "Admin" }));
		contentPane.add(combo_type);

		JLabel label = new JLabel("STORE MANAGEMENT SYSTEM");
		label.setIcon(new ImageIcon(
				"C:\\Users\\Deepansh\\eclipse-workspace\\A00268737-Online Store Management Project\\src\\default package\\placeorder.png"));
		label.setForeground(new Color(204, 51, 0));
		label.setFont(new Font("Tahoma", Font.BOLD, 30));
		label.setBackground(Color.WHITE);
		label.setBounds(175, 11, 524, 42);
		contentPane.add(label);

		JLabel label_1 = new JLabel("USERNAME");
		label_1.setIcon(new ImageIcon(
				"C:\\Users\\Deepansh\\eclipse-workspace\\A00268737-Online Store Management Project\\src\\default package\\login.png"));
		label_1.setFont(new Font("Arial Black", Font.BOLD, 16));
		label_1.setBackground(Color.RED);
		label_1.setBounds(159, 137, 238, 69);
		contentPane.add(label_1);

		JLabel label_2 = new JLabel("PASSWORD");
		label_2.setIcon(new ImageIcon(
				"C:\\Users\\Deepansh\\eclipse-workspace\\A00268737-Online Store Management Project\\src\\default package\\billnumber.png"));
		label_2.setFont(new Font("Arial Black", Font.BOLD, 16));
		label_2.setBackground(Color.RED);
		label_2.setBounds(224, 234, 163, 37);
		contentPane.add(label_2);
		
		JButton button = new JButton();
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					int n = ExportRegisterUser.exportuser();
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
		button.setIcon(new ImageIcon("C:\\Users\\Deepansh\\eclipse-workspace\\A00268737-Online Store Management Project\\src\\default package\\printer.png"));
		button.setText("Export to CSV");
		button.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		button.setBounds(667, 441, 183, 40);
		contentPane.add(button);
		
		JButton button_3 = new JButton("EXIT");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		button_3.setIcon(new ImageIcon("C:\\Users\\Deepansh\\eclipse-workspace\\A00268737-Online Store Management Project\\src\\default package\\cancel.png"));
		button_3.setForeground(new Color(255, 102, 0));
		button_3.setFont(new Font("Arial Black", Font.BOLD, 18));
		button_3.setBackground(new Color(144, 238, 144));
		button_3.setBounds(23, 439, 145, 42);
		contentPane.add(button_3);

		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = uid.getText();

				String password = new String(pwd1.getPassword());
				String password1 = new String(reenterpwd.getPassword());
				int c = combo_type.getSelectedIndex();
				if (password1.equals(password)) {

					try {

						RegisterConnection.Register_user(username, password, c);
						setVisible(false);
						JOptionPane.showInputDialog(this, "Registered");

						LoginFrame lf = new LoginFrame();
						lf.setVisible(true);

					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				} else {
					JOptionPane.showInputDialog(this, "Passwords don't match ");
				}

				;
			}
		});
	}
}
