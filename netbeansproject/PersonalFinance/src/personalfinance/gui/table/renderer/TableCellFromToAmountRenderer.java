/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personalfinance.gui.table.renderer;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;

/**
 *
 * @author Konstantin_Knyazev
 */
public class TableCellFromToAmountRenderer extends MainTableCellRenderer {
        
        private final Color color;

        public TableCellFromToAmountRenderer(Color color) {
            this.color = color;
        }
        
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component renderer = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                renderer.setForeground(color);
            return renderer;
        }
    }
