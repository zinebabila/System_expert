package fstm.projet.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fstm.projet.controller.Diagnostic_CTR;
import fstm.projet.model.bo.Client;
import fstm.projet.model.bo.Diagnostic;


import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

public class ConsulterDiag extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private Client client;
	private DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	
	public ConsulterDiag(Client c) {
		client=c;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		
		
		model =new DefaultTableModel();
		Object[] coloStrings= {"Date","Resultat","Option"};
		
		model.setColumnIdentifiers(coloStrings);
		model.addRow(new String[] {"Date","Resultat","Option"});
		
		Diagnostic_CTR.rempliTable(model, c);
		table.setModel(model);
		table.setBounds(10, 60, 416, 152);
		contentPane.add(table);
		
		JButton btnNewButton = new JButton("nouveau diagnostic");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ClientSt(c).setVisible(true);;
			}
		});
		btnNewButton.setBounds(43, 222, 141, 31);
		contentPane.add(btnNewButton);
	}
}
