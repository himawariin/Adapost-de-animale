package Boxuri;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;

public class Box11 extends JFrame {

	private JPanel contentPane;
	private JTextField iban;
	private JTextField cvv;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Box11 frame = new Box11();
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
	public Box11() {
		setAlwaysOnTop(true);
		setBackground(new Color(0, 70, 67));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(636, 372);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 70, 67));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblAdaugareMetodaDe = new JLabel("Adaugare metoda de plata");
		lblAdaugareMetodaDe.setForeground(new Color(238, 238, 238));
		lblAdaugareMetodaDe.setFont(new Font("Segoe UI", Font.BOLD, 42));
		lblAdaugareMetodaDe.setBounds(45, 11, 546, 73);
		contentPane.add(lblAdaugareMetodaDe);
		
		JButton cancel = new JButton("Inapoi");
		cancel.addActionListener(new ActionListener() {
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
		cancel.setForeground(new Color(238, 238, 238));
		cancel.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		cancel.setBackground(new Color(45, 35, 39));
		cancel.setBounds(22, 274, 168, 43);
		contentPane.add(cancel);
		
		
		
		JLabel lblDetaliiCard = new JLabel("Detalii card");
		lblDetaliiCard.setForeground(new Color(238, 238, 238));
		lblDetaliiCard.setFont(new Font("Segoe UI", Font.BOLD, 25));
		lblDetaliiCard.setBounds(22, 95, 459, 30);
		contentPane.add(lblDetaliiCard);
		
		JLabel lblIban = new JLabel("IBAN:");
		lblIban.setForeground(new Color(238, 238, 238));
		lblIban.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		lblIban.setBounds(20, 136, 64, 30);
		contentPane.add(lblIban);
		
		iban = new JTextField();
		iban.setFont(new Font("Segoe UI", Font.BOLD, 17));
		iban.setForeground(new Color(0, 70, 67));
		iban.setColumns(10);
		iban.setBackground(Color.WHITE);
		iban.setBounds(94, 136, 409, 30);
		contentPane.add(iban);
		
		JLabel lblCvv = new JLabel("CVV:");
		lblCvv.setForeground(new Color(238,238,238));
		lblCvv.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		lblCvv.setBounds(20, 177, 64, 30);
		contentPane.add(lblCvv);
		
		JLabel lblDataExpirare = new JLabel("DATA EXPIRARE:");
		lblDataExpirare.setForeground(new Color(238, 238, 238));
		lblDataExpirare.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		lblDataExpirare.setBounds(20, 219, 180, 30);
		contentPane.add(lblDataExpirare);
		
		cvv = new JTextField();
		cvv.setFont(new Font("Segoe UI", Font.BOLD, 17));
		cvv.setForeground(new Color(0, 70, 67));
		cvv.setColumns(10);
		cvv.setBackground(Color.WHITE);
		cvv.setBounds(94, 177, 409, 30);
		contentPane.add(cvv);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setForeground(new Color(0, 70, 67));
		comboBox.setBackground(new Color(238, 238, 238));
		comboBox.setFont(new Font("Segoe UI", Font.BOLD, 17));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		comboBox.setBounds(248, 221, 64, 31);
		contentPane.add(comboBox);
		
		JLabel lblMm = new JLabel("MM:");
		lblMm.setForeground(new Color(238, 238, 238));
		lblMm.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		lblMm.setBounds(195, 219, 64, 30);
		contentPane.add(lblMm);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBackground(new Color(238, 238, 238));
		comboBox_1.setForeground(new Color(0, 70, 67));
		comboBox_1.setFont(new Font("Segoe UI", Font.BOLD, 17));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33"}));
		comboBox_1.setBounds(414, 219, 64, 31);
		contentPane.add(comboBox_1);
		
		JLabel lblYy = new JLabel("YY:");
		lblYy.setForeground(new Color(238, 238, 238));
		lblYy.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		lblYy.setBounds(377, 219, 38, 30);
		contentPane.add(lblYy);
		
		JButton btnSalveaza = new JButton("Salveaza");
		btnSalveaza.setForeground(new Color(238, 238, 238));
		btnSalveaza.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		btnSalveaza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int ok=0;
					if(iban.getText().length()==0){
						JOptionPane.showMessageDialog(contentPane,"Trebuie sa completati tabelul de IBAN!");
							ok=1;
							}
					else
					if(cvv.getText().length()==0){
						JOptionPane.showMessageDialog(contentPane,"Trebuie sa completati tabelul de CVV!");
							ok=1;
							}
					else
						if(iban.getText().length()!=16){
							JOptionPane.showMessageDialog(contentPane,"Trebuie sa completati tabelul de IBAN corespunzator!");
							    ok=1;
							    }
						else
							if(cvv.getText().length()!=3){
								JOptionPane.showMessageDialog(contentPane,"Trebuie sa completati tabelul de CVV corespunzator!");
								    ok=1;
								    }
					if (ok==0) {
						if(Box3.modificare_card==0) {
					String s=comboBox.getSelectedItem().toString()+"/"+comboBox_1.getSelectedItem().toString();
			    	 Class.forName("com.mysql.jdbc.Driver");
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/p3","root","");
					PreparedStatement ps=conn.prepareStatement("insert into donat(Username, Iban, Cvv, Data_expirare) values(?,?,?,?);");
					ps.setString(1, Box3.usernamee);
					ps.setString(2, iban.getText());
					ps.setString(3, cvv.getText());
					ps.setString(4, s);
					int x=ps.executeUpdate();
						
					if(x>0) {
							 JOptionPane.showMessageDialog(contentPane,"Metoda de plata a fost actualizata cu succes!");
							}else
								JOptionPane.showMessageDialog(contentPane,"Metoda de plata nu a fost actualizata!");
					conn.close();}
						else
						{	Box3.modificare_card=0;
							//UPDATE LA TABELUL DONAT 
							String s=comboBox.getSelectedItem().toString()+"/"+comboBox_1.getSelectedItem().toString();
							Class.forName("com.mysql.jdbc.Driver");
							Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/p3","root","");
							String query = ("UPDATE donat SET Iban=?,Cvv=?,Data_expirare=? WHERE Username=?");
							PreparedStatement ps=conn.prepareStatement(query);
							ps.setString(1, iban.getText());
							ps.setString(2, cvv.getText());
							ps.setString(3, s);
							ps.setString(4, Box3.usernamee);
							ps.executeUpdate();
						}
					dispose();
					Box10 b10=new Box10();
					b10.setVisible(true);
						}}catch(Exception el) {
					System.out.println(el);
				}
			}
		});
		btnSalveaza.setBackground(new Color(45, 35, 39));
		btnSalveaza.setBounds(432, 274, 168, 43);
		contentPane.add(btnSalveaza);
		
		
	}
}
