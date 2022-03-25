package fstm.projet.view;

   
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fstm.projet.controller.Diagnostic_CTR;
import fstm.projet.model.bo.Client;

import java.awt.Color;
import java.awt.Button;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Authen extends JFrame {

	private JPanel contentPane;
	private JTextField emailField;
	private JPasswordField textpasswd;
	
	int xx,xy;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
					Authen frame = new Authen();
					frame.setUndecorated(true);
					frame.setVisible(true);
	}	
	// going to borrow code from a gist to move frame.
	

	/**
	 * Create the frame.
	 */
	public Authen() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 729, 476);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 346, 490);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("tester");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setForeground(new Color(240, 248, 255));
		lblNewLabel.setBounds(139, 305, 84, 27);
		panel.add(lblNewLabel);
		
		JLabel label = new JLabel("");
		
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				 xx = e.getX();
			     xy = e.getY();
			}
		});
		label.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				
				int x = arg0.getXOnScreen();
	            int y = arg0.getYOnScreen();
	            Authen.this.setLocation(x - xx, y - xy);  
			}
		});
		label.setBounds(-38, 0, 420, 275);
		label.setVerticalAlignment(SwingConstants.TOP);
		//label.setIcon(new ImageIcon(Home.class.getResource("/images/im.png")));
		panel.add(label);
		
		JLabel lblWeGotYou = new JLabel("....Covid19....");
		lblWeGotYou.setHorizontalAlignment(SwingConstants.CENTER);
		lblWeGotYou.setForeground(new Color(240, 248, 255));
		lblWeGotYou.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblWeGotYou.setBounds(111, 343, 141, 27);
		panel.add(lblWeGotYou);
		
		emailField = new JTextField();
		emailField.setBounds(395, 83, 283, 36);
		contentPane.add(emailField);
		emailField.setColumns(10);
		
		JLabel buttonemail = new JLabel("EMAIL");
		buttonemail.setBounds(395, 58, 114, 14);
		contentPane.add(buttonemail);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setBounds(395, 144, 96, 14);
		contentPane.add(lblPassword);
		
		textpasswd = new JPasswordField();
		textpasswd.setBounds(395, 168, 283, 36);
		contentPane.add(textpasswd);
		
		JButton buttoncreercompte = new JButton("Creer Compte");
		buttoncreercompte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			new FRCreerCom().setVisible(true);	
				
				
			}
		});
		buttoncreercompte.setForeground(Color.BLACK);
		buttoncreercompte.setBackground(Color.GREEN);
		buttoncreercompte.setBounds(485, 283, 125, 36);
		contentPane.add(buttoncreercompte);
		
		JButton buttonsignup = new JButton("SignUp");
		buttonsignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 EmailValidator emailValidator = new EmailValidator();
				   if(!emailValidator.validate(emailField.getText().trim())) {
					   JOptionPane.showMessageDialog(null, "Invalid Email ID");
				        
				   }
				   else { 
				  String emailString =emailField.getText();
				  String passString=textpasswd.getText();
				  if(Diagnostic_CTR.authClient(emailString, passString)!=null)
					 // JOptionPane.showMessageDialog(null, "valide");
					  new CHoix((Client)Diagnostic_CTR.authClient(emailString, passString)).setVisible(true);
				  else {
				  JOptionPane.showMessageDialog(null, "invalide");}
				   }	   
			}
		});
		buttonsignup.setForeground(Color.BLACK);
		buttonsignup.setBackground(Color.RED);
		buttonsignup.setBounds(485, 226, 125, 36);
		contentPane.add(buttonsignup);
		
		Button buttonfermer = new Button("X");
		buttonfermer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});

		buttonfermer.setFont(new Font("Dialog", Font.BOLD, 16));
		buttonfermer.setForeground(new Color(255, 0, 0));
		buttonfermer.setBackground(Color.WHITE);
		buttonfermer.setBounds(689, 0, 26, 21);
		contentPane.add(buttonfermer);
	}
}