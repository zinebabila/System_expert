package fstm.projet.view;

import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fstm.projet.controller.Diagnostic_CTR;
import fstm.projet.model.*;
import fstm.projet.model.bo.Client;
import fstm.projet.model.bo.Region;

import com.toedter.calendar.JDateChooser;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

public class ClientSt extends JFrame {
	
	 public ClientSt() { initComponents();}

	    @SuppressWarnings("unchecked")
	    private void initComponents() {

	        jOptionPane1 = new javax.swing.JOptionPane();
	        jPanel1 = new javax.swing.JPanel();
	        jLabel6 = new javax.swing.JLabel();
	        jLabel1 = new javax.swing.JLabel();
	        jLabel2 = new javax.swing.JLabel();
	        jLabel3 = new javax.swing.JLabel();
	        jComboBox1 = new javax.swing.JComboBox<>();
	        jTextField2 = new javax.swing.JTextField();
	        jTextField2.setText("");
	        jButton1 = new javax.swing.JButton();
	        jButton1.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		try {
	        			T= Double.parseDouble(jTextField2.getText());	
	        			date= (Calendar) jDateChooser1.getCalendar();
	          		    Client c= new Client(1,"Ahbella","Houda",true, T,   r, date,"houda@gmail.com","houda123");
	          		    Diagnostic_CTR.insertClient(c);
	  				if(r==null)
	  				{
	  				  JOptionPane.showMessageDialog(jButton1, "Vous n'avez pas précisez la région", "Warnings", JOptionPane.ERROR_MESSAGE);
	  				}
	  				else if(T<38){
	  					JOptionPane.showMessageDialog(jButton1, "Vous n'etes pas malade", "Warnings", JOptionPane.ERROR_MESSAGE);
	  				}
	  				else if(c.getage()==-1)
	  					JOptionPane.showMessageDialog(jButton1, "date de naissance invalide", "Warnings", JOptionPane.ERROR_MESSAGE);
	  				else
	  				{
	  					new Diagnostic_CTR(c);
	  				}
	        		}
	        		catch(Exception EX) {
	        			JOptionPane.showMessageDialog(jButton1, "Temperature invalide ", "Warnings", JOptionPane.ERROR_MESSAGE);
	        			System.out.println(EX.toString());
	        		 }
	        	}
	        });
	        jDateChooser1 = new com.toedter.calendar.JDateChooser();

	        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

	        jPanel1.setBackground(new java.awt.Color(102, 102, 255));

	        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
	        jLabel6.setText("COVID 19");

	        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
	        jPanel1.setLayout(jPanel1Layout);
	        jPanel1Layout.setHorizontalGroup(
	            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	            );
	        jPanel1Layout.setVerticalGroup(
	            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addGap(55, 55, 55)
	                .addComponent(jLabel6)
	                .addContainerGap(56, Short.MAX_VALUE))
	        );

	        jLabel1.setText("Temperature");
	        jLabel2.setText("Date de naissance");
	        jLabel3.setText("Region");
	        	DefaultComboBoxModel<Region> M = new DefaultComboBoxModel<Region>();
	        ArrayList<Region> regions = Diagnostic_CTR.afficheRe();
	    
	        M.addAll(regions);
	        jComboBox1.setModel(M);
	        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jComboBox1ActionPerformed(evt);
	                JComboBox<Region> x = (JComboBox<Region>)evt.getSource();
	                r =(Region) x.getSelectedItem();
	                System.out.println(r);
	            }
	        });

	        jButton1.setText("suivant");

	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	        layout.setHorizontalGroup(
	        	layout.createParallelGroup(Alignment.LEADING)
	        		.addGroup(layout.createSequentialGroup()
	        			.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	        			.addPreferredGap(ComponentPlacement.RELATED)
	        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
	        				.addGroup(layout.createSequentialGroup()
	        					.addGap(150)
	        					.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
	        					.addGap(0, 156, Short.MAX_VALUE))
	        				.addGroup(layout.createSequentialGroup()
	        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
	        						.addGroup(layout.createSequentialGroup()
	        							.addGap(157)
	        							.addComponent(jButton1))
	        						.addGroup(layout.createSequentialGroup()
	        							.addGap(136)
	        							.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE))
	        						.addGroup(layout.createSequentialGroup()
	        							.addGap(90)
	        							.addGroup(layout.createParallelGroup(Alignment.LEADING)
	        								.addComponent(jDateChooser1, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE)
	        								.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
	        									.addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE)
	        									.addComponent(jTextField2)))))
	        					.addContainerGap(106, Short.MAX_VALUE))
	        				.addGroup(layout.createSequentialGroup()
	        					.addPreferredGap(ComponentPlacement.RELATED, 164, Short.MAX_VALUE)
	        					.addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
	        					.addGap(151))))
	        );
	        layout.setVerticalGroup(
	        	layout.createParallelGroup(Alignment.TRAILING)
	        		.addGroup(Alignment.LEADING, layout.createSequentialGroup()
	        			.addGap(39)
	        			.addComponent(jLabel1)
	        			.addPreferredGap(ComponentPlacement.RELATED)
	        			.addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	        			.addGap(23)
	        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
	        				.addGroup(layout.createSequentialGroup()
	        					.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	        					.addContainerGap())
	        				.addGroup(layout.createSequentialGroup()
	        					.addComponent(jLabel2)
	        					.addPreferredGap(ComponentPlacement.RELATED)
	        					.addComponent(jDateChooser1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	        					.addGap(15)
	        					.addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
	        					.addPreferredGap(ComponentPlacement.RELATED)
	        					.addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	        					.addPreferredGap(ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
	        					.addComponent(jButton1)
	        					.addGap(85))))
	        );
	        getContentPane().setLayout(layout);

	        pack();
	    }// </editor-fold>//GEN-END:initComponents

	    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
	        // TODO add your handling code here:
	    }

	    
	    public static void main(String args[]) {
	        try {
	            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
	                if ("Nimbus".equals(info.getName())) {
	                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
	                    break;
	                }
	            }
	        } catch (ClassNotFoundException ex) {
	            java.util.logging.Logger.getLogger(ClientSt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (InstantiationException ex) {
	            java.util.logging.Logger.getLogger(ClientSt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (IllegalAccessException ex) {
	            java.util.logging.Logger.getLogger(ClientSt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
	            java.util.logging.Logger.getLogger(ClientSt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        }
	        //</editor-fold>

	        /* Create and display the form */
	        java.awt.EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                new ClientSt().setVisible(true); }});}
	    private Region r = null;
	    double T;
	    Calendar date;
	    private JButton jButton1;
	    private javax.swing.JComboBox<Region> jComboBox1;
	    private JDateChooser jDateChooser1;
	    private javax.swing.JLabel jLabel1;
	    private javax.swing.JLabel jLabel2;
	    private javax.swing.JLabel jLabel3;
	    private javax.swing.JLabel jLabel6;
	    private javax.swing.JOptionPane jOptionPane1;
	    private javax.swing.JPanel jPanel1;
	    private javax.swing.JTextField jTextField2;

}
