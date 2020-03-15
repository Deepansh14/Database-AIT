import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class MainPage {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage window = new MainPage();
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
	public MainPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(95, 158, 160));
		frame.setBounds(100, 100, 859, 526);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnMembers = new JButton("Add Members");
		btnMembers.setIcon(new ImageIcon(
				"C:\\Users\\Deepansh\\eclipse-workspace\\A00268737-Online Store Management Project\\src\\default package\\member.png"));
		btnMembers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddMember m;
				try {
					frame.dispose();
					m = new AddMember();
					m.frame.setVisible(true);
					m.fillData();
				} catch (InstantiationException | IllegalAccessException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnMembers.setForeground(new Color(51, 0, 0));
		btnMembers.setFont(new Font("Arial Black", Font.BOLD, 20));
		btnMembers.setBackground(Color.LIGHT_GRAY);
		btnMembers.setBounds(150, 208, 255, 60);
		frame.getContentPane().add(btnMembers);

		JButton btnProduct = new JButton("Add Products");
		btnProduct.setIcon(new ImageIcon(
				"C:\\Users\\Deepansh\\eclipse-workspace\\A00268737-Online Store Management Project\\src\\default package\\medicine.png"));
		btnProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				AddProduct p;
				try {
					p = new AddProduct();
					p.frame.setVisible(true);
					p.fillData();
				} catch (InstantiationException | IllegalAccessException | SQLException e1) {

					e1.printStackTrace();
				}

			}
		});
		btnProduct.setForeground(new Color(51, 0, 0));
		btnProduct.setFont(new Font("Arial Black", Font.BOLD, 20));
		btnProduct.setBackground(Color.LIGHT_GRAY);
		btnProduct.setBounds(520, 208, 233, 60);
		frame.getContentPane().add(btnProduct);

		JButton btnExit = new JButton("EXIT");
		btnExit.setIcon(new ImageIcon(
				"C:\\Users\\Deepansh\\eclipse-workspace\\A00268737-Online Store Management Project\\src\\default package\\cancel.png"));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				System.exit(0);

			}
		});
		btnExit.setForeground(new Color(255, 102, 0));
		btnExit.setFont(new Font("Arial Black", Font.BOLD, 18));
		btnExit.setBackground(new Color(144, 238, 144));
		btnExit.setBounds(364, 344, 167, 42);
		frame.getContentPane().add(btnExit);
		
		JLabel label = new JLabel("STORE MANAGEMENT SYSTEM");
		label.setIcon(new ImageIcon("C:\\Users\\Deepansh\\eclipse-workspace\\A00268737-Online Store Management Project\\src\\default package\\placeorder.png"));
		label.setForeground(new Color(204, 51, 0));
		label.setFont(new Font("Tahoma", Font.BOLD, 30));
		label.setBackground(Color.WHITE);
		label.setBounds(208, 11, 516, 42);
		frame.getContentPane().add(label);
	}
}
