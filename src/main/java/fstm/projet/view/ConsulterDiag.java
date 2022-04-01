package fstm.projet.view;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fstm.projet.controller.Diagnostic_CTR;
import fstm.projet.model.bo.Client;
import fstm.projet.model.bo.Diagnostic;


import javax.swing.JTable;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class ConsulterDiag extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private Client client;
	private DefaultTableModel model;
	  JButton button = new JButton();

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
		 table.getColumn("Option").setCellRenderer(new ButtonRenderer());
		    table.getColumn("Option").setCellEditor(new ButtonEditor(new JCheckBox()));
		contentPane.add(table);
		
		JButton btnNewButton = new JButton("nouveau diagnostic");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ClientSt(c).setVisible(true);;
			}
		});
		btnNewButton.setBounds(43, 222, 141, 31);
		contentPane.add(btnNewButton);
		 button.addActionListener(
			      new ActionListener()
			      {
			        public void actionPerformed(ActionEvent event)
			        {
			        	int idr=table.getSelectedRow();
			        	 String[] sexe = {"pdf", "docx", "excel"};
			        	    JOptionPane jop = new JOptionPane(), jop2 = new JOptionPane();
			 String nom = (String)jop.showInputDialog(null,  "Veuillez indiquer l'extenssion !","telecharger diagnostique", JOptionPane.QUESTION_MESSAGE, null,sexe, "choix");
			        	    Diagnostic_CTR.Telecharger_doc(nom,c,idr);
			        	    
			        	    new ConsulterDiag(c).setVisible(true);
			        	    
			        	    
			        	  
							
			        	    //jop2.showMessageDialog(null, "Votre sexe est " + nom, "Etat civil", JOptionPane.INFORMATION_MESSAGE);
			        }
			      }
			    );
	}
	 
	 class ButtonRenderer extends JButton implements TableCellRenderer 
	  {
	    public ButtonRenderer() {
	      setOpaque(true);
	    }

	    public Component getTableCellRendererComponent(JTable table, Object value,
	    boolean isSelected, boolean hasFocus, int row, int column) {
	      setText((value == null) ? "Telecharger" : value.toString());
	      return this;
	    }
	  }

	  class ButtonEditor extends DefaultCellEditor 
	  {
	    private String label;
	    
	    public ButtonEditor(JCheckBox checkBox)
	    {
	      super(checkBox);
	    }

	    public Component getTableCellEditorComponent(JTable table, Object value,
	    boolean isSelected, int row, int column) 
	    {
	      label = (value == null) ? "Telecharger" : value.toString();
	      button.setText(label);
	      return button;
	    }

	    public Object getCellEditorValue() 
	    {
	      return new String(label);
	    }
	  }
	  
}

