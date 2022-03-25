package fstm.projet.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.util.Vector;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;

import fstm.projet.controller.Diagnostic_CTR;
import fstm.projet.model.bo.Client;
import fstm.projet.model.bo.DroolsTest;
import fstm.projet.model.bo.Maladie_chronique;
import fstm.projet.model.bo.Symptoms;

import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.Color;

public class Acueil extends JFrame {

	   private Client myclient;
	   private javax.swing.ButtonGroup buttonGroup1;
	    private javax.swing.JButton jButton1;
	    private javax.swing.JButton jButton2;
	    private javax.swing.JButton jButton3;
	    private javax.swing.JButton jButton4;
	    private javax.swing.JButton jButton5;
	    private javax.swing.JLabel jLabel1;
	    private javax.swing.JLabel jLabel2;
	    private JList<Symptoms> jList1;
	    private javax.swing.JList<Symptoms> jList2;
	    private javax.swing.JMenu jMenu1;
	    private javax.swing.JMenu jMenu2;
	    private javax.swing.JMenu jMenu3;
	    private javax.swing.JMenuBar jMenuBar1;
	    private javax.swing.JMenuItem jMenuItem2;
	    private javax.swing.JMenuItem jMenuItem3;
	    private javax.swing.JRadioButton jRadioButton1;
	    private javax.swing.JRadioButton jRadioButton2;
	    private javax.swing.JRadioButton jRadioButton3;
	    private javax.swing.JScrollPane jScrollPane1;
	    private javax.swing.JScrollPane jScrollPane2;
	    private DefaultListModel<Symptoms> m;
	    DefaultListModel<Symptoms> m2;
	    public static JLabel Resul;
	
	    public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					/*try {
						Acueil frameSymp = new Acueil();
						frameSymp.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}*/
				}
			});
		}

    

    public Acueil(fstm.projet.model.bo.Client c) {
		// TODO Auto-generated constructor stub
    	myclient=c;
    	initComponents();
	}

	private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<Symptoms>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        m = new DefaultListModel<Symptoms>();
        m.addAll(Diagnostic_CTR.afficheSy());
        jList1.setModel(m);
        jScrollPane1.setViewportView(jList1);
        m2 = new DefaultListModel<>();
        jList2.setModel(m2);
        jScrollPane2.setViewportView(jList2);

        jButton1.setText(">>");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("<");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("<<");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Diagoniser");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel1.setText("List des symptoms:");

        jButton5.setText(">");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jRadioButton1.setText("Hypertendu");

        jRadioButton2.setText("Cardiaque");

        jRadioButton3.setText("diab�tique");

        jLabel2.setText("Le resultat de votre diagnostique:");

        jMenu1.setText("File");

        jMenuItem2.setText("jMenuItem2");
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("jMenuItem3");
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("jMenu3");
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);
        
        Resul = new JLabel("");
        Resul.setForeground(Color.RED);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap(194, Short.MAX_VALUE)
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(jRadioButton1)
        					.addGap(71)
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addGroup(layout.createSequentialGroup()
        							.addComponent(jRadioButton2)
        							.addGap(46)
        							.addComponent(jRadioButton3, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE))
        						.addComponent(jButton4))
        					.addGap(90))
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE)
        					.addGap(18)
        					.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        						.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        							.addComponent(jButton2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        							.addComponent(jButton5, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
        							.addComponent(jButton3, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        						.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
        					.addGap(18)
        					.addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)
        					.addGap(42))
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(jLabel1)
        					.addGap(229))))
        		.addGroup(layout.createSequentialGroup()
        			.addGap(210)
        			.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
        			.addGap(42)
        			.addComponent(Resul, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(217, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jLabel1)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 263, GroupLayout.PREFERRED_SIZE)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(jButton1)
        					.addGap(18)
        					.addComponent(jButton5)
        					.addGap(18)
        					.addComponent(jButton2)
        					.addGap(18)
        					.addComponent(jButton3)))
        			.addPreferredGap(ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jRadioButton1)
        				.addComponent(jRadioButton2)
        				.addComponent(jRadioButton3))
        			.addGap(18)
        			.addComponent(jButton4)
        			.addGap(18)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        				.addComponent(Resul, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(jLabel2, GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE))
        			.addGap(46))
        );
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(ActionEvent evt) {
        for(Symptoms o: jList2.getSelectedValuesList()){
            m.addElement(o);
        }
        for(int i: jList2.getSelectedIndices()){
            m2.remove(i);
        }
    }
   
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
       Vector<Maladie_chronique> malad=new Vector<Maladie_chronique>();
       Vector<Symptoms> listSelectionner = new Vector<Symptoms>();
       
        for (int i=0; i<m2.getSize();i++){
            listSelectionner.add(m2.getElementAt(i));
        }
        if(jRadioButton1.isSelected()){
        	malad.add(new Maladie_chronique(1,"Hypertendu"));
        }
        if(jRadioButton2.isSelected()){
        	malad.add(new Maladie_chronique(2,"Cardiaque"));
        }
        if(jRadioButton3.isSelected()){
        	malad.add(new Maladie_chronique(3,"diabatique"));
        }
       
      Diagnostic_CTR.diagoniser(myclient, listSelectionner, malad);
		
		/*Resul.setText(resu*100 + " %100");
		if(d.isEnvoy()==true)
		JOptionPane.showMessageDialog(jButton4, "possibilite de presence : " 
		+ resu*100 + " %100 vous etes une cas d'urgence !! vos informations ont envoyées aux autorités comptétentes",
		"Diagnostic", JOptionPane.INFORMATION_MESSAGE);
		else JOptionPane.showMessageDialog(jButton4, "possibilite de presence : " 
				+ resu*100 + " %100","Diagnostic", JOptionPane.INFORMATION_MESSAGE);*/
        
		

    }
   
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        //System.out.println(jList1.getSelectedValuesList());
        //System.out.println(jList2.getSelectedValuesList());
        for(Symptoms o: jList1.getSelectedValuesList()){
            m2.addElement(o);
        }
        for(int i: jList1.getSelectedIndices()){
            m.remove(i);
        }
    }
    
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        for (int i=0; i<m2.getSize();i++){
            m.addElement(m2.getElementAt(i));
        }
        m2.clear();
    }//GEN-LAST:event_jButton3ActionPerformed

    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

            for (int i=0; i<m.getSize();i++){
                m2.addElement(m.getElementAt(i));
            }
            m.clear();


    }//GEN-LAST:event_jButton1ActionPerformed
}
