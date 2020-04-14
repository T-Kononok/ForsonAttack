import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class MyTableModel extends AbstractTableModel {

    private ArrayList<ArrayList<String>> matr;

    MyTableModel(ArrayList<ArrayList<String>> matr) {
        this.matr = matr;
    }

    public int getColumnCount() {
        if (matr != null) {
            return matr.get(0).size();
        }
        else
            return 0;
    }
    public int getRowCount() {
        if (matr != null)
            return matr.size();
        else
            return 0;
    }
    public Object getValueAt(int row, int col) {
        if (matr != null) {
            return matr.get(row).get(col);
        }
        else
            return 0;
    }
    public String getColumnName(int col) {
        return "";
    }
    public Class<?> getColumnClass(int col) {
        return String.class;
    }
}

