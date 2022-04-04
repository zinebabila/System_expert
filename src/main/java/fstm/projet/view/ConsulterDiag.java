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
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

public class ConsulterDiag extends JFrame {

    private final JTable table;
    JButton button = new JButton();


    /**
     * Create the frame.
     */

    public ConsulterDiag(Client c) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 729, 476);
        JPanel contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        table = new JTable();


        DefaultTableModel model = new DefaultTableModel();
        Object[] coloStrings = {"Date", "Resultat", "Option"};

        model.setColumnIdentifiers(coloStrings);

        model.addRow(new String[]{"Date", "Resultat", "Option"});

        Diagnostic_CTR.rempliTable(model, c);
        table.setModel(model);
        table.setBounds(32, 100, 634, 213);
        table.getColumn("Option").setCellRenderer(new ButtonRenderer());
        table.getColumn("Option").setCellEditor(new ButtonEditor(new JCheckBox()));
        contentPane.add(table);

        JButton btnNewButton = new JButton("nouveau diagnostic");
        btnNewButton.setBackground(Color.BLUE);
        btnNewButton.setForeground(Color.WHITE);
        btnNewButton.addActionListener(e -> new ClientSt(c).setVisible(true));
        btnNewButton.setBounds(262, 355, 222, 31);
        contentPane.add(btnNewButton);
        
        JLabel lblNewLabel = new JLabel("Mes diagnostic");
        lblNewLabel.setBackground(Color.WHITE);
        lblNewLabel.setForeground(Color.BLUE);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
        lblNewLabel.setBounds(213, 30, 277, 31);
        contentPane.add(lblNewLabel);
        
        JButton btnNewButton_1 = new JButton("Retour");
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		setVisible(false);
        		new CHoix(c).setVisible(true);
        	}
        });
        btnNewButton_1.setBackground(Color.BLUE);
        btnNewButton_1.setForeground(Color.WHITE);
        btnNewButton_1.setBounds(563, 396, 103, 21);
        contentPane.add(btnNewButton_1);
        button.addActionListener(
                event -> {
                    int idr = table.getSelectedRow();
                    String[] sexe = {"pdf", "docx", "excel"};
                    JOptionPane jop = new JOptionPane(), jop2 = new JOptionPane();
                    String nom = (String) JOptionPane.showInputDialog(null, "Veuillez indiquer l'extenssion !", "telecharger diagnostique", JOptionPane.QUESTION_MESSAGE, null, sexe, "choix");
                    Diagnostic_CTR.Telecharger_doc(nom, c, idr);

                    new ConsulterDiag(c).setVisible(true);


                    //jop2.showMessageDialog(null, "Votre sexe est " + nom, "Etat civil", JOptionPane.INFORMATION_MESSAGE);
                }
        );
    }

    static class ButtonRenderer extends JButton implements TableCellRenderer {
        public ButtonRenderer() {
            setOpaque(true);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                                                       boolean isSelected, boolean hasFocus, int row, int column) {
            setText((value == null) ? "Telecharger" : value.toString());
            return this;
        }
    }

    class ButtonEditor extends DefaultCellEditor {
        private String label;

        public ButtonEditor(JCheckBox checkBox) {
            super(checkBox);
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value,
                                                     boolean isSelected, int row, int column) {
            label = (value == null) ? "Telecharger" : value.toString();
            button.setText(label);
            return button;
        }

        @Override
        public Object getCellEditorValue() {
            return label;
        }
    }
}