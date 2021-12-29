package Boxuri;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JDesktopPane;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.RootPaneContainer;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Scrollbar;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;

public class Box13 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Box8 frame = new Box8();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	
	public Box13() throws ClassNotFoundException, SQLException {
		setAlwaysOnTop(true);
		setBackground(new Color(0, 70, 67));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000, 430);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 70, 67));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		 JPanel container = new JPanel();
	     container.setBackground(new Color(244, 247, 245));
	     container.setForeground(new Color(45, 35, 39));
		container.setLayout(null);
		container.setPreferredSize(new Dimension(1500,1500));
		
		JScrollPane scrollPane = new JScrollPane(container);
		scrollPane.setBounds(20, 170, 956, 212);
		contentPane.add(scrollPane);
		
		JLabel lblAdopt = new JLabel("Adopta un animal");
		lblAdopt.setForeground(new Color(238, 238, 238));
		lblAdopt.setFont(new Font("Segoe UI", Font.BOLD, 50));
		lblAdopt.setBounds(278, 11, 436, 73);
		contentPane.add(lblAdopt);
		
		JButton cancel = new JButton("Inapoi");
		cancel.setForeground(new Color(238, 238, 238));
		cancel.setFont(new Font("Segoe UI", Font.PLAIN, 25));
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
		cancel.setBackground(new Color(45, 35, 39));
		cancel.setBounds(23, 37, 145, 34);
		contentPane.add(cancel);
		
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/p3","root","");
		 String query = "SELECT * FROM animale"; 
		 PreparedStatement ps = conn.prepareStatement(query);
		  ResultSet rs = (ResultSet) ps.executeQuery();
		  List<Integer> list = new ArrayList<Integer>();
		 int i=26;
		      while (rs.next())
		      {if("0".equals(rs.getString("Status_adoptie")))
		    	 {list.add(Integer.parseInt(rs.getString("Id_animal")));
		    	 String x="Id: "+rs.getString("Id_animal")+" ------ ";
		      x=x+"Animal: "+rs.getString("Animal")+" ------ ";
		      x=x+"Rasa: "+rs.getString("Rasa")+" ------ ";
		      x=x+"Greutate: "+rs.getString("Numar_kilograme")+" ------ ";
		      x=x+"Inregistrat la: "+rs.getString("Data_adaugare")+" ------ ";
		      x=x+"Statusul adoptiei: "+rs.getString("Status_adoptie");
		        	  JLabel lbl1_1=new JLabel(x);
		      		lbl1_1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		  			lbl1_1.setBounds(10, 10, 1500, i);
		  			container.add(lbl1_1);
		          i=i+60;
		      }}
		      conn.close();
		
		
		JButton btnAdoptie = new JButton("Adopta");
		btnAdoptie.setForeground(new Color(238, 238, 238));
		btnAdoptie.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		btnAdoptie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int numar=Integer.parseInt(textField.getText());
					int ok=0;
					for(int i=0;i<list.size();i++)
						if(list.get(i)==numar)
						{ok=1; break;}
					if(ok==0)
						JOptionPane.showMessageDialog(contentPane,"Numar de identificare gresit");
					else
					{Class.forName("com.mysql.jdbc.Driver");
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/p3","root","");
					String query = ("UPDATE animale SET Status_adoptie=?,User=? WHERE Id_animal=?");
					PreparedStatement ps=conn.prepareStatement(query);
					ps.setBoolean(1, true);
					ps.setString(2, Box3.usernamee);
					ps.setInt(3, Integer.parseInt(textField.getText()));
					ps.executeUpdate();
					conn.close();
					 
					JOptionPane.showMessageDialog(contentPane,"Felicitari! Ati oferit adapost unui suflet ^^.");
					dispose();
					Box9 b9=new Box9();
					b9.setVisible(true);}
				}catch(Exception el) {
					System.out.println(el);
				}
			}
		});
		btnAdoptie.setBackground(new Color(45, 35, 39));
		btnAdoptie.setBounds(847, 39, 129, 30);
		contentPane.add(btnAdoptie);
		
		textField = new JTextField();
		textField.setFont(new Font("Segoe UI", Font.BOLD, 25));
		textField.setBounds(518, 117, 81, 34);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Numarul de identificare al animalului adoptat este:");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 123, 511, 24);
		contentPane.add(lblNewLabel);
		
		
			 
	}
}
