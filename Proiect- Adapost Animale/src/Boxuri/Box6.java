// adminul poate sa : introduca un animal in baza de date
// sa schimbe starea unui animal, adoptat neadoptat




package Boxuri;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;

import javax.swing.JLabel;

public class Box6 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Box6 frame = new Box6();
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
	public Box6() {
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
		
		JButton adaugare = new JButton("Inregistrare animal");
		adaugare.setForeground(new Color(238, 238, 238));
		adaugare.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		adaugare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dispose();
					Box7 b7=new Box7();
					b7.setVisible(true);
				}catch(Exception el) {
					System.out.println(el);
				}
			}
		});
		adaugare.setBackground(new Color(45, 35, 39));
		adaugare.setBounds(161, 127, 258, 36);
		contentPane.add(adaugare);
		
		JButton eliminare = new JButton("Eliminare animal");
		eliminare.setForeground(new Color(238, 238, 238));
		eliminare.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		eliminare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					try {  
				        Class.forName("com.mysql.jdbc.Driver");
				        Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/p3","root","");
				        PreparedStatement st = (PreparedStatement) connection.prepareStatement("DELETE FROM Animale WHERE Id_animal = ?");
				        st.setInt(1,3);
				        st.executeUpdate(); 
				    } catch(Exception el) {
				        System.out.println(el);
				    }
					dispose();
					Box8 b8=new Box8();
					b8.setVisible(true);
				}catch(Exception el) {
					System.out.println(el);
				}
			}
		});
		eliminare.setBackground(new Color(45, 35, 39));
		eliminare.setBounds(161, 213, 258, 36);
		contentPane.add(eliminare);
		
		JLabel lblAdmin = new JLabel("Admin");
		lblAdmin.setForeground(new Color(238, 238, 238));
		lblAdmin.setFont(new Font("Segoe UI", Font.BOLD, 50));
		lblAdmin.setBounds(189, 31, 230, 73);
		contentPane.add(lblAdmin);
		
		JButton cancel = new JButton("Inapoi");
		cancel.setForeground(new Color(238, 238, 238));
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dispose();
					Box5 b5=new Box5();
					b5.setVisible(true);
					
				}catch(Exception el) {
					System.out.println(el);
				}
			}
		});
		cancel.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		cancel.setBackground(new Color(45, 35, 39));
		cancel.setBounds(213, 291, 168, 36);
		contentPane.add(cancel);
		
		
	}
}
