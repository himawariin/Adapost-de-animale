package Boxuri;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Box10 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Box10 frame = new Box10();
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
	
	public Box10() {
		setAlwaysOnTop(true);
		setBackground(new Color(0, 70, 67));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(680, 406);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 70, 67));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblDoneaza = new JLabel("Doneaza");
		lblDoneaza.setForeground(new Color(238, 238, 238));
		lblDoneaza.setFont(new Font("Segoe UI", Font.BOLD, 50));
		lblDoneaza.setBounds(235, 11, 324, 73);
		contentPane.add(lblDoneaza);
		
		JButton cancel = new JButton("Inapoi");
		cancel.setForeground(new Color(238, 238, 238));
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dispose();
					Box9 b9=new Box9();
					b9.setVisible(true);
				}catch(Exception el) {
					System.out.println(el);
				}
			}
		});
		cancel.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		cancel.setBackground(new Color(45, 35, 39));
		cancel.setBounds(20, 316, 168, 43);
		contentPane.add(cancel);
		
		JLabel text1 = new JLabel("");
		text1.setForeground(Color.WHITE);
		text1.setBackground(Color.WHITE);
		text1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		text1.setBounds(31, 208, 528, 23);
		contentPane.add(text1);
		
		JLabel text2 = new JLabel("");
		text2.setForeground(Color.WHITE);
		text2.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		text2.setBackground(Color.WHITE);
		text2.setBounds(33, 240, 623, 23);
		contentPane.add(text2);
		
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "3", "5", "10", "20", "30", "50", "100"}));
		comboBox_1.setForeground(Color.BLACK);
		comboBox_1.setFont(new Font("Segoe UI", Font.BOLD, 20));
		comboBox_1.setBackground(Color.WHITE);
		comboBox_1.setBounds(489, 167, 85, 30);
		contentPane.add(comboBox_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setForeground(Color.BLACK);
		comboBox.setBackground(Color.WHITE);
		comboBox.setFont(new Font("Segoe UI", Font.BOLD, 20));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "3", "5", "10", "20", "30", "50", "100"}));
		comboBox.setBounds(498, 126, 85, 30);
		contentPane.add(comboBox); 
		
		JButton btnDoneaza = new JButton("Doneaza");
		btnDoneaza.setForeground(new Color(238, 238, 238));
		btnDoneaza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int ok=0;
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/p3","root","");
				    String query = "SELECT Username FROM donat"; 
				    PreparedStatement ps = conn.prepareStatement(query);
				    ResultSet rs = (ResultSet) ps.executeQuery();
				      while (rs.next())
				      {
				    	  if(Box3.usernamee.equals(rs.getString("Username")))
				    		  {ok=1;
				    		  break;}
				      }       
				      if(ok==1)
				      {	  
				    	  double hrana=Double.parseDouble(comboBox.getSelectedItem().toString());
				    	  double font=Double.parseDouble(comboBox_1.getSelectedItem().toString());
				    	  Class.forName("com.mysql.jdbc.Driver");
							Connection conn1=DriverManager.getConnection("jdbc:mysql://localhost:3306/p3","root","");
							String query1 = ("SELECT * FROM users1");
							PreparedStatement ps1=conn1.prepareStatement(query1);
							ResultSet rs1 = (ResultSet) ps1.executeQuery();
						      while (rs1.next())
						      {	
						          if(Box3.usernamee.equals(rs1.getString("Username")))
						        	  {		
						        	  hrana=hrana+Double.parseDouble(rs1.getString("Suma_donatii_hrana"));
						        	  font=font+Double.parseDouble(rs1.getString("Suma_donatii_font"));
						        	  break;}
						      }       
							conn1.close();
							System.out.println(2);
							Class.forName("com.mysql.jdbc.Driver");
							Connection conn2=DriverManager.getConnection("jdbc:mysql://localhost:3306/p3","root","");
							String query2 = ("UPDATE users1 SET Suma_donatii_hrana=?,Suma_donatii_font=? WHERE Username=?");
							PreparedStatement ps2=conn2.prepareStatement(query2);
							ps2.setDouble(1, hrana);
							ps2.setDouble(2, font);
							ps2.setString(3, Box3.usernamee);
							ps2.executeUpdate();
							conn2.close();
				    	  text1.setForeground(Color.GREEN);
				    	  text1.setText("Donatia a fost finalizata cu succes!");
				    	  text2.setText("Va multumim pentru contributie!");
				    	  System.out.println(3);
				      }
				      else
				      {
				  		text1.setForeground(Color.RED);
				    	text1.setText("Nu este introdusa nici o metoda de plata.");
				      }
				conn.close();
				}catch(Exception el) {
					System.out.println(el);
				}
			}
		});
		btnDoneaza.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		btnDoneaza.setBackground(new Color(45, 35, 39));
		btnDoneaza.setBounds(489, 316, 168, 43);
		contentPane.add(btnDoneaza);
		
		JLabel lblSumaPeCare = new JLabel("Suma pe  care doriti sa o donati pentru hrana: ");
		lblSumaPeCare.setForeground(new Color(238, 238, 238));
		lblSumaPeCare.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		lblSumaPeCare.setBounds(33, 126, 459, 30);
		contentPane.add(lblSumaPeCare);
		

		
	
		
		JLabel lblSumaPeCare_2 = new JLabel("Suma pe  care doriti sa o donati pentru font: ");
		lblSumaPeCare_2.setForeground(new Color(238, 238, 238));
		lblSumaPeCare_2.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		lblSumaPeCare_2.setBounds(33, 167, 459, 30);
		contentPane.add(lblSumaPeCare_2);
		

		
		JButton btnAdaugaMetodaDe = new JButton("Metoda Plata");
		btnAdaugaMetodaDe.setForeground(new Color(238, 238, 238));
		btnAdaugaMetodaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int ok=0;
					 Class.forName("com.mysql.jdbc.Driver");
						Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/p3","root","");
						 String query = "SELECT Username FROM donat"; 
						 PreparedStatement ps = conn.prepareStatement(query);
						  ResultSet rs = (ResultSet) ps.executeQuery();
						      while (rs.next())
						      {
						          if(Box3.usernamee.equals(rs.getString("Username")))
						        	  {ok=1;
						        	  break;
						        	  }
						      }       
						if(ok==1)
							{dispose();
							Box12 b12=new Box12();
							b12.setVisible(true);
							}
						else {
					dispose();
					Box11 b11=new Box11();
					b11.setVisible(true);}
					conn.close();
				}catch(Exception el) {
					System.out.println(el);
				}
			}
		});
		btnAdaugaMetodaDe.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		btnAdaugaMetodaDe.setBackground(new Color(45, 35, 39));
		btnAdaugaMetodaDe.setBounds(218, 316, 241, 43);
		contentPane.add(btnAdaugaMetodaDe);
		
		
		
	}
}
