/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personalfinance.gui.table.renderer;

import java.awt.Component;
import javax.swing.JTable;
import personalfinance.settings.Style;

/**
 *
 * @author Konstantin_Knyazev
 */
public class TableCellAmountRenderer extends MainTableCellRenderer {
        
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component renderer = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
//            if(((Double) value)<0) {
            if (value.toString().contains("-")) {
                renderer.setForeground(Style.COLOR_EXP);
            } else {
                renderer.setForeground(Style.COLOR_INCOME);
            }
            return renderer;
        }
    }
