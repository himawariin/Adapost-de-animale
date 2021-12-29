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

import javax.swing.JButton;

public class Box12 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Box12 frame = new Box12();
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
	public Box12() {
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
		
		JLabel lblMetodaDePlata = new JLabel("Metoda de plata");
		lblMetodaDePlata.setForeground(new Color(238, 238, 238));
		lblMetodaDePlata.setFont(new Font("Segoe UI", Font.BOLD, 42));
		lblMetodaDePlata.setBounds(148, 11, 447, 73);
		contentPane.add(lblMetodaDePlata);
		
		JLabel lblMetodaDePlata_1 = new JLabel("Metoda de plata adaugata.\r\n");
		lblMetodaDePlata_1.setForeground(new Color(238, 238, 238));
		lblMetodaDePlata_1.setFont(new Font("Segoe UI", Font.BOLD, 25));
		lblMetodaDePlata_1.setBounds(21, 105, 591, 48);
		contentPane.add(lblMetodaDePlata_1);
		
		JLabel lblMetodaDePlata_1_1 = new JLabel("Doriti sa modificati metoda de plata actuala?");
		lblMetodaDePlata_1_1.setForeground(new Color(238, 238, 238));
		lblMetodaDePlata_1_1.setFont(new Font("Segoe UI", Font.BOLD, 25));
		lblMetodaDePlata_1_1.setBounds(21, 135, 591, 48);
		contentPane.add(lblMetodaDePlata_1_1);
		
		JButton cancel = new JButton("Inapoi");
		cancel.setForeground(new Color(238, 238, 238));
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
		cancel.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		cancel.setBackground(new Color(45, 35, 39));
		cancel.setBounds(231, 281, 168, 43);
		contentPane.add(cancel);
		
		JButton btnDa = new JButton("Da");
		btnDa.setForeground(new Color(238, 238, 238));
		btnDa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Box3.modificare_card=1;
					dispose();
					Box11 b11=new Box11();
					b11.setVisible(true);
				}catch(Exception el) {
					System.out.println(el);
				}
			}
		});
		btnDa.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		btnDa.setBackground(new Color(45, 35, 39));
		btnDa.setBounds(110, 202, 168, 43);
		contentPane.add(btnDa);
		
		JButton btnNu = new JButton("Nu");
		btnNu.setForeground(new Color(238, 238, 238));
		btnNu.addActionListener(new ActionListener() {
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
		btnNu.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		btnNu.setBackground(new Color(45, 35, 39));
		btnNu.setBounds(364, 202, 168, 43);
		contentPane.add(btnNu);
	}

}
