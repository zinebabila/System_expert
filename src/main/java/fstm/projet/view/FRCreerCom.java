package fstm.projet.view;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.bson.NewBSONDecoder;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import com.toedter.calendar.JDateChooser;

import fstm.projet.controller.Diagnostic_CTR;
import fstm.projet.model.bo.Diagnostic;

import javax.ejb.HomeHandle;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class FRCreerCom extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JRadioButton rdbtnNewRadioButton_1;
	private JRadioButton rdbtnNewRadioButton;
	private JDateChooser dateChooser;
	private JLabel lblNewLabel_5;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public FRCreerCom() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 729, 476);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nom");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(33, 59, 142, 25);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(293, 63, 242, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Prenom");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(37, 99, 155, 25);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(293, 103, 242, 25);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Sexe");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(37, 130, 128, 25);
		contentPane.add(lblNewLabel_2);
		
		rdbtnNewRadioButton = new JRadioButton("Femme");
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbtnNewRadioButton.setBounds(253, 134, 85, 21);
		contentPane.add(rdbtnNewRadioButton);
		
		rdbtnNewRadioButton_1 = new JRadioButton("Homme");
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbtnNewRadioButton_1.setBounds(389, 134, 103, 21);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JLabel lblDateDeNaissance = new JLabel("Date de naissance");
		lblDateDeNaissance.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDateDeNaissance.setBounds(35, 187, 204, 30);
		contentPane.add(lblDateDeNaissance);
		
		 dateChooser = new JDateChooser();
		dateChooser.setBounds(295, 187, 240, 30);
		contentPane.add(dateChooser);
		
		JLabel lblNewLabel_3 = new JLabel("Email");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3.setBounds(33, 231, 119, 30);
		contentPane.add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(295, 238, 240, 25);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Password");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_4.setBounds(37, 275, 140, 38);
		contentPane.add(lblNewLabel_4);
		
		textField_3 = new JTextField();
		textField_3.setBounds(295, 286, 240, 25);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("Ajouter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Calendar date;
				Boolean sexe = null;
				String nomString=textField.getText();
				String preString=textField_1.getText();
				if(rdbtnNewRadioButton.isSelected()==true) { sexe=true;}
				if(rdbtnNewRadioButton_1.isSelected()==true) { sexe=false;}
				date= (Calendar) dateChooser.getCalendar();
				String emailString =textField_2.getText();
				String passString=textField_3.getText();
		
			 try {
				Diagnostic_CTR.insertClient(nomString, preString, sexe, date, emailString, passString);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			 setVisible(false);
			 new Authen().setVisible(true);
				
				
				
				
			}
		});
		btnNewButton.setBounds(293, 355, 140, 38);
		contentPane.add(btnNewButton);
		
		lblNewLabel_5 = new JLabel("Creation du Compte");
		lblNewLabel_5.setForeground(Color.BLUE);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_5.setBounds(177, 10, 282, 28);
		contentPane.add(lblNewLabel_5);
	}
}
