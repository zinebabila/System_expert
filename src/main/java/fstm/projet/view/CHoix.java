package fstm.projet.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fstm.projet.model.bo.Client;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CHoix extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public CHoix(Client c) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Mes diagnostic");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ConsulterDiag(c).setVisible(true);;
			}
		});
		btnNewButton.setBounds(25, 108, 157, 35);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("nouveau diagnostic");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ClientSt(c).setVisible(true);;
			}
		});
		btnNewButton_1.setBounds(244, 108, 151, 35);
		contentPane.add(btnNewButton_1);
	}
}
