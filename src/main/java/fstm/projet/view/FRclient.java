package fstm.projet.view;

import java.awt.BorderLayout;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import javax.swing.JOptionPane;

import fstm.projet.model.bo.Client;
import fstm.projet.model.bo.DroolsTest;

import com.toedter.calendar.JDateChooser;

import fstm.projet.controller.Diagnostic_CTR;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Calendar;
import java.awt.event.ActionEvent;

public class FRclient extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FRclient frame = new FRclient();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public FRclient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Date de naissance");
		lblNewLabel.setBounds(44, 47, 95, 24);
		contentPane.add(lblNewLabel);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(169, 51, 147, 20);
		contentPane.add(dateChooser);
		
		JButton Ajouter = new JButton("Ajouter");
		Ajouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				/*Calendar date= (Calendar) dateChooser.getCalendar();
				Client c= new Client(1,"hi","hi",true,38,null,date);
				if(c.getage()!=-1) {
					double resu=0;
					DroolsTest	d= new DroolsTest();
					resu=d.Start_Rules(c);
					System.out.println(resu);
					JOptionPane.showMessageDialog(Ajouter, "possibilite de presence : " + resu*100 + " %100", "Diagnostic", JOptionPane.INFORMATION_MESSAGE);
				}
				else	JOptionPane.showMessageDialog(Ajouter, "date de naissance nvalide", "Warnings", JOptionPane.ERROR_MESSAGE);
	
					*/
				
						
			}
		});
		Ajouter.setBounds(239, 141, 89, 23);
		contentPane.add(Ajouter);
	}
}
