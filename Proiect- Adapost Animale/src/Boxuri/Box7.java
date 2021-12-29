
package Boxuri;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Box7 extends JFrame {


	private JPanel contentPane;
	private JTextField animal;
	private JTextField rasa;
	private JTextField greutate;

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
	public static Boolean number(String t) {
		String decimalPattern = "([0-9]*)\\.([0-9]*)";  
		boolean match = Pattern.matches(decimalPattern, t);
		return match;
	}

	/**
	 * Create the frame.
	 */
	public Box7() {
		setAlwaysOnTop(true);
		setBackground(new Color(0, 70, 67));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(545, 473);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 70, 67));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JButton cancel = new JButton("Cancel");
		cancel.setForeground(new Color(238, 238, 238));
		cancel.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dispose();
					Box6 b6=new Box6();
					b6.setVisible(true);
				}catch(Exception el) {
					System.out.println(el);
				}
			}
		});
		cancel.setBackground(new Color(45, 35, 39));
		cancel.setBounds(26, 389, 140, 36);
		contentPane.add(cancel);
		
		JButton inregistrare = new JButton("Salveaza");
		inregistrare.setForeground(new Color(238, 238, 238));
		inregistrare.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		inregistrare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int ok=0;
					if(animal.getText().length()==0){
						JOptionPane.showMessageDialog(contentPane,"Trebuie sa completati tabelul de nume animal!");
							ok=1;
							}
					else
					if(greutate.getText().length()==0){
						JOptionPane.showMessageDialog(contentPane,"Trebuie sa completati tabelul de greutate!");
							ok=1;
							}
					else
						if(rasa.getText().length()==0){
							JOptionPane.showMessageDialog(contentPane,"Trebuie sa completati tabelul de rasa!");
							    ok=1;
							    }
						else
							if(number(greutate.getText())==false){
							JOptionPane.showMessageDialog(contentPane,"Greutatea nu este introdusa corect!");
							    ok=1;
							    }
					if(ok==0)
					{int defaultt=0;
			    	 Class.forName("com.mysql.jdbc.Driver");
			    	 int k=0;
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/p3","root","");
				      String query = "SELECT Id_animal FROM animale"; 
				      PreparedStatement ps = conn.prepareStatement(query);
				      ResultSet rs = (ResultSet) ps.executeQuery();
				      while (rs.next())
				      {
				    	  if(Integer.parseInt(rs.getString("Id_animal"))==1)
				    		  k=1;
				          if(Integer.parseInt(rs.getString("Id_animal"))>defaultt)
				        	  defaultt=Integer.parseInt(rs.getString("Id_animal"));
				      }       
				      defaultt++;
				      conn.close();
					
					 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
			    	 LocalDateTime now = LocalDateTime.now();  
			    	 String s=dtf.format(now).toString();
			    	 Class.forName("com.mysql.jdbc.Driver");
					conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/p3","root","");
					ps=conn.prepareStatement("insert into animale(Id_animal, Animal, Rasa, Numar_kilograme, Data_adaugare, Status_adoptie, User) values(?,?,?,?,?,?,?);");
					ps.setInt(1, defaultt);
					ps.setString(2, animal.getText());
					ps.setString(3, rasa.getText());
					ps.setDouble(4, Double.parseDouble(greutate.getText()));
					ps.setString(5, s);
					ps.setBoolean(6, false);
					ps.setString(7, "nu");
					int x=ps.executeUpdate();
						
					if(x>0) {
							 JOptionPane.showMessageDialog(contentPane,"Inregistrarea a fost un succes!");
							}else
								JOptionPane.showMessageDialog(contentPane,"Inregistrarea nu a avut loc!");
					conn.close();
					dispose();
					Box6 b6=new Box6();
					b6.setVisible(true);}
				}catch(Exception el) {
					System.out.println(el);
				}
			}
		});
		inregistrare.setBackground(new Color(45, 35, 39));
		inregistrare.setBounds(366, 389, 140, 36);
		contentPane.add(inregistrare);
		
		JLabel lblAdmin = new JLabel("Adaugare animal");
		lblAdmin.setForeground(new Color(238, 238, 238));
		lblAdmin.setFont(new Font("Segoe UI", Font.BOLD, 50));
		lblAdmin.setBounds(81, 11, 406, 73);
		contentPane.add(lblAdmin);
		
		JLabel a = new JLabel("Animal");
		a.setForeground(new Color(238, 238, 238));
		a.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		a.setBounds(26, 95, 202, 30);
		contentPane.add(a);
		
		JLabel lblNewLabel_1_1 = new JLabel("Rasa");
		lblNewLabel_1_1.setForeground(new Color(238, 238, 238));
		lblNewLabel_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(26, 177, 202, 30);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Greutate");
		lblNewLabel_1_2.setForeground(new Color(238, 238, 238));
		lblNewLabel_1_2.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(26, 259, 202, 30);
		contentPane.add(lblNewLabel_1_2);
		
		animal = new JTextField();
		animal.setColumns(10);
		animal.setBackground(Color.WHITE);
		animal.setBounds(26, 136, 242, 30);
		contentPane.add(animal);
		
		rasa = new JTextField();
		rasa.setColumns(10);
		rasa.setBackground(Color.WHITE);
		rasa.setBounds(26, 218, 242, 30);
		contentPane.add(rasa);
		
		greutate = new JTextField();
		greutate.setColumns(10);
		greutate.setBackground(Color.WHITE);
		greutate.setBounds(26, 300, 242, 30);
		contentPane.add(greutate);
	}
}
