
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txt_uname;
	private JPasswordField txt_pwd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					LoginFrame frame = new LoginFrame();
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
	public LoginFrame() {
		setTitle("Store Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 830, 518);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(95, 158, 160));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txt_uname = new JTextField();
		txt_uname.setBounds(403, 151, 197, 25);
		txt_uname.setColumns(10);
		contentPane.add(txt_uname);

		JLabel label = new JLabel("USERNAME");
		label.setIcon(new ImageIcon(
				"C:\\Users\\Deepansh\\eclipse-workspace\\A00268737-Online Store Management Project\\src\\default package\\login.png"));
		label.setBounds(108, 119, 265, 83);
		label.setFont(new Font("Arial Black", Font.BOLD, 16));
		label.setBackground(Color.ORANGE);
		contentPane.add(label);

		JLabel label_1 = new JLabel("PASSWORD");
		label_1.setIcon(new ImageIcon(
				"C:\\Users\\Deepansh\\eclipse-workspace\\A00268737-Online Store Management Project\\src\\default package\\billnumber.png"));
		label_1.setBounds(174, 233, 219, 37);
		label_1.setFont(new Font("Arial Black", Font.BOLD, 16));
		label_1.setBackground(Color.ORANGE);
		contentPane.add(label_1);

		JButton btn_login = new JButton("LOGIN");
		btn_login.setBounds(194, 323, 179, 37);
		btn_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String uname = txt_uname.getText();
					String password = new String(txt_pwd.getPassword());
					int num = LoginConnection.Login(uname, password);

					if (num == 0) {
						JOptionPane.showInputDialog(this, "Admin Login");
						MainPage mp = new MainPage();
						mp.frame.setVisible(true);

						setVisible(false);
					}

					else {
						JOptionPane.showInputDialog(this, "Error");
					}
				} catch (NoSuchAlgorithmException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btn_login.setForeground(Color.RED);
		btn_login.setFont(new Font("Arial Black", Font.BOLD, 16));
		btn_login.setBackground(Color.LIGHT_GRAY);
		contentPane.add(btn_login);

		JButton btn_hint = new JButton("REGISTER");
		btn_hint.setBackground(Color.LIGHT_GRAY);
		btn_hint.setBounds(431, 323, 169, 37);
		btn_hint.setFont(new Font("Arial Black", Font.BOLD, 16));
		btn_hint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Register_Login r = new Register_Login();
				setVisible(false);
				r.setVisible(true);
			}
		});
		btn_hint.setForeground(Color.RED);
		contentPane.add(btn_hint);

		txt_pwd = new JPasswordField();
		txt_pwd.setBounds(403, 242, 197, 25);
		contentPane.add(txt_pwd);
		
		JButton button = new JButton("EXIT");
		button.setIcon(new ImageIcon("C:\\Users\\Deepansh\\eclipse-workspace\\A00268737-Online Store Management Project\\src\\default package\\cancel.png"));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		button.setForeground(new Color(255, 102, 0));
		button.setFont(new Font("Arial Black", Font.BOLD, 18));
		button.setBackground(new Color(144, 238, 144));
		button.setBounds(605, 410, 149, 42);
		contentPane.add(button);
		
		JLabel label_3 = new JLabel("WELCOME TO STORE MANAGEMENT SYSTEM");
		label_3.setIcon(new ImageIcon("C:\\Users\\Deepansh\\eclipse-workspace\\A00268737-Online Store Management Project\\src\\default package\\placeorder.png"));
		label_3.setForeground(Color.GREEN);
		label_3.setFont(new Font("Tahoma", Font.BOLD, 30));
		label_3.setBackground(Color.RED);
		label_3.setBounds(62, 11, 722, 42);
		contentPane.add(label_3);
	}
}