package fstm.projet.view;

import java.awt.Component;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;

class ButtonEditor extends DefaultCellEditor 
  {
	public ButtonEditor(JCheckBox checkBox) {
		super(checkBox);
		// TODO Auto-generated constructor stub
	}
	JButton button = new JButton();
    private String label;
    
   
    public Component getTableCellEditorComponent(JTable table, Object value,
    boolean isSelected, int row, int column) 
    {
      label = (value == null) ? "Modifier" : value.toString();
      button.setText(label);
      return button;
    }
    public Object getCellEditorValue() 
    {
      return new String(label);
    }
  }

