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
import java.awt.Scrollbar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;

public class Box2 extends JFrame {

	private JPanel contentPane;
	private JTextField nume;
	private JTextField prenume;
	private JTextField username;
	private JTextField parola;
	private JTextField repParola;
	private JTextField varsta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Box2 frame = new Box2();
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
	public Box2() {
		setBackground(new Color(0, 70, 67));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(737, 584);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 70, 67));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Creare cont");
		lblNewLabel.setForeground(new Color(238, 238, 238));
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 50));
		lblNewLabel.setBounds(239, 31, 272, 55);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nume");
		lblNewLabel_1.setForeground(new Color(238, 238, 238));
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(28, 120, 214, 40);
		contentPane.add(lblNewLabel_1);
		
		nume = new JTextField();
		nume.setBackground(new Color(255, 255, 255));
		nume.setBounds(28, 161, 262, 29);
		contentPane.add(nume);
		nume.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Prenume");
		lblNewLabel_1_1.setForeground(new Color(238, 238, 238));
		lblNewLabel_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(404, 120, 214, 40);
		contentPane.add(lblNewLabel_1_1);
		
		prenume = new JTextField();
		prenume.setColumns(10);
		prenume.setBounds(404, 161, 262, 29);
		contentPane.add(prenume);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Username");
		lblNewLabel_1_1_1.setForeground(new Color(238, 238, 238));
		lblNewLabel_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setBounds(28, 201, 214, 40);
		contentPane.add(lblNewLabel_1_1_1);
		
		username = new JTextField();
		username.setColumns(10);
		username.setBounds(28, 242, 262, 29);
		contentPane.add(username);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Varsta");
		lblNewLabel_1_1_1_1_1_1.setForeground(new Color(238, 238, 238));
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1_1_1.setBounds(404, 201, 214, 40);
		contentPane.add(lblNewLabel_1_1_1_1_1_1);
		
		varsta = new JTextField();
		varsta.setColumns(10);
		varsta.setBounds(404, 242, 262, 29);
		contentPane.add(varsta);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Parola");
		lblNewLabel_1_1_1_1.setForeground(new Color(238, 238, 238));
		lblNewLabel_1_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1.setBounds(28, 282, 214, 40);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		parola = new JTextField();
		parola.setColumns(10);
		parola.setBounds(28, 323, 262, 29);
		contentPane.add(parola);
		
		
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Repetare parola");
		lblNewLabel_1_1_1_1_1.setForeground(new Color(238, 238, 238));
		lblNewLabel_1_1_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1_1.setBounds(404, 282, 214, 40);
		contentPane.add(lblNewLabel_1_1_1_1_1);
		
		repParola = new JTextField();
		repParola.setColumns(10);
		repParola.setBounds(404, 323, 272, 29);
		contentPane.add(repParola);
		
		JButton creare = new JButton("Creare");
		creare.setBackground(new Color(45, 35, 39));
		creare.setForeground(new Color(238, 238, 238));
		creare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int ok=0;

					Class.forName("com.mysql.jdbc.Driver");

					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/p3","root","");

					      String query = "SELECT Username FROM users1"; 
					      PreparedStatement ps = conn.prepareStatement(query);
					      ResultSet rs = (ResultSet) ps.executeQuery();
					      int k=0;

					      while (rs.next())
					      {
					          if(username.getText().equals(rs.getString("Username")))
					        	  k=1;
					      }       

					     if(k==1)
					    {JOptionPane.showMessageDialog(contentPane,"Acest username este deja folosit!");
					    ok=1;
					    }
					    else
					if(nume.getText().length()==0)
						{JOptionPane.showMessageDialog(contentPane,"Trebuie sa completati tabelul de nume!");
						ok=1;}
						
					else
					if(prenume.getText().length()==0)
						{JOptionPane.showMessageDialog(contentPane,"Trebuie sa completati tabelul de prenume!");
						ok=1;
						}
					else
					if(username.getText().length()==0)
						{JOptionPane.showMessageDialog(contentPane,"Trebuie sa completati tabelul de username!");
						ok=1;
						}
					else
					if(varsta.getText().length()==0)
						{JOptionPane.showMessageDialog(contentPane,"Trebuie sa completati tabelul de varsta!");
						ok=1;
						}
					else
					if(parola.getText().length()==0)
						{JOptionPane.showMessageDialog(contentPane,"Trebuie sa completati tabelul de parola!");
						ok=1;
						}
					else
					if(repParola.getText().length()==0)
						{JOptionPane.showMessageDialog(contentPane,"Trebuie sa completati tabelul de repetare parola!");
						ok=1;
						}
					else
						if(parola.getText().equals(repParola.getText()))
							ok=0;
						else
					if(parola.getText()!=repParola.getText())//daca cele 2 parola nu coincid nu trec mai departe
						{JOptionPane.showMessageDialog(contentPane,"Cele 2 parola nu coincid. Mai incercati!");
						ok=1;
						}
					/*else
						if(Number.isNumber(varsta.getText()))*/
					      System.out.println("4");

				if(ok==0)
					{Class.forName("com.mysql.jdbc.Driver");
					conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/p3","root","");
				 ps=conn.prepareStatement("insert into users1(Nume,Prenume,Username,Parola,Varsta,"
				 		+ "Suma_donatii_hrana,Suma_donatii_font) values(?,?,?,?,?,?,?);");
				 String Suma_d_h="0";
				 String Suma_d_f="0";
				 ps.setString(1, nume.getText());
				ps.setString(2, prenume.getText());
				ps.setString(3, username.getText());
				ps.setString(4, parola.getText());
				ps.setString(5, varsta.getText());
				ps.setString(6, Suma_d_h);
				ps.setString(7, Suma_d_f);

				int x=ps.executeUpdate();
					
				if(x>0) {
						 JOptionPane.showMessageDialog(contentPane,"Cont creat cu succes!");
						}else
							JOptionPane.showMessageDialog(contentPane,"Contul nu a fost creat!");
				dispose();
				Box1 b1=new Box1();
				b1.setVisible(true);
					}	
				conn.close();

				}catch(Exception el) {
					System.out.println(el);
				}
			}
		});
		creare.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		creare.setBounds(389, 421, 180, 48);
		contentPane.add(creare);
		
		
		
		JButton cancel = new JButton("Cancel");
		cancel.setForeground(new Color(238, 238, 238));
		cancel.setBackground(new Color(45, 35, 39));
		cancel.addActionListener(new ActionListener() {
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
		cancel.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		cancel.setBounds(140, 421, 180, 48);
		contentPane.add(cancel);
	}
}
