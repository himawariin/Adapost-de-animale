package Boxuri;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class Box1 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Box1 frame = new Box1();
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
	public Box1() {
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
		
		JLabel lblNewLabel = new JLabel("Adapost Himawari");
		lblNewLabel.setForeground(new Color(238, 238, 238));
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 50));
		lblNewLabel.setBounds(73, 26, 444, 73);
		contentPane.add(lblNewLabel);
		
		JButton inregistrare = new JButton("Inregistrare");
		inregistrare.setForeground(new Color(238, 238, 238));
		inregistrare.setBackground(new Color(45, 35, 39));
		inregistrare.addActionListener(new ActionListener() {
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
		inregistrare.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		inregistrare.setBounds(174, 160, 209, 36);
		contentPane.add(inregistrare);
		
		JButton creareCont = new JButton("Creare cont");
		creareCont.setForeground(new Color(238, 238, 238));
		creareCont.setBackground(new Color(45, 35, 39));
		creareCont.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dispose();
					Box2 b2=new Box2();
					b2.setVisible(true);
				}catch(Exception el) {
					System.out.println(el);
				}
			}
		});
		creareCont.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		creareCont.setBounds(174, 263, 209, 36);
		contentPane.add(creareCont);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("D:\\Downloads\\pawprint (1).png"));
		lblNewLabel_2.setBounds(490, 238, 72, 63);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setIcon(new ImageIcon("D:\\Downloads\\pawprint (1).png"));
		lblNewLabel_2_1.setBounds(445, 302, 72, 74);
		contentPane.add(lblNewLabel_2_1);
		
	}
}