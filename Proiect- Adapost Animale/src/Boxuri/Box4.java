package Boxuri;

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
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Box4 extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JTextField parola;
	public static String usernamee;
	public static String nume1;
	public static String prenume1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Box4 frame = new Box4();
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
	public Box4() {
		setBackground(new Color(0, 70, 67));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(523, 462);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 70, 67));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Inregistrare admin");
		lblNewLabel.setForeground(new Color(238, 238, 238));
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 50));
		lblNewLabel.setBounds(53, 28, 428, 67);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Admin name");
		lblNewLabel_1.setForeground(new Color(238, 238, 238));
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(149, 137, 202, 30);
		contentPane.add(lblNewLabel_1);
		
		username = new JTextField();
		username.setBackground(new Color(255, 255, 255));
		username.setBounds(149, 178, 242, 30);
		contentPane.add(username);
		username.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Parola");
		lblNewLabel_1_1.setForeground(new Color(238, 238, 238));
		lblNewLabel_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(149, 219, 202, 30);
		contentPane.add(lblNewLabel_1_1);
		
		parola = new JTextField();
		parola.setColumns(10);
		parola.setBounds(149, 257, 242, 30);
		contentPane.add(parola);
		
		JButton inregistrare = new JButton("Inregistrare");
		inregistrare.setForeground(new Color(238, 238, 238));
		inregistrare.setBackground(new Color(45, 35, 39));
		inregistrare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					int ok=0;
					
					      int ku=0;
					      int kp=0;
					          if(username.getText().equals("admin1234"))
					        	  ku=1;
					          if(parola.getText().equals("parola1234"))
					        	  kp=1;  
				
				if(username.getText().length()==0){
					JOptionPane.showMessageDialog(contentPane,"Trebuie sa completati tabelul de nume admin!");
						ok=1;
						}
				else
				if(parola.getText().length()==0){
					JOptionPane.showMessageDialog(contentPane,"Trebuie sa completati tabelul de parola!");
						ok=1;
						}
				else
					if(ku==0){
						JOptionPane.showMessageDialog(contentPane,"Acest nume de admin nu exista!");
						    ok=1;
						    }
					else
						if(kp==0){
							JOptionPane.showMessageDialog(contentPane,"Parola incorecta!");
							    ok=1;
							    }
				
					
				if(ok==0)
					{
					usernamee=username.getText();
					JOptionPane.showMessageDialog(contentPane,"Inregistrare in cont admin realizata cu succes!");
					dispose();
					Box6 b6=new Box6();
					b6.setVisible(true);
					
					}
				}catch(Exception el) {
					System.out.println(el);
				}
			}
		});
		inregistrare.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		inregistrare.setBounds(288, 333, 168, 43);
		contentPane.add(inregistrare);
		
		JButton cancel = new JButton("Cancel");
		cancel.setForeground(new Color(238, 238, 238));
		cancel.setBackground(new Color(45, 35, 39));
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
		cancel.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		cancel.setBounds(58, 333, 168, 43);
		contentPane.add(cancel);
	}
}
