/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personalfinance.gui.table;

import javax.swing.ImageIcon;
import personalfinance.gui.handler.FunctionsHandler;
import personalfinance.gui.table.model.TransfersTableModel;
import personalfinance.gui.table.renderer.TableCellFromToAmountRenderer;
import personalfinance.settings.Style;
import personalfinance.settings.Text;

/**
 *
 * @author Konstantin_Knyazev
 */
public class TransferTableData extends TableData {
    
    private static final String[] columns = new String[]{"DATE", "FROM_ACCOUNT","TO_ACCOUNT", "FROM_AMOUNT","TO_AMOUNT", "NOTICE"};
    
    private static final ImageIcon[] icons = new ImageIcon[]{Style.ICON_PANEL_CALENDAR, Style.ICON_PANEL_ACCOUNT, Style.ICON_PANEL_ACCOUNT, Style.ICON_PANEL_AMOUNT,Style.ICON_PANEL_AMOUNT, Style.ICON_PANEL_NOTICE};
    
    private static final String[] tooltips = new String[]{"TOOL_TIP_RIGHT_PANEL_TRANSFERS_CH_DATE",
                                                          "TOOL_TIP_RIGHT_PANEL_TRANSFERS_CH_FROM_ACCOUNT","TOOL_TIP_RIGHT_PANEL_TRANSFERS_CH_TO_ACCOUNT",
                                                          "TOOL_TIP_RIGHT_PANEL_TRANSFERS_CH_FROM_AMOUNT","TOOL_TIP_RIGHT_PANEL_TRANSFERS_CH_TO_AMOUNT",
                                                          "TOOL_TIP_RIGHT_PANEL_TRANSACTIONS_CH_NOTICE"};
    
    
    public TransferTableData(FunctionsHandler handler) {
        super(new TransfersTableModel(columns), 
                handler,
                columns, 
                icons,
                tooltips
        );
        init();
    }
    
    

//    опеделим визуальную разницу для списания и зачисления
    @Override
    protected final void init() {
        getColumn(Text.get("FROM_AMOUNT")).setCellRenderer(new  TableCellFromToAmountRenderer(Style.COLOR_EXP));        
        getColumn(Text.get("TO_AMOUNT")).setCellRenderer(new  TableCellFromToAmountRenderer(Style.COLOR_INCOME));        
    }
}
