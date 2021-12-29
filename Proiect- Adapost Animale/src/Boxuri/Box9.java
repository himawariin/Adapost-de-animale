package Boxuri;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import java.awt.Label;
import java.awt.Button;
import java.awt.Canvas;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JProgressBar;
import javax.swing.JEditorPane;
import javax.swing.SwingConstants;

public class Box9 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Box9 frame = new Box9();
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
	public Box9() {
		setAlwaysOnTop(true);
		setBackground(new Color(0, 70, 67));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(719, 430);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 70, 67));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblEliminare = new JLabel("Actiuni utilizator");
		lblEliminare.setForeground(new Color(238, 238, 238));
		lblEliminare.setFont(new Font("Segoe UI", Font.BOLD, 50));
		lblEliminare.setBounds(139, 11, 401, 73);
		contentPane.add(lblEliminare);
		
		JButton cancel = new JButton("Inapoi");
		cancel.setForeground(new Color(238, 238, 238));
		cancel.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		cancel.addActionListener(new ActionListener() {
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
		cancel.setBackground(new Color(45, 35, 39));
		cancel.setBounds(91, 339, 168, 43);
		contentPane.add(cancel);
		
		JButton btnEliminare = new JButton("Adopta un animal!");
		btnEliminare.setForeground(new Color(238, 238, 238));
		btnEliminare.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		btnEliminare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dispose();
					Box13 b13=new Box13();
					b13.setVisible(true);
				}catch(Exception el) {
					System.out.println(el);
				}
			}
		});
		btnEliminare.setBackground(new Color(45, 35, 39));
		btnEliminare.setBounds(32, 129, 281, 43);
		contentPane.add(btnEliminare);
		
		
		
		JButton btnDoneaza = new JButton("Doneaza");
		btnDoneaza.setForeground(new Color(238, 238, 238));
		btnDoneaza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dispose();
					Box10 b10=new Box10();
					b10.setVisible(true);
					
				}catch(Exception el) {
					System.out.println(el);
				}
			}
		});
		btnDoneaza.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		btnDoneaza.setBackground(new Color(45, 35, 39));
		btnDoneaza.setBounds(32, 257, 281, 43);
		contentPane.add(btnDoneaza);
		
		
		JLabel lblNewLabel_1 = new JLabel("Username:");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_1.setForeground(new Color(45, 35, 39));
		lblNewLabel_1.setBounds(367, 155, 115, 28);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setVisible(false);
		
		JLabel lblNewLabel_1_1 = new JLabel("Varsta:");
		lblNewLabel_1_1.setForeground(new Color(45, 35, 39));
		lblNewLabel_1_1.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(367, 194, 79, 28);
		contentPane.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setVisible(false);
		
		JLabel lblNewLabel_1_2 = new JLabel("Animale adoptate:");
		lblNewLabel_1_2.setForeground(new Color(45, 35, 39));
		lblNewLabel_1_2.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_1_2.setBounds(367, 233, 186, 28);
		contentPane.add(lblNewLabel_1_2);
		lblNewLabel_1_2.setVisible(false);
		
		JLabel lblNewLabel_1_3 = new JLabel("Suma donata:");
		lblNewLabel_1_3.setForeground(new Color(45, 35, 39));
		lblNewLabel_1_3.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_1_3.setBounds(367, 272, 140, 28);
		contentPane.add(lblNewLabel_1_3);
		lblNewLabel_1_3.setVisible(false);
		
		JLabel username = new JLabel("-");
		username.setForeground(new Color(45, 35, 39));
		username.setFont(new Font("Segoe UI", Font.BOLD, 20));
		username.setBounds(482, 155, 109, 28);
		contentPane.add(username);
		username.setVisible(false);
		
		JLabel varsta = new JLabel("-");
		varsta.setForeground(new Color(45, 35, 39));
		varsta.setFont(new Font("Segoe UI", Font.BOLD, 20));
		varsta.setBounds(451, 194, 115, 28);
		contentPane.add(varsta);
		varsta.setVisible(false);
		
		JLabel animale = new JLabel("-");
		animale.setForeground(new Color(45, 35, 39));
		animale.setFont(new Font("Segoe UI", Font.BOLD, 20));
		animale.setBounds(559, 233, 115, 28);
		contentPane.add(animale);
		animale.setVisible(false);
		
		JLabel suma = new JLabel("-");
		suma.setForeground(new Color(45, 35, 39));
		suma.setFont(new Font("Segoe UI", Font.BOLD, 20));
		suma.setBounds(506, 272, 115, 28);
		contentPane.add(suma);
		suma.setVisible(false);
		
		JLabel lblNewLabel_1_8 = new JLabel("Metoda de donatie:");
		lblNewLabel_1_8.setForeground(new Color(45, 35, 39));
		lblNewLabel_1_8.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_1_8.setBounds(367, 313, 186, 28);
		contentPane.add(lblNewLabel_1_8);
		lblNewLabel_1_8.setVisible(false);
		
		JLabel metoda = new JLabel("lipseste");
		metoda.setForeground(new Color(45, 35, 39));
		metoda.setFont(new Font("Segoe UI", Font.BOLD, 20));
		metoda.setBounds(559, 313, 115, 28);
		contentPane.add(metoda);
		metoda.setVisible(false);
		
		
		JLabel lblNewLabel = new JLabel("Profilul meu");
		lblNewLabel.setForeground(new Color(45, 35, 39));
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 27));
		lblNewLabel.setBounds(416, 110, 172, 34);
		contentPane.add(lblNewLabel);
		lblNewLabel.setVisible(false);
		
		JLabel cardul = new JLabel("iban card inexistent");
		cardul.setForeground(new Color(45, 35, 39));
		cardul.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 15));
		cardul.setBounds(368, 332, 172, 34);
		contentPane.add(cardul);
		cardul.setVisible(false);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.GREEN);
		panel.setBackground(new Color(244, 247, 245));
		panel.setBounds(349, 95, 325, 294);
		contentPane.add(panel);
		panel.setVisible(false);
		
		JLabel imagine = new JLabel("");
		imagine.setHorizontalAlignment(SwingConstants.CENTER);
		imagine.setIcon(new ImageIcon("D:\\Downloads\\animal (2).png"));
		imagine.setBounds(356, 95, 318, 271);
		contentPane.add(imagine);
		

		
		JButton btnProfilulMeu = new JButton("Profilul meu");
		btnProfilulMeu.setForeground(new Color(238, 238, 238));
		btnProfilulMeu.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		btnProfilulMeu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				      String card="";

					Class.forName("com.mysql.jdbc.Driver");
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/p3","root","");
				      String query = "SELECT * FROM users1"; 
				      PreparedStatement ps = conn.prepareStatement(query);
				      ResultSet rs = (ResultSet) ps.executeQuery();
				      while (rs.next())
				      {
				          if(Box3.usernamee.equals(rs.getString("Username")))
				        	  {varsta.setText(rs.getString("Varsta"));
								suma.setText(Double.toString(Double.parseDouble(rs.getString("Suma_donatii_hrana"))+Double.parseDouble(rs.getString("Suma_donatii_font"))));
				        	  break;}
				      }       
				      username.setText(Box3.usernamee);
				      conn.close();
				      int ok=0;
				      Class.forName("com.mysql.jdbc.Driver");
					conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/p3","root","");
					 query = "SELECT * FROM donat"; 
					  ps = conn.prepareStatement(query);
					   rs = (ResultSet) ps.executeQuery();
					      while (rs.next())
					      {
					          if(Box3.usernamee.equals(rs.getString("Username")))
					        	  {ok=1;
					        	  card=rs.getString("Iban");
					        	  break;
					        	  }
					      }       
					if(ok==1)
						{metoda.setText("introdusa");
						cardul.setText("**** **** **** "+card.charAt(card.length()-4)+card.charAt(card.length()-3)+card.charAt(card.length()-2)+card.charAt(card.length()-1));
						}
					conn.close();
					int anim=0;
					Class.forName("com.mysql.jdbc.Driver");
					conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/p3","root","");
					 query = "SELECT User FROM animale"; 
					  ps = conn.prepareStatement(query);
					   rs = (ResultSet) ps.executeQuery();
					      while (rs.next())
					      {
					          if(Box3.usernamee.equals(rs.getString("User")))
					        	  {anim++;
					        	  }
					      }    
					      
					animale.setText(Integer.toString(anim));
					  
					conn.close();
					panel.setVisible(true);
					lblNewLabel.setVisible(true);
					lblNewLabel_1.setVisible(true);
					lblNewLabel_1_1.setVisible(true);
					lblNewLabel_1_2.setVisible(true);
					lblNewLabel_1_3.setVisible(true);
					cardul.setVisible(true);
					username.setVisible(true);
					varsta.setVisible(true);
					animale.setVisible(true);
					suma.setVisible(true);
					lblNewLabel_1_8.setVisible(true);
					metoda.setVisible(true);
					imagine.setVisible(false);
					
				}catch(Exception el) {
					System.out.println(el);
				}
			}
		});
		btnProfilulMeu.setBackground(new Color(45, 35, 39));
		btnProfilulMeu.setBounds(32, 193, 281, 43);
		contentPane.add(btnProfilulMeu);
		
		
		
		
		
		
	}
}
