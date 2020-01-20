/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personalfinance.gui.table;

import java.awt.Color;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import personalfinance.gui.handler.FunctionsHandler;
import personalfinance.gui.table.model.CurrencyTableModel;
import personalfinance.gui.table.renderer.MainTableCellRenderer;
import personalfinance.model.Currency;
import personalfinance.settings.Style;
import personalfinance.settings.Text;

/**
 *
 * @author Konstantin_Knyazev
 */
public class CurrencyTableData extends TableData {

    private static final String[] columns = new String[]{"TITLE", "CODE", "RATE", "ON", "BASE"};

    private static final ImageIcon[] icons = new ImageIcon[]{Style.ICON_PANEL_TITLE, Style.ICON_PANEL_CODE, Style.ICON_PANEL_RATE, Style.ICON_PANEL_ON, Style.ICON_PANEL_BASE,};

    private static final String[] tooltips = new String[]{"TOOL_TIP_RIGHT_PANEL_CURRENCY_CH_TITLE",
        "TOOL_TIP_RIGHT_PANEL_CURRENCY_CH_CODE",
        "TOOL_TIP_RIGHT_PANEL_CURRENCY_CH_RATE",
        "TOOL_TIP_RIGHT_PANEL_CURRENCY_CH_ON",
        "TOOL_TIP_RIGHT_PANEL_CURRENCY_CH_BASE"};

    public CurrencyTableData(FunctionsHandler handler) {
        super(new CurrencyTableModel(columns), 
                handler,
                columns, 
                icons, 
                tooltips
        );
        init();
    }

//    опеделим визуальную разницу для включенной и выключенной валюты
    @Override
    protected final void init() {
        for (String column : columns) {
            getColumn(Text.get(column)).setCellRenderer(new TableCellOnOffCurrencyRenderer());
        }

    }

    private class TableCellOnOffCurrencyRenderer extends MainTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component renderer = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            Color backgroundColor = renderer.getBackground();

            if (((Currency) ((CurrencyTableModel) table.getModel()).getCommonObjectByRow(row)).isOn()) {
                renderer.setForeground(Style.COLOR_ON);
                if (((Currency) ((CurrencyTableModel) table.getModel()).getCommonObjectByRow(row)).isBase()&&(column == 4)) {
                    renderer.setForeground(Style.COLOR_BASE);
                }
            } else {
                renderer.setForeground(Style.COLOR_OFF);

            }
//            if () {
//                
//            }
            return renderer;
        }
    }
}
