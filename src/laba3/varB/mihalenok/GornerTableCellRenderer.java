package laba3.varB.mihalenok;


import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
public class GornerTableCellRenderer implements TableCellRenderer {
    private JPanel panel = new JPanel();
    private JLabel label = new JLabel();
    private String needle = null;
    private DecimalFormat formatter = (DecimalFormat)NumberFormat.getInstance();

    public GornerTableCellRenderer() {
        formatter.setMaximumFractionDigits(3);
        formatter.setGroupingUsed(false);
        DecimalFormatSymbols dottedDouble = formatter.getDecimalFormatSymbols();
        dottedDouble.setDecimalSeparator('.');
        formatter.setDecimalFormatSymbols(dottedDouble);

        panel.add(label);
        panel.setLayout(new FlowLayout(FlowLayout.LEFT));

    }

    public Component getTableCellRendererComponent(JTable table,
                                                   Object value, boolean isSelected, boolean hasFocus, int row, int col) {
        if(col == 2){
            label.setText(String.valueOf(value));
            panel.setBackground(Color.white);
            return panel;
        }
        String formattedDouble = formatter.format(value);
        label.setText(formattedDouble);

        if (needle != null && needle.equals(formattedDouble)) {
            panel.setBackground(Color.RED);
        } else {

            panel.setBackground(Color.white);

            double num = Double.valueOf(label.getText());
            int i = 0;
            String str = String.valueOf(num);
            int val = 0;
            while(i < str.length() && str.charAt(i) != '.'){
                val += Integer.valueOf(str.charAt(i)) - Integer.valueOf('0');

                i++;
            }
            if(val % 10 == 0 && val != 0){
                panel.setBackground(Color.orange);
            } else {
                panel.setBackground(Color.white);
            }
        }

        return panel;
    }
    public void setNeedle(String needle) {
        this.needle = needle;
    }
}

