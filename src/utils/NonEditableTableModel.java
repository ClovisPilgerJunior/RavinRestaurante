package utils;
import javax.swing.table.DefaultTableModel;
public class NonEditableTableModel extends DefaultTableModel{
  public NonEditableTableModel(Object[][] data, Object[] columnNames) {
    super(data, columnNames);
  }

  // Sobrescreva o método isCellEditable para tornar todas as células não editáveis.
  @Override
  public boolean isCellEditable(int row, int column) {
    return false;
  }
}
