package Boxuri;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;

public class Box5 extends JFrame {

		private JPanel contentPane;

		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Box5 frame = new Box5();
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
		public Box5() {
			setAlwaysOnTop(true);
			setBackground(new Color(0, 70, 67));
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setSize(576, 424);
			setLocationRelativeTo(null);
			contentPane = new JPanel();
			contentPane.setBackground(new Color(0, 70, 67));
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPane.setLayout(null);
			setContentPane(contentPane);

			
			JLabel lblNewLabel = new JLabel("Inregistrare");
			lblNewLabel.setForeground(new Color(238, 238, 238));
			lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 50));
			lblNewLabel.setBounds(139, 27, 284, 73);
			contentPane.add(lblNewLabel);
			
			JButton contAdmin = new JButton("Cont Admin");
			contAdmin.setForeground(new Color(238, 238, 238));
			contAdmin.setBackground(new Color(45, 35, 39));
			contAdmin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						dispose();
						Box4 b4=new Box4();
						b4.setVisible(true);
					}catch(Exception el) {
						System.out.println(el);
					}
				}
			});
			contAdmin.setFont(new Font("Segoe UI", Font.PLAIN, 20));
			contAdmin.setBounds(174, 160, 209, 36);
			contentPane.add(contAdmin);
			
			JButton contUser = new JButton("Cont user");
			contUser.setForeground(new Color(238, 238, 238));
			contUser.setBackground(new Color(45, 35, 39));
			contUser.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						dispose();
						Box3 b3=new Box3();
						b3.setVisible(true);
					}catch(Exception el) {
						System.out.println(el);
					}
				}
			});
			contUser.setFont(new Font("Segoe UI", Font.PLAIN, 20));
			contUser.setBounds(174, 222, 209, 36);
			contentPane.add(contUser);
			
			JButton btnCancel = new JButton("Cancel");
			btnCancel.setForeground(new Color(238, 238, 238));
			btnCancel.setBackground(new Color(45, 35, 39));
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						dispose();
						Box1 b1=new Box1();
						b1.setVisible(true);
					}catch(Exception el) {
						System.out.println(el);
					}
				}
			});
			btnCancel.setFont(new Font("Segoe UI", Font.PLAIN, 20));
			btnCancel.setBounds(174, 288, 209, 36);
			contentPane.add(btnCancel);
			
			
			
		}
	}