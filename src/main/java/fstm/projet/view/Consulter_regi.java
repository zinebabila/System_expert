package fstm.projet.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import fstm.projet.controller.Diagnostic_CTR;
import fstm.projet.model.bo.Client;

import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Consulter_regi extends JFrame {

	private JPanel contentPane;
	private DefaultTableModel model=new DefaultTableModel();
	private JTable table;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public Consulter_regi( Client c) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 729, 476);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JLabel lblNewLabel = new JLabel("      Les regions");
		lblNewLabel.setBounds(272, 10, 151, 33);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Retour");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new CHoix(c).setVisible(true);
			}
		});
		btnNewButton.setBounds(283, 386, 85, 21);
		contentPane.add(btnNewButton);
		
	
	
		
		
        Object[] coloStrings= {"Nom region","Nombre de contaminees","Nombre de deces ","Nombre de gueries"};
		
		model.setColumnIdentifiers(coloStrings);
		model.addRow(new String[] {"Nom region","Nombre de contaminees","Nombre de deces ","Nombre de gueries"});
		table = new JTable();
		table.setBounds(47, 77, 629, 281);
		
		
		Diagnostic_CTR.rempliTableRegion(model);
		table.setModel(model);
		table.setRowHeight(27);
		contentPane.add(table);
		
	}
}
