package fstm.projet.view;

import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	          		    Client c= new Client(1,"Ahbella","Houda",true, T,   r, date);
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
	        Vector<Region> regions = new Vector<Region>();
	    	Region r1=new Region("Tanger-Tétouan-Al Hoceïma",1);regions.add(r1);
	    	r1.setNombre_contamines(600); r1.setNombre_deces(77); r1.setNombre_geuris(200); r1.setNombre_habitant(100000);
	    	
	    	Region r2=new Region("L'Oriental",2); regions.add(r2);
	    	r2.setNombre_contamines(600); r2.setNombre_deces(77); r2.setNombre_geuris(200); r2.setNombre_habitant(100000);
	    	
	    	Region r3=new Region("Fès-Meknès",3);
	    	regions.add(r3);
	    	r3.setNombre_contamines(600); r3.setNombre_deces(77); r3.setNombre_geuris(200); r3.setNombre_habitant(100000);
	    	
	    	Region r4=new Region("Rabat-Salé-Kénitra",4);
	    	regions.add(r4);
	    	r4.setNombre_contamines(600); r4.setNombre_deces(77); r4.setNombre_geuris(200); r4.setNombre_habitant(100000);
	    	
	    	Region r5=new Region("Béni Mellal-Khénifra",5);
	    	regions.add(r5);
	    	r5.setNombre_contamines(600); r5.setNombre_deces(77); r5.setNombre_geuris(200); r5.setNombre_habitant(100000);
	    	
	    	Region r6=new Region("Casablanca-Settat",6);
	    	regions.add(r6);
	    	r6.setNombre_contamines(600); r6.setNombre_deces(77); r6.setNombre_geuris(200); r6.setNombre_habitant(100000);
	    	
	    	Region r7=new Region("Marrakech-Safi",7);
	    	regions.add(r7);
	    	r1.setNombre_contamines(600); r7.setNombre_deces(77); r7.setNombre_geuris(200); r7.setNombre_habitant(100000);
	    	
	    	Region r8=new Region("Drâa-Tafilalet",8);
	    	regions.add(r8);
	    	r1.setNombre_contamines(600); r8.setNombre_deces(77); r8.setNombre_geuris(200); r8.setNombre_habitant(100000);
	    	
	    	Region r9=new Region("Souss-Massa",9);
	    	regions.add(r9);
	    	r1.setNombre_contamines(600); r9.setNombre_deces(77); r9.setNombre_geuris(200); r9.setNombre_habitant(100000);
	    	
	    	Region r10=new Region("Guelmim-Oued Noun",10);
	    	regions.add(r10);
	    	r1.setNombre_contamines(600); r10.setNombre_deces(77); r10.setNombre_geuris(200); r10.setNombre_habitant(100000);
	    	
	    	Region r11=new Region("Laâyoune-Sakia El Hamra",11);
	    	regions.add(r11);
	    	r1.setNombre_contamines(600); r11.setNombre_deces(77); r11.setNombre_geuris(200); r11.setNombre_habitant(100000);
	    	
	    	Region r12=new Region("Dakhla-Oued Ed-Dahab",12);
	    	regions.add(r12);
	    	r1.setNombre_contamines(600); r12.setNombre_deces(77); r12.setNombre_geuris(200); r12.setNombre_habitant(100000);
	    	
	  
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
